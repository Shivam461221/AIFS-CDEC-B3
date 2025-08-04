// src/pages/Home.js
import React from 'react';


const Home = () => {
  return (
    <div className="container-fluid vh-100">
      <div className="row h-100">
        {/* Left Part - Image */}
        <div className="col-md-6 d-none d-md-block p-0">
          <img
            src="https://images.unsplash.com/photo-1526772662000-3f88f10405ff?auto=format&fit=crop&w=1350&q=80"
            alt="Flight"
            className="img-fluid h-100 w-100 object-fit-cover"
          />
        </div>

        {/* Right Part - App Name & Quote */}
        <div className="col-md-6 d-flex flex-column justify-content-center align-items-center text-center bg-light px-4">
          <h1 className="display-4 mb-3 text-primary fw-bold">✈️ Flight Booker</h1>
          <p className="lead fst-italic">"Travel brings power and love back into your life."</p>
        </div>
      </div>
    </div>
  );
};

export default Home;
