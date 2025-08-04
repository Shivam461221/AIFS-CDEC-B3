
import React from 'react';

const Footer = () => {
  return (
    <footer className="bg-dark text-white mt-auto py-3">
      <div className="container text-center">
        <p className="mb-1">© {new Date().getFullYear()} Flight Booker. All rights reserved.</p>
        <p className="mb-0">
          <a href="https://yourcompany.com" className="text-white text-decoration-none me-3">About Us</a>
          <a href="/contact" className="text-white text-decoration-none">Contact</a>
        </p>
      </div>
    </footer>
  );
};

export default Footer;
