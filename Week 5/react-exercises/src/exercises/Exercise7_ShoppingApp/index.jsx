import React from 'react';

function Cart({ items }) {
    const total = items.reduce((acc, item) => acc + item.price, 0);

    return (
        <div style={{ border: '1px solid black', padding: '20px', width: '300px' }}>
            <h3>Cart Component</h3>
            <ul>
                {items.map((item, index) => (
                    <li key={index}>{item.name}: ${item.price}</li>
                ))}
            </ul>
            <hr />
            <h4>Total Price: ${total}</h4>
        </div>
    );
}

function OnlineShopping() {
    const cartItems = [
        { name: 'Laptop', price: 1200 },
        { name: 'Mouse', price: 25 },
        { name: 'Keyboard', price: 75 }
    ];

    return (
        <div>
            <h2>Online Shopping (Parent Component)</h2>
            <Cart items={cartItems} />
        </div>
    );
}

export default function ShoppingApp() {
    return <OnlineShopping />;
}
