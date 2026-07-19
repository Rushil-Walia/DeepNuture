import React from 'react';
import styles from './CohortDetails.module.css';

export default function CohortDetails() {
    return (
        <div>
            <h2>Cohort Details</h2>
            <div className={styles.box}>
                <h3>Java Full Stack</h3>
                <dl>
                    <dt>Start Date</dt>
                    <dd>Oct 1st</dd>
                    <dt>Duration</dt>
                    <dd>12 Weeks</dd>
                </dl>
            </div>
        </div>
    );
}
