
import './App.css'
import { useContext } from 'react'
import { CountContext } from './context/CountContext';
import Home from './components/Home';


function App() {
  const {count, increase, decrease} = useContext(CountContext);

  return (
    <>
      <div>
        <p>Count {count}</p>

        <button onClick={()=>increase()}>Add</button>
        <button onClick={()=>decrease()}>Minus</button>
      </div>

      <Home/>
    </>
  )
}

export default App
