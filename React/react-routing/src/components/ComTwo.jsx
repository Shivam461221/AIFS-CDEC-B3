import ComThree from "./ComThree";

export default function ComTwo({data}){
    return < >
       <div className="m-2" style={{border:'2px solid black'}}>
         <h1>Component 2</h1>
    <p>data {data}</p>
        <ComThree data={data} />
       </div>
    </>
}