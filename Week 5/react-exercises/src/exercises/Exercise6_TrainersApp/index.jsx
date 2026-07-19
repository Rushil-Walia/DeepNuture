import React, { Component } from 'react';

class TrainerList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            trainers: [
                { id: 1, name: 'John Doe', subject: 'Java Full Stack' },
                { id: 2, name: 'Jane Smith', subject: 'React JS' },
                { id: 3, name: 'Alan Walker', subject: 'Spring Boot' }
            ]
        };
    }

    render() {
        return (
            <div>
                <h3>List of Trainers</h3>
                <table style={{ width: '50%', borderCollapse: 'collapse', textAlign: 'left' }}>
                    <thead>
                        <tr>
                            <th style={{ borderBottom: '1px solid black' }}>ID</th>
                            <th style={{ borderBottom: '1px solid black' }}>Name</th>
                            <th style={{ borderBottom: '1px solid black' }}>Subject</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.trainers.map(trainer => (
                            <tr key={trainer.id}>
                                <td style={{ borderBottom: '1px solid #ccc' }}>{trainer.id}</td>
                                <td style={{ borderBottom: '1px solid #ccc' }}>{trainer.name}</td>
                                <td style={{ borderBottom: '1px solid #ccc' }}>{trainer.subject}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        );
    }
}

export default function TrainersApp() {
    return (
        <div>
            <h2>Trainers App</h2>
            <TrainerList />
        </div>
    );
}
