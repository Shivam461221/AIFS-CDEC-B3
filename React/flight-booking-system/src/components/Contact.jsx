
import React, { useState } from 'react';

const Contact = () => {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    message: '',
  });

  const handleChange = (e) => {
    setFormData((prev) => ({
      ...prev,
      [e.target.name]: e.target.value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // You can send this data to backend API
    console.log('Feedback Submitted:', formData);
    alert('Thank you for your feedback!');
    setFormData({ name: '', email: '', message: '' });
  };

  return (
    <div className="container mt-5">
      <h2 className="mb-4 text-center">Contact Us</h2>

      <div className="row">
        {/* Contact Info */}
        <div className="col-md-6 mb-4">
          <div className="bg-light p-4 rounded shadow-sm h-100">
            <h5>📞 Phone:</h5>
            <p>+91 9876543210</p>

            <h5>📧 Help Email:</h5>
            <p>support@flightbooker.com</p>

            <h5>🕒 Working Hours:</h5>
            <p>Mon - Sat: 9 AM to 6 PM</p>
          </div>
        </div>

        {/* Feedback Form */}
        <div className="col-md-6">
          <form onSubmit={handleSubmit} className="bg-light p-4 rounded shadow-sm">
            <h5 className="mb-3">💬 Send Us Your Feedback</h5>

            <div className="mb-3">
              <label className="form-label">Your Name</label>
              <input
                type="text"
                name="name"
                className="form-control"
                value={formData.name}
                onChange={handleChange}
                required
              />
            </div>

            <div className="mb-3">
              <label className="form-label">Your Email</label>
              <input
                type="email"
                name="email"
                className="form-control"
                value={formData.email}
                onChange={handleChange}
                required
              />
            </div>

            <div className="mb-3">
              <label className="form-label">Message</label>
              <textarea
                name="message"
                rows="4"
                className="form-control"
                value={formData.message}
                onChange={handleChange}
                required
              ></textarea>
            </div>

            <button type="submit" className="btn btn-primary w-100">Submit</button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Contact;
