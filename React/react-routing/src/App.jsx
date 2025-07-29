import './App.css'
import Home from './components/Home'
import About from './components/About'
import Career from './components/Career'
import { Link, Route, Routes } from 'react-router-dom'
import 'bootstrap/dist/css/bootstrap.min.css'

function App() {
  
  return (
    <>
      <div className="container-fluid bg-info p-2 display-6">
        <div className="row">
          <div className="col-md-2">
            <Link to={'/home'} >Home</Link>
          </div>
          <div className="col-md-2">
            <Link to={'/about'}>About</Link>
          </div>
          <div className="col-md-2">
            <Link to={'/career'}>Career</Link>
          </div>
          <div className="col-md-2">Contact</div>
          <div className="col-md-2">Courses</div>
          <div className="col-md-2">Jobs</div>
        </div>
      </div>
      
      

      <Routes>
        <Route path='/home'element={<Home/>} />
        <Route path='/about' element={<About/>} />
        <Route path='/career' element={<Career/>} />
      </Routes>

      
    </>
  )
}

export default App
