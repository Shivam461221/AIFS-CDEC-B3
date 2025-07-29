import { useEffect, useState } from 'react'
import './App.css'
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  const [products, setProducts] = useState([]);

  const getProducts = async () => {
    try {
      let response = await fetch('https://dummyjson.com/products');
      let data = await response.json();
      setProducts(data.products);
    }
    catch (error) {
      console.log(error.message);
    }
  }

  useEffect(() => {
    getProducts();
  }, [])

  return (
    <>
      <div className="container">
        <div className="row my-5">
          {
            products ?
              (products.map((product, index) => <div className="col-md-4">
                <div className="card m-3 text-center">
                  <div className="card-body">
                    <img src={product.thumbnail} alt="" />
                  </div>
                  <div className="card-title h4">{product.title}</div>
                  <button className='btn btn-primary '>Buy Now</button>
                  <div className="card-footer">{product.price}</div>
                </div>
              </div>)) : (<h1>Loading</h1>)
          }
        </div>
      </div>
    </>
  )
}

export default App
