import { useNavigate } from "react-router-dom";
import Career from "./Career";
import About from "./About";
import { useState } from "react";

function Home(){
    const navigate = useNavigate();
    const [data, setData] = useState([]);

    const navigateTo=()=>{
        navigate('/about');
    }

    return (
        <>
            <h1>Home</h1>
            <button onClick={()=>navigateTo()} className="btn btn-primary">About</button>
            <button onClick={()=>navigate('/career')} className="btn btn-success">Career</button>
            <Career data={data} />
            <About/>
        </>
    )
}

export default Home;