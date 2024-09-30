// import { Route, Routes } from "react-router-dom"
// import Home from "./Home"
// import Faq from "./Faq"
// import Contactus from "./Contactus"
// import Caldis from "./Caldis";
// import SignIn from "./SignIn";
// import Welcome from "./Wlecome";
// import Billing from "./Billing";
// import Bill from "./BillSummary";
// import BillingSummary from "./BillSummary";
 
//  const SRoutes=()=>
// {
 
// return(<>
 
// <Routes>
//     <Route path="/" element={<Home/>}/>
//     <Route path="/faq" element={<Faq/>}/>
//     <Route path="/contactus" element={<Contactus/>}/>
//     <Route path="/caldis" element={<Caldis/>}/>
//     <Route path="/signIn" element ={<SignIn/>}/>
//     <Route path="/welcome" element ={<Welcome/>}/>
//     <Route path="/billing" element={<Billing />} />  
//     <Route path="/billing-summary" element={<BillingSummary />}/>  
 
 
 
 
// </>)
 
 
// }
// export default SRoutes;


// SRoutes.js
import { Route, Routes } from "react-router-dom";
import Home from "./Home";
import Faq from "./Faq";
import Contactus from "./Contactus";
import Caldis from "./Caldis";
import SignIn from "./SignIn";
import Welcome from "./Wlecome";  
import Billing from "./Billing";
import BillingSummary from "./BillSummary";  
import Error from "./Error";
import Profile from "./Profile";
import ProtectedRoute from "./ProtectedRoute"

const SRoutes = () => {
  return (
    <>/
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/faq" element={<Faq />} />
        <Route path="/contactus" element={<Contactus />} />
        <Route path="/caldis" element={<Caldis />} />
        <Route path="/signIn" element={<SignIn />} />
        <Route path="/welcome" element={<Welcome />} />
        {/* <Route path="/billing" element={<Billing />} /> */}
        <Route path="/billing" element={
            <ProtectedRoute>
              <Billing />
            </ProtectedRoute>
          } />
        <Route path="/billing-summary" element={<BillingSummary />} />
        <Route path="/*" element = {<Error/>} />
        <Route path="Profile/:usernm"  element={<Profile/>}/>


          
      </Routes>
    </>
  );
};

export default SRoutes;
