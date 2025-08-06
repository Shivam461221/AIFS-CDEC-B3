import { useNavigate } from "react-router-dom";
import { useUser } from "../Context/UserContext";
import { useEffect } from "react";


export default function ProtectedRoute({children}){
    const {user} = useUser();
    const navigate = useNavigate();

    useEffect(() => {
    if (!user.token) {
      navigate('/');
    }
  }, [user, navigate]);

  return user.token ? children : null;

}