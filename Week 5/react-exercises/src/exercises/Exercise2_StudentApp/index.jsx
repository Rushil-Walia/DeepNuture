import React, { Component } from 'react';

class Home extends Component {
    render() {
        return <h3>Welcome to the Home page of Student Management Portal</h3>;
    }
}

class About extends Component {
    render() {
        return <h3>Welcome to the About page of the Student Management Portal</h3>;
    }
}

class Contact extends Component {
    render() {
        return <h3>Welcome to the Contact page of the Student Management Portal</h3>;
    }
}

export default class StudentApp extends Component {
    render() {
        return (
            <div>
                <h2>Student Management Portal</h2>
                <Home />
                <About />
                <Contact />
            </div>
        );
    }
}
