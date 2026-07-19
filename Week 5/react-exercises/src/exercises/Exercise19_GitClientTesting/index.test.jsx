import { render, screen } from '@testing-library/react';
import GitClientTesting from './index';

test('renders repo name', () => {
    render(<GitClientTesting />);
    expect(screen.getByTestId('repo-name')).toHaveTextContent('Repo: React Exercises');
});
