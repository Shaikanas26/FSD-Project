import React from 'react';
import { Link } from 'react-router-dom';
import './Home.css';

const Home = () => {
  return (
    <div className="home-container">
      <h1>Text Encryption</h1>
      <div className="home-links">
        <Link to="/register" className="home-link">Register</Link>
        <Link to="/login" className="home-link">Login</Link>
      </div>
    </div>
  );
};

export default Home;
