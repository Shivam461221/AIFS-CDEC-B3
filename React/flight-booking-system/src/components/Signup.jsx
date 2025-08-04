import React, { useState } from 'react';

const Signup = () => {
  const [formData, setFormData] = useState({
    username: '',
    password: '',
    email: '',
    gender: '',
    age: '',
    contactNumber: '',
  });

  const handleChange = (e) => {
    setFormData((prev) => ({
      ...prev,
      [e.target.name]: e.target.value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // 📝 Call signup API here
    console.log('Signup Data:', formData);
  };

  return (
    <div className="container mt-5">
      <h2 className="mb-4 text-center">Sign Up</h2>
      <form onSubmit={handleSubmit} className="mx-auto" style={{ maxWidth: '500px' }}>
        <div className="mb-3">
          <label className="form-label">Username</label>
          <input type="text" name="username" className="form-control" value={formData.username} onChange={handleChange} required />
        </div>

        <div className="mb-3">
          <label className="form-label">Password</label>
          <input type="password" name="password" className="form-control" value={formData.password} onChange={handleChange} required />
        </div>

        <div className="mb-3">
          <label className="form-label">Email</label>
          <input type="email" name="email" className="form-control" value={formData.email} onChange={handleChange} required />
        </div>

        <div className="mb-3">
          <label className="form-label">Gender</label>
          <select name="gender" className="form-select" value={formData.gender} onChange={handleChange} required>
            <option value="">-- Select Gender --</option>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Other">Other</option>
          </select>
        </div>

        <div className="mb-3">
          <label className="form-label">Age</label>
          <input type="number" name="age" className="form-control" value={formData.age} onChange={handleChange} required />
        </div>

        <div className="mb-3">
          <label className="form-label">Contact Number</label>
          <input type="tel" name="contactNumber" className="form-control" value={formData.contactNumber} onChange={handleChange} required />
        </div>

        <button type="submit" className="btn btn-success w-100">Sign Up</button>
      </form>
    </div>
  );
};

export default Signup;
