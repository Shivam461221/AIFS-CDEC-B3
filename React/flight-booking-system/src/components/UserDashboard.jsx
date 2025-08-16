import { useUser } from "../Context/UserContext"

 const UserDashboard=()=>{
const {user} = useUser();
console.log(user);
    return (
        <>
            <div className="container mt-5" style={{minHeight:'550px'}}>
                <div className="row">
                    <div className="col-md-4 border rounded py-5 bg-info text-white d-flex justify-content-center align-items-center flex-column">
                    <i style={{fontSize:'70px'}} className='bxr  bx-user'></i> 
                    <p>Your Profile</p>
                </div>
                <div className="col-md-4 border rounded py-5 bg-secondary text-white d-flex justify-content-center align-items-center flex-column">
                    <i style={{fontSize:'70px'}} className='bxr  bx-edit'  ></i> 
                    <p>Update Profile</p>
                </div>
                <div className="col-md-4 border rounded py-5 bg-warning d-flex justify-content-center align-items-center flex-column">
                    <i style={{fontSize:'70px'}} className='bxr  bx-list-ul'  ></i> 
                    <p>Your Bookings</p>
                </div>
                </div>
                <div className="row mt-2">
                    <div className="col-md-4 border rounded py-5 bg-danger text-white d-flex justify-content-center align-items-center flex-column">
                   
                    <i style={{fontSize:'70px'}} className='bxr  bx-search-big'  ></i> 
                    <p>Search Flights</p>
                </div>
                <div className="col-md-4 border rounded py-5 bg-success text-white d-flex justify-content-center align-items-center flex-column">
                    <i style={{fontSize:'70px'}} className='bxr  bx-edit'  ></i> 
                    <p>Update Profile</p>
                </div>
                <div className="col-md-4 border rounded py-5 bg-dark text-white  d-flex justify-content-center align-items-center flex-column">
                    <i style={{fontSize:'70px'}} className='bxr  bx-list-ul'  ></i> 
                    <p>Your Bookings</p>
                </div>
                </div>
            </div>
        </>
    )
}

export default UserDashboard