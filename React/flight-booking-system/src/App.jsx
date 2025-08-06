import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from './components/Header';
import Footer from './components/Footer';
import { Route, Routes } from 'react-router-dom';
import Home from './components/Home';
import Login from './components/Login';
import Signup from './components/Signup';
import Contact from './components/Contact';
import UserDashboard from './components/UserDashboard';
import ProtectedRoute from './components/ProtectedRoute';
import SearchFlight from './components/SearchFlight';

function App() {


  return (
    <>
      <Header />
      <main className="flex-grow-1">
        
        <Routes>
          <Route path='/' element={<Home/>} />
          <Route path='/login' element={<Login/>} />
          <Route path="/signup" element={<Signup/>} />
          <Route path="/contact" element={<Contact />} />
          <Route path='/user-dashboard'  element={<ProtectedRoute><UserDashboard/></ProtectedRoute>} />
          <Route path='/search-flight' element={<ProtectedRoute><SearchFlight/></ProtectedRoute>} />
        </Routes>
      </main>
      <Footer />
    </>
  )
}

export default App
