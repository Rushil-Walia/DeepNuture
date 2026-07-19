import React, { useState, useEffect } from 'react';
import axios from 'axios';

export default function FetchUserApp() {
    const [users, setUsers] = useState([]);
    const [error, setError] = useState(null);

    useEffect(() => {
        axios.get('https://jsonplaceholder.typicode.com/users')
            .then(response => {
                setUsers(response.data);
            })
            .catch(err => {
                setError('Failed to fetch users');
            });
    }, []);

    return (
        <div>
            <h2>Fetch User App (Axios)</h2>
            {error && <p data-testid="error-msg">{error}</p>}
            <ul>
                {users.map(user => (
                    <li key={user.id} data-testid="user-item">{user.name}</li>
                ))}
            </ul>
        </div>
    );
}
