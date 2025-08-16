import { Link } from "react-router-dom";
import { useUser } from "../Context/UserContext";

export default function Header() {

  const { user, logout } = useUser();
  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
      <div className="container-fluid">
        <Link className="navbar-brand" to="/">✈️ Flight Booker</Link>

        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
          <span className="navbar-toggler-icon"></span>
        </button>

        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav ms-auto">

            {user.token ? (
              <>
                 <li className="nav-item">
                    <Link className="nav-link" to="/user-dashboard">Dashboard</Link>
                  </li>
                <li className="nav-item">
                  <Link className="nav-link" to={"/search-flight"}>Search Flight</Link>
                </li>
                <li className="nav-item">
                  <Link className="nav-link" to="/booking">Booking</Link>
                </li>
                <li className="nav-item">
                  <Link className="nav-link" to={'/'} onClick={() => logout()}>Logout</Link>
                </li>
              </>
            ) :
              (
                <>
                  <li className="nav-item">
                    <Link className="nav-link" to="/">Home</Link>
                  </li>
                 
                  <li className="nav-item">
                    <Link className="nav-link" to="/login">Login</Link>
                  </li>
                  <li className="nav-item">
                    <Link className="nav-link" to="/signup">Signup</Link>
                  </li>
                  <li className="nav-item">
                    <Link className="nav-link" to="/contact">Contact</Link>
                  </li>
                </>
              )
            }

          </ul>
        </div>
      </div>
    </nav>
  );
};