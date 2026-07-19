import React from 'react';
import './mystyle.css';

function CalculateScore({ name, school, total, goal }) {
    return (
        <div className="score-board">
            <h3>Student Details:</h3>
            <p><strong>Name:</strong> {name}</p>
            <p><strong>School:</strong> {school}</p>
            <p><strong>Total Score:</strong> {total}</p>
            <p><strong>Goal Score:</strong> {goal}</p>
            <p><strong>Score Percentage:</strong> {Math.round((total / goal) * 100)}%</p>
        </div>
    );
}

export default function ScoreCalculatorApp() {
    return (
        <div>
            <h2>Score Calculator App</h2>
            <CalculateScore name="Alice" school="High School" total={450} goal={500} />
            <CalculateScore name="Bob" school="Middle School" total={300} goal={400} />
        </div>
    );
}
