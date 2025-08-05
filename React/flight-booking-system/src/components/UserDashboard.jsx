import { useUser } from "../Context/UserContext"

 const UserDashboard=()=>{
const {user} = useUser();
console.log(user);
    return (
        <>
            <p className="Display-4">DashBoard</p>
            <p>{user.userId}</p>
        </>
    )
}

export default UserDashboard