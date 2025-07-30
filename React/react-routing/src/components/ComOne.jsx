import ComTwo from "./ComTwo";

export default function ComOne({data}) {
    return <>
        <div className="m-2" style={{border:'2px solid red'}}>
            <h1>Component 1 </h1>
            <p>data {data}</p>

            <ComTwo data={data} />
        </div>
    </>
}