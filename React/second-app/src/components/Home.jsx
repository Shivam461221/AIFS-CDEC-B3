import { useEffect, useState } from 'react';
import './Home.css'
function Home() {
    //Hooks - hooks are special function provided by react to handle state and side effects 
    //in react functional components

    //State - memorry of a component
    const [count, setCount] = useState(0);
    const [name, setName] = useState('React');

    const [age, setAge] = useState(25);

    useEffect(()=>{
        //runs when component first renders
        console.log('Render');
    }, []);

    useEffect(()=>{
        //runs when a dependency updates
        console.log('Update');
    }, [count]);

    useEffect(()=>{
        //runs everytime
        console.log('Everytime');
    })

    useEffect(()=>{
        //runs when component about to remove
        return ()=>{
            console.log('Destroying');
        }
    })

    // let num = 0;

    const add = () => {
        setCount(count + 1);
        //num+1;
    }

    const subtract = () => {
        setCount(count - 1);
    }

    const updateName = (str) => {
        setName(str);
    }

    return (
        <>
            <div className='home'>
                <h1>Home</h1>
                <p>This is a home component {count} </p>
                <button onClick={() => add()}>Add</button>
                <button onClick={() => subtract()}>Subtract</button>
                <br /><br />
                <input type="text" onChange={() => updateName(event.target.value)} />
                <h1>{name}</h1>
            </div>
        </>
    )
}

export default Home;