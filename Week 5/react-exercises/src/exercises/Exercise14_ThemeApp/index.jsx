import React, { createContext, useContext, useState } from 'react';

const ThemeContext = createContext();

function ThemeToggler() {
    const { theme, toggleTheme } = useContext(ThemeContext);
    return (
        <button onClick={toggleTheme} style={{ margin: '20px', padding: '10px' }}>
            Switch to {theme === 'light' ? 'Dark' : 'Light'} Theme
        </button>
    );
}

function ThemedComponent() {
    const { theme } = useContext(ThemeContext);
    const styles = {
        light: { backgroundColor: '#ffffff', color: '#000000', padding: '50px', border: '1px solid black' },
        dark: { backgroundColor: '#333333', color: '#ffffff', padding: '50px', border: '1px solid white' }
    };

    return (
        <div style={styles[theme]}>
            <h2>This is a themed component</h2>
            <p>Current Theme: <strong>{theme}</strong></p>
        </div>
    );
}

export default function ThemeApp() {
    const [theme, setTheme] = useState('light');

    const toggleTheme = () => {
        setTheme(prev => prev === 'light' ? 'dark' : 'light');
    };

    return (
        <ThemeContext.Provider value={{ theme, toggleTheme }}>
            <div>
                <h2>Theme App (Context API)</h2>
                <ThemeToggler />
                <ThemedComponent />
            </div>
        </ThemeContext.Provider>
    );
}
