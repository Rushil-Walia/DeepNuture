import React from 'react';

function OddPlayers({ player }) {
    return <li>{player}</li>;
}

function EvenPlayers({ player }) {
    return <li>{player}</li>;
}

export default function CricketApp() {
    const players = ['Sachin', 'Dhoni', 'Kohli', 'Rohit', 'Yuvraj', 'Raina'];

    return (
        <div>
            <h2>Cricket Players List</h2>
            <div style={{ display: 'flex', gap: '50px' }}>
                <div>
                    <h3>Odd Index Players</h3>
                    <ul>
                        {players.map((player, index) => {
                            if (index % 2 !== 0) {
                                return <OddPlayers key={index} player={player} />;
                            }
                            return null;
                        })}
                    </ul>
                </div>
                <div>
                    <h3>Even Index Players</h3>
                    <ul>
                        {players.map((player, index) => {
                            if (index % 2 === 0) {
                                return <EvenPlayers key={index} player={player} />;
                            }
                            return null;
                        })}
                    </ul>
                </div>
            </div>
        </div>
    );
}
