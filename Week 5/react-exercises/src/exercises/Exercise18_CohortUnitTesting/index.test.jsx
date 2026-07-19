import { render, screen } from '@testing-library/react';
import CohortUnitTesting from './index';

test('renders default cohort details', () => {
    render(<CohortUnitTesting />);
    expect(screen.getByTestId('cohort-name')).toHaveTextContent('Cohort Name: React JS');
    expect(screen.getByTestId('start-date')).toHaveTextContent('Start Date: Jan 1, 2024');
});

test('renders provided cohort details', () => {
    render(<CohortUnitTesting cohortName="Java FSE" startDate="Oct 1, 2024" />);
    expect(screen.getByTestId('cohort-name')).toHaveTextContent('Cohort Name: Java FSE');
    expect(screen.getByTestId('start-date')).toHaveTextContent('Start Date: Oct 1, 2024');
});
