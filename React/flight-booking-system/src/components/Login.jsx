
import React, { useContext, useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { useUser } from '../Context/UserContext';

const Login = () => {
    const [formData, setFormData] = useState({ username: '', password: '' });
    const { login, logout } = useUser(); 
    //   const [username, setUsername] = useState('');
    //   const [password, setPassword] = useState('');
    const navigate = useNavigate();

    const handleChange = (e) => {
        setFormData((prev) => ({
            ...prev,
            [e.target.name]: e.target.value,
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        let response = await axios.post('http://localhost:8080/api/users/login', { username: formData.username, password: formData.password })
        // console.log(response);
        let data = response.data;
        if (data.token) {
            login({
                userId:data.userId,
                token:data.token,
                roles:data.roles
            })
            navigate('/user-dashboard');
        }
        else{
            alert('Wrong credentials');
        }

    };

    return (
        <div className="container mt-5" style={{minHeight:'550px'}}>
            <h2 className="mb-4 text-center">Login</h2>
            <form onSubmit={handleSubmit} className="mx-auto" style={{ maxWidth: '400px' }}>
                <div className="mb-3">
                    <label className="form-label">Username</label>
                    <input
                        type="text"
                        name="username"
                        className="form-control"
                        value={formData.username}
                        onChange={handleChange}
                        // onChange = {setUsername(event.target.value)}
                        required
                    />
                </div>

                <div className="mb-3">
                    <label className="form-label">Password</label>
                    <input
                        type="password"
                        name="password"
                        className="form-control"
                        value={formData.password}
                        onChange={handleChange}
                        required
                    />
                </div>

                <button type="submit" className="btn btn-primary w-100">Login</button>
            </form>
        </div>
    );
};

export default Login;
