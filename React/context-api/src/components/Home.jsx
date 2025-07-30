import { useContext } from "react"
import { CountContext } from "../context/CountContext"
import { useState } from "react";

export default function Home() {
    const [data, setData] = useState(10);

    const { count } = useContext(CountContext);

    return <>
        <div>
            <p>Count {count} {data}</p>
        </div>
    </>
}