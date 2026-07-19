import React from 'react';

export default function CohortUnitTesting({ cohortName, startDate }) {
    return (
        <div>
            <h2>Cohort Details for Testing</h2>
            <p data-testid="cohort-name">Cohort Name: {cohortName || 'React JS'}</p>
            <p data-testid="start-date">Start Date: {startDate || 'Jan 1, 2024'}</p>
        </div>
    );
}
