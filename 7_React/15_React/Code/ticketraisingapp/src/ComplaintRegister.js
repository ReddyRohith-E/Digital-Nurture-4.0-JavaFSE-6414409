import React, { useState } from 'react';

function ComplaintRegister() {
  const [state, setState] = useState({
    ename: '',
    NumberHolder: ''
  });

  const handleChange = (event) => {
    setState({ [event.target.name]: event.target.value });
  };

  const handleSubmit = (event) => {
    const msg = 'Thanks ' + state.ename + ' \n Your Complaint was Submitted. Your Reference ID is ' + state.NumberHolder;
    alert(msg);
    event.preventDefault();
  };

  // Generate a random reference number
  const generateReferenceNumber = () => {
    const refNumber = 'REF' + Math.floor(Math.random() * 100000);
    setState(prevState => ({
      ...prevState,
      NumberHolder: refNumber
    }));
  };

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      <h2 style={{ color: 'red', textAlign: 'center' }}>Register your complaints here!!!</h2>
      
      <form onSubmit={handleSubmit}>
        <table style={{ margin: '0 auto', borderSpacing: '10px' }}>
          <tbody>
            <tr>
              <td>
                <label htmlFor="ename"><strong>Name:</strong></label>
              </td>
              <td>
                <input
                  type="text"
                  id="ename"
                  name="ename"
                  value={state.ename}
                  onChange={handleChange}
                  placeholder="Enter your name"
                  required
                  style={{
                    width: '200px',
                    padding: '5px',
                    border: '1px solid #ccc',
                    borderRadius: '3px'
                  }}
                />
              </td>
            </tr>
            <tr>
              <td>
                <label htmlFor="complaint"><strong>Complaint:</strong></label>
              </td>
              <td>
                <textarea
                  id="complaint"
                  name="complaint"
                  placeholder="Enter your complaint"
                  required
                  style={{
                    width: '200px',
                    height: '80px',
                    padding: '5px',
                    border: '1px solid #ccc',
                    borderRadius: '3px',
                    resize: 'vertical'
                  }}
                />
              </td>
            </tr>
            <tr>
              <td colSpan="2" style={{ textAlign: 'center', paddingTop: '10px' }}>
                <button
                  type="button"
                  onClick={generateReferenceNumber}
                  style={{
                    padding: '8px 16px',
                    backgroundColor: '#007bff',
                    color: 'white',
                    border: 'none',
                    borderRadius: '3px',
                    cursor: 'pointer',
                    marginRight: '10px'
                  }}
                >
                  Generate Reference
                </button>
                <button
                  type="submit"
                  style={{
                    padding: '8px 16px',
                    backgroundColor: '#28a745',
                    color: 'white',
                    border: 'none',
                    borderRadius: '3px',
                    cursor: 'pointer'
                  }}
                >
                  Submit
                </button>
              </td>
            </tr>
          </tbody>
        </table>
      </form>
      
      {state.NumberHolder && (
        <div style={{ textAlign: 'center', marginTop: '15px' }}>
          <p><strong>Reference Number: {state.NumberHolder}</strong></p>
        </div>
      )}
    </div>
  );
}

export default ComplaintRegister;
