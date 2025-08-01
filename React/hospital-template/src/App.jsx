
import About from './components/About'
import Booking from './components/Booking'
import Footer from './components/Footer'
import Header from './components/Header'
import Home from './components/Home'
import Treatment from './components/Treatment'
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';

function App() {


  return (
    <>

      <Header />
      <Routes>
        <Route path="/home" element={<Home />} />
        <Route path='/about' element={<About />} />
        <Route path='/booking' element={<Booking />} />
        <Route path='/treatment' element={<Treatment />} />
      </Routes>
      <Footer />

    </>
  )
}

export default App
