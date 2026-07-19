import { render, screen, fireEvent } from '@testing-library/react';
import MailRegisterApp from './index';

test('renders Mail Register App', () => {
    render(<MailRegisterApp />);
    const headingElement = screen.getByText(/Mail Register App/i);
    expect(headingElement).toBeInTheDocument();
});

test('registers and displays the email id', () => {
    render(<MailRegisterApp />);
    const inputElement = screen.getByTestId('email-input');
    const buttonElement = screen.getByTestId('register-button');

    fireEvent.change(inputElement, { target: { value: 'test@example.com' } });
    fireEvent.click(buttonElement);

    const registeredElement = screen.getByTestId('registered-email');
    expect(registeredElement).toHaveTextContent('Registered Email: test@example.com');
});
