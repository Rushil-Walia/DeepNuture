import React, { useState } from 'react';

export default function TicketBookingApp() {
    const [formData, setFormData] = useState({
        passengerName: '',
        age: '',
        gender: '',
        trainName: '',
        dateOfJourney: ''
    });

    const [submittedData, setSubmittedData] = useState(null);

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        setSubmittedData(formData);
        // Clear form after submit (optional)
        // setFormData({passengerName: '', age: '', gender: '', trainName: '', dateOfJourney: ''});
    };

    return (
        <div>
            <h2>Train Ticket Booking Form</h2>
            <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'column', width: '300px', gap: '10px' }}>
                <label>
                    Passenger Name:
                    <input type="text" name="passengerName" value={formData.passengerName} onChange={handleChange} required />
                </label>
                <label>
                    Age:
                    <input type="number" name="age" value={formData.age} onChange={handleChange} required />
                </label>
                <label>
                    Gender:
                    <select name="gender" value={formData.gender} onChange={handleChange} required>
                        <option value="">Select</option>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                        <option value="Other">Other</option>
                    </select>
                </label>
                <label>
                    Train Name:
                    <input type="text" name="trainName" value={formData.trainName} onChange={handleChange} required />
                </label>
                <label>
                    Date of Journey:
                    <input type="date" name="dateOfJourney" value={formData.dateOfJourney} onChange={handleChange} required />
                </label>
                <button type="submit" style={{ marginTop: '10px' }}>Book Ticket</button>
            </form>

            {submittedData && (
                <div style={{ marginTop: '20px', padding: '15px', border: '1px solid green', backgroundColor: '#eaffea' }}>
                    <h3>Booking Confirmed!</h3>
                    <p><strong>Name:</strong> {submittedData.passengerName}</p>
                    <p><strong>Age:</strong> {submittedData.age}</p>
                    <p><strong>Gender:</strong> {submittedData.gender}</p>
                    <p><strong>Train:</strong> {submittedData.trainName}</p>
                    <p><strong>Date:</strong> {submittedData.dateOfJourney}</p>
                </div>
            )}
        </div>
    );
}
