import React, { useState } from 'react';

const officeSpaces = [
    { id: 1, name: 'Co-Working Space', rent: 500, img: 'https://picsum.photos/id/101/200/150' },
    { id: 2, name: 'Private Cabin', rent: 1200, img: 'https://picsum.photos/id/102/200/150' },
    { id: 3, name: 'Meeting Room', rent: 800, img: 'https://picsum.photos/id/103/200/150' },
];

function OfficeCard({ office }) {
    const [rented, setRented] = useState(false);

    return (
        <div style={{ border: '1px solid #ccc', padding: '15px', margin: '15px', width: '220px', textAlign: 'center' }}>
            <img src={office.img} alt={office.name} style={{ width: '100%', height: '150px', objectFit: 'cover' }} />
            <h3>{office.name}</h3>
            <p>Rent: ${office.rent} / month</p>
            <button 
                onClick={() => setRented(!rented)}
                style={{
                    backgroundColor: rented ? 'red' : 'green',
                    color: 'white',
                    padding: '8px 15px',
                    border: 'none',
                    cursor: 'pointer'
                }}>
                {rented ? 'Rented' : 'Rent Now'}
            </button>
        </div>
    );
}

export default function OfficeSpaceRentalApp() {
    return (
        <div>
            <h2>Office Space Rental App</h2>
            <div style={{ display: 'flex', flexWrap: 'wrap' }}>
                {officeSpaces.map(space => (
                    <OfficeCard key={space.id} office={space} />
                ))}
            </div>
        </div>
    );
}
