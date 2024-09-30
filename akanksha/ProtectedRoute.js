import { Navigate } from "react-router-dom";
 
const ProtectedRoute = ({ children }) => {
 
 
  const isAuthenticated = localStorage.getItem('userId')
 
 
  return isAuthenticated===true ? children : <Navigate to="/SignIn" />;
};
 
export default ProtectedRoute;