import Button from "./components/Button";
import List from "./components/List";

function App(){
  let arr = [1,2,3,4,5,6];

  return (
    <div>
      <h1>Hello</h1>
      <p>This is a react project {arr} </p>
      <Button/>
      <Button/>
      <List/>
    </div>
  )
}

export default App;