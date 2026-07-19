import React, { useState } from 'react';

export default function MailRegisterApp() {
    const [email, setEmail] = useState('');
    const [registeredEmail, setRegisteredEmail] = useState('');

    const handleRegister = () => {
        setRegisteredEmail(email);
        setEmail('');
    };

    return (
        <div>
            <h2>Mail Register App</h2>
            <div>
                <input 
                    type="email" 
                    placeholder="Enter email ID" 
                    value={email} 
                    onChange={(e) => setEmail(e.target.value)}
                    data-testid="email-input"
                />
                <button onClick={handleRegister} data-testid="register-button" style={{ marginLeft: '10px' }}>
                    Register
                </button>
            </div>
            {registeredEmail && (
                <div style={{ marginTop: '20px' }}>
                    <p data-testid="registered-email">Registered Email: {registeredEmail}</p>
                </div>
            )}
        </div>
    );
}
