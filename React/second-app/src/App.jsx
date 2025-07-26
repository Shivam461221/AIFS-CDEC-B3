import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Home from './components/Home'
import Header from './components/Header'


function App() {
  //component lifecycle - 
  // 1- Render 
  // 2- Update
  // 3- Remove
  return (
    <>
      <Header/>
      <Home/>
      <Header/>
    </>
  )
}

export default App;
