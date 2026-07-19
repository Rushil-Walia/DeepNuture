import React, { useRef, useState } from 'react';

export default function BloggerApp() {
    const titleRef = useRef(null);
    const authorRef = useRef(null);
    const contentRef = useRef(null);
    
    const [posts, setPosts] = useState([]);

    const handlePublish = (e) => {
        e.preventDefault();
        const newPost = {
            title: titleRef.current.value,
            author: authorRef.current.value,
            content: contentRef.current.value
        };
        setPosts([...posts, newPost]);
        
        // Clear fields
        titleRef.current.value = '';
        authorRef.current.value = '';
        contentRef.current.value = '';
    };

    return (
        <div>
            <h2>Blogger App (Uncontrolled Component)</h2>
            <form onSubmit={handlePublish} style={{ display: 'flex', flexDirection: 'column', width: '400px', gap: '10px' }}>
                <label>
                    Post Title:
                    <input type="text" ref={titleRef} style={{ width: '100%' }} required />
                </label>
                <label>
                    Author:
                    <input type="text" ref={authorRef} style={{ width: '100%' }} required />
                </label>
                <label>
                    Content:
                    <textarea ref={contentRef} rows="5" style={{ width: '100%' }} required></textarea>
                </label>
                <button type="submit">Publish</button>
            </form>

            <div style={{ marginTop: '30px' }}>
                <h3>Published Posts</h3>
                {posts.length === 0 ? <p>No posts yet.</p> : (
                    posts.map((post, index) => (
                        <div key={index} style={{ border: '1px solid gray', padding: '15px', marginBottom: '15px' }}>
                            <h4>{post.title}</h4>
                            <h5>By {post.author}</h5>
                            <p>{post.content}</p>
                        </div>
                    ))
                )}
            </div>
        </div>
    );
}
