import React, { Component } from 'react';

class Getuser extends Component {
  constructor(props) {
    super(props);
    this.state = {
      user: null,
      loading: true,
      error: null
    };
  }

  async componentDidMount() {
    try {
      const url = "https://api.randomuser.me/";
      const response = await fetch(url);
      const data = await response.json();
      this.setState({ 
        user: data.results[0], 
        loading: false 
      });
      console.log(data.results[0]);
    } catch (error) {
      this.setState({ 
        error: error.message, 
        loading: false 
      });
    }
  }

  render() {
    const { user, loading, error } = this.state;

    if (loading) {
      return <div>Loading...</div>;
    }

    if (error) {
      return <div>Error: {error}</div>;
    }

    return (
      <div style={{ 
        textAlign: 'center', 
        padding: '40px',
        backgroundColor: 'white',
        color: 'black',
        minHeight: '100vh'
      }}>
        {user && (
          <div>
            <h1 style={{ 
              fontSize: '32px',
              fontWeight: 'normal',
              marginBottom: '20px',
              fontFamily: 'Arial, sans-serif'
            }}>
              {user.name.title} {user.name.first} {user.name.last}
            </h1>
            <img 
              src={user.picture.large} 
              alt={`${user.name.first} ${user.name.last}`}
              style={{ 
                width: '150px',
                height: '150px',
                borderRadius: '10px'
              }}
            />
          </div>
        )}
      </div>
    );
  }
}

export default Getuser;
