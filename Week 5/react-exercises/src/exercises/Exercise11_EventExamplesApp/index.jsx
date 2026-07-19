import React, { Component } from 'react';

export default class EventExamplesApp extends Component {
    constructor(props) {
        super(props);
        this.state = {
            inputValue: '',
            displayText: ''
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleClick = this.handleClick.bind(this);
        this.handleClear = this.handleClear.bind(this);
    }

    handleChange(event) {
        this.setState({ inputValue: event.target.value });
    }

    handleClick() {
        this.setState({ displayText: this.state.inputValue });
    }

    handleClear() {
        this.setState({ inputValue: '', displayText: '' });
    }

    render() {
        return (
            <div>
                <h2>Event Examples App</h2>
                <div style={{ margin: '20px 0' }}>
                    <input 
                        type="text" 
                        value={this.state.inputValue} 
                        onChange={this.handleChange} 
                        placeholder="Type something..."
                        style={{ padding: '5px' }}
                    />
                </div>
                <div style={{ marginBottom: '20px' }}>
                    <button onClick={this.handleClick} style={{ marginRight: '10px' }}>Submit</button>
                    <button onClick={this.handleClear}>Clear</button>
                </div>
                {this.state.displayText && (
                    <div style={{ padding: '10px', border: '1px dashed blue' }}>
                        <strong>You typed:</strong> {this.state.displayText}
                    </div>
                )}
            </div>
        );
    }
}
