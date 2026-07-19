import React, { useState } from 'react';

// Custom hook for form validation
function useFormValidation(initialState, validate) {
    const [values, setValues] = useState(initialState);
    const [errors, setErrors] = useState({});

    const handleChange = (e) => {
        setValues({
            ...values,
            [e.target.name]: e.target.value
        });
    };

    const handleBlur = () => {
        const validationErrors = validate(values);
        setErrors(validationErrors);
    };

    const handleSubmit = (e, callback) => {
        e.preventDefault();
        const validationErrors = validate(values);
        setErrors(validationErrors);
        
        if (Object.keys(validationErrors).length === 0) {
            callback();
            setValues(initialState); // Reset form
        }
    };

    return { values, errors, handleChange, handleBlur, handleSubmit };
}

function validateTicket(values) {
    let errors = {};
    if (!values.ticketId) {
        errors.ticketId = "Ticket ID is required";
    }
    if (!values.title) {
        errors.title = "Title is required";
    } else if (values.title.length < 5) {
        errors.title = "Title must be at least 5 characters";
    }
    if (!values.description) {
        errors.description = "Description is required";
    }
    return errors;
}

export default function TicketRaisingApp() {
    const { values, errors, handleChange, handleBlur, handleSubmit } = useFormValidation(
        { ticketId: '', title: '', description: '' },
        validateTicket
    );
    const [tickets, setTickets] = useState([]);

    const submitTicket = () => {
        setTickets([...tickets, values]);
    };

    return (
        <div>
            <h2>Raise a Support Ticket (Custom Hook)</h2>
            <form onSubmit={(e) => handleSubmit(e, submitTicket)} style={{ display: 'flex', flexDirection: 'column', width: '300px', gap: '15px' }}>
                <div>
                    <label>Ticket ID:</label>
                    <input type="text" name="ticketId" value={values.ticketId} onChange={handleChange} onBlur={handleBlur} style={{ width: '100%' }} />
                    {errors.ticketId && <p style={{ color: 'red', margin: 0, fontSize: '12px' }}>{errors.ticketId}</p>}
                </div>
                
                <div>
                    <label>Title:</label>
                    <input type="text" name="title" value={values.title} onChange={handleChange} onBlur={handleBlur} style={{ width: '100%' }} />
                    {errors.title && <p style={{ color: 'red', margin: 0, fontSize: '12px' }}>{errors.title}</p>}
                </div>
                
                <div>
                    <label>Description:</label>
                    <textarea name="description" value={values.description} onChange={handleChange} onBlur={handleBlur} rows="4" style={{ width: '100%' }}></textarea>
                    {errors.description && <p style={{ color: 'red', margin: 0, fontSize: '12px' }}>{errors.description}</p>}
                </div>

                <button type="submit">Submit Ticket</button>
            </form>

            <div style={{ marginTop: '30px' }}>
                <h3>Raised Tickets</h3>
                {tickets.length === 0 ? <p>No tickets raised yet.</p> : (
                    <ul>
                        {tickets.map((t, idx) => (
                            <li key={idx} style={{ marginBottom: '10px' }}>
                                <strong>#{t.ticketId} - {t.title}</strong>: {t.description}
                            </li>
                        ))}
                    </ul>
                )}
            </div>
        </div>
    );
}
