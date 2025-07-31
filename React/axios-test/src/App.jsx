import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  const [products, setProducts] = useState([]);
  
  const getProducts=async()=>{
    try{
      let response = await axios.get('https://dummyjson.com/products');
      setProducts(response.data.products);
    }
    catch(error){
      console.log(error);
    }
  }

  useEffect(()=>{
    getProducts();
  }, []);

  useEffect(()=>{
    console.log(products);
  }, [products]);

  return (
    <>
      <div>
        <div className="container border">
          <h1 className='display-5 text-center'>Products</h1>
          <div className="row">
          {(products) ? products.map((product, index)=><div key={index} className='col-md-4'>
            <div className="card m-3">
              <img src={product.thumbnail} alt="" className="card-img-top" />
              <div className="card-body">
                <h3 className="card-title">{product.title}</h3>
                <p className="card-text">{product.price}</p>
                <button className="btn btn-primary form-control">Buy Now</button>
              </div>
            </div>
          </div>) : 
          <div><p className='display-6 text-center m-5'>Loading...</p></div>}
          </div>
        </div>
      </div>
    </>
  )
}

export default App
