import { useNavigate } from "react-router-dom";
import ComOne from "./ComOne";



function Home(props){
    const navigate = useNavigate();
    

    const navigateTo=()=>{
        navigate('/about');
    }

    return (
        <>
            <h1>Home {props.data} </h1>

            <button onClick={()=>navigateTo()} className="btn btn-primary">About</button>
            <button onClick={()=>navigate('/career')} className="btn btn-success">Career</button>
            
            <ComOne data={props.data} />
        </>
    )
}

export default Home;