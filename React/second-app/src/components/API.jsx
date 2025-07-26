import { useEffect, useState } from "react"

export default function API() {
    const [products, setProducts] = useState(null);

    const getProducts= async () => {
        try{
            let response = await fetch('https://dummyjson.com/products');
            let data = await response.json();
            setProducts(data);
        }
        catch(error){
            console.log(error.message);
        }
    }

    useEffect(() => {
        getProducts();
        console.log('called');
    }, []);

    console.log(products);
    return (
        <>
            {products ? (
            products.products.map(p => <div key={p.id}>{p.title}</div>)
        ) : (
            "Loading..."
        )}
        </>
    )
}