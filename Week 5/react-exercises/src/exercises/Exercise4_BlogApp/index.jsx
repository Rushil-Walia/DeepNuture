import React, { Component } from 'react';

class Posts extends Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
            error: null
        };
    }

    componentDidMount() {
        this.loadPosts();
    }

    loadPosts() {
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => response.json())
            .then(data => this.setState({ posts: data.slice(0, 10) })) // Limit to 10 for display
            .catch(error => this.setState({ error: error.message }));
    }

    render() {
        if (this.state.error) {
            return <div>Error loading posts: {this.state.error}</div>;
        }

        return (
            <div>
                {this.state.posts.map(post => (
                    <div key={post.id} style={{ border: '1px solid gray', margin: '10px', padding: '10px' }}>
                        <h3>{post.title}</h3>
                        <p>{post.body}</p>
                    </div>
                ))}
            </div>
        );
    }
}

class ErrorBoundary extends Component {
    constructor(props) {
        super(props);
        this.state = { hasError: false };
    }

    componentDidCatch(error, info) {
        this.setState({ hasError: true });
        console.error("Caught error:", error, info);
    }

    render() {
        if (this.state.hasError) {
            return <h2>Something went wrong in the application.</h2>;
        }
        return this.props.children;
    }
}

export default function BlogApp() {
    return (
        <div>
            <h2>Blog App (Lifecycle Hooks & Error Boundaries)</h2>
            <ErrorBoundary>
                <Posts />
            </ErrorBoundary>
        </div>
    );
}
