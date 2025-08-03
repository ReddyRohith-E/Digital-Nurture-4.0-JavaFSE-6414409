import React, { useState } from 'react';
import './App.css';

function App() {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: ''
  });

  const validateField = (name, value) => {
    let error = '';
    
    switch (name) {
      case 'name':
        if (value.length < 5) {
          error = 'Full Name must be 5 characters long!';
        }
        break;
      case 'email':
        const validEmailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!validEmailRegex.test(value)) {
          error = 'Email is not valid!';
        }
        break;
      case 'password':
        if (value.length < 8) {
          error = 'Password must be 8 characters long';
        }
        break;
      default:
        break;
    }
    
    return error;
  };

  const handleChange = (event) => {
    const { name, value } = event.target;
    
    // Update form data
    setFormData(prev => ({
      ...prev,
      [name]: value
    }));
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    
    // Validate all fields
    const nameError = validateField('name', formData.name);
    const emailError = validateField('email', formData.email);
    const passwordError = validateField('password', formData.password);

    // Collect all errors
    const errors = [];
    if (nameError) errors.push(nameError);
    if (emailError) errors.push(emailError);
    if (passwordError) errors.push(passwordError);

    // Show all errors one by one
    if (errors.length > 0) {
      errors.forEach(error => {
        alert(error);
      });
      return;
    }

    // If no errors, show success message
    alert('Valid Form!');
  };

  return (
    <div className="App">
      <div className="form-container">
        <h2 style={{ color: 'red', textAlign: 'center' }}>Register Here!!!</h2>
        
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label htmlFor="name">Name:</label>
            <input
              type="text"
              id="name"
              name="name"
              value={formData.name}
              onChange={handleChange}
            />
          </div>

          <div className="form-group">
            <label htmlFor="email">Email:</label>
            <input
              type="text"
              id="email"
              name="email"
              value={formData.email}
              onChange={handleChange}
            />
          </div>

          <div className="form-group">
            <label htmlFor="password">Password:</label>
            <input
              type="password"
              id="password"
              name="password"
              value={formData.password}
              onChange={handleChange}
            />
          </div>

          <button type="submit">Submit</button>
        </form>
      </div>
    </div>
  );
}

export default App;
