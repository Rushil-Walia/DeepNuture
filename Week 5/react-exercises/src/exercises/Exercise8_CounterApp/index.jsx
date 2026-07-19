import React, { useState } from 'react';

export default function CounterApp() {
    const [count, setCount] = useState(0);

    return (
        <div style={{ textAlign: 'center', marginTop: '50px' }}>
            <h2>Counter App</h2>
            <h1>{count}</h1>
            <button onClick={() => setCount(count + 1)} style={{ marginRight: '10px', padding: '10px 20px' }}>
                Increment
            </button>
            <button onClick={() => setCount(count - 1)} style={{ padding: '10px 20px' }}>
                Decrement
            </button>
        </div>
    );
}
