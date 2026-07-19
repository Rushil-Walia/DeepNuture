import { render, screen, waitFor } from '@testing-library/react';
import axios from 'axios';
import FetchUserApp from './index';

jest.mock('axios');

test('fetches and displays users', async () => {
    const mockUsers = [
        { id: 1, name: 'Leanne Graham' },
        { id: 2, name: 'Ervin Howell' }
    ];
    axios.get.mockResolvedValueOnce({ data: mockUsers });

    render(<FetchUserApp />);
    
    await waitFor(() => {
        const userItems = screen.getAllByTestId('user-item');
        expect(userItems.length).toBe(2);
        expect(userItems[0]).toHaveTextContent('Leanne Graham');
    });
});

test('handles fetch error', async () => {
    axios.get.mockRejectedValueOnce(new Error('Network error'));

    render(<FetchUserApp />);
    
    await waitFor(() => {
        const errorMsg = screen.getByTestId('error-msg');
        expect(errorMsg).toHaveTextContent('Failed to fetch users');
    });
});
