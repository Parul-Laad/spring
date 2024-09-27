import axios from 'axios';
import './App.css';
import { useEffect, useState } from 'react';
 
function App() {
 
  let [users, setUsers] = useState([]);
  let [ac, setAc] = useState();
  let [name, setName] = useState();
  let [bal, setBal] = useState();
  let [message, setMessage] = useState(' ');  // State for success/error messages
 
  useEffect(() => {
    getData();
  }, [message])
 
  const getData = async () => {
    try {
      let res = await axios.get("http://localhost:1000/api/getcust");
      if (res.data) { // Check if API response indicates success
        setUsers(res.data);
        //setMessage("Data retrieved successfully!");
      } else {
        setMessage("Failed to retrieve data.");
      }
    } catch (error) {
      setMessage("Error occurred while fetching data.");
    }
  }
 
  const storeData = async () => {
    let user = {
      "acNo": ac,
      "name": name,
      "bal": bal
    };
 
    try {
      let res = await axios.post("http://localhost:1000/api/savecust", user);
      if (res.data ) {  // Check for success in the API response
        setMessage("Record added successfully!");
      } else {
        setMessage("Failed to add record.");
      }
    } catch (error) {
      setMessage("Error occurred while adding record.");
    }
  }
 
  const removeDatabyAcnumber = async () => {
    try {
      let res = await axios.delete(`http://localhost:1000/api/delcust/${ac}`);
      if (res.data) { // Handle success based on response data
        setMessage("Record removed successfully by account number!");
      } else {
        setMessage("Failed to remove record by account number.");
      }
    }
    catch (error) {
      setMessage("Error occurred while removing record by account number.");
    }
  }
 
  const removeDatabyName = async () => {
    try {
      let res = await axios.delete(`http://localhost:1000/api/delcustbyname/${name}`);
      if (res.data) { // Handle success based on response data
        setMessage("Record removed successfully by name!");
      } else {
        setMessage("Failed to remove record by name.");
      }
    } catch (error) {
      setMessage("Error occurred while removing record by name.");
    }
  }
 
  const updateData = async () => {
    try {
      let res = await axios.put(`http://localhost:1000/api/updatedatabyq/${bal}/${ac}`);
      if (res.data) { // Handle success based on response data
        setMessage("Record updated successfully!");
      } else {
        setMessage("Failed to update record.");
      }
    } catch (error) {
      setMessage("Error occurred while updating record.");
    }
  }
 
  return (
    <div className="App">
      <input type="text" placeholder='Account number' onChange={(e) => setAc(e.target.value)} />
      <input type="text" placeholder='Name' onChange={(e) => setName(e.target.value)} />
      <input type="text" placeholder='Balance' onChange={(e) => setBal(e.target.value)} />
 
      <button onClick={storeData}>Add Record</button><br/><br/>
      <button onClick={removeDatabyAcnumber}>Remove Data by Account number</button><br/>
      <button onClick={removeDatabyName}>Remove Data by Name</button><br/>
      <button onClick={updateData}>Update Data</button><br/><br/>
 
      {/* Display success or error messages */}
      {message && <h3>{message}</h3>}
 
      {/* Display fetched users */}
      {
        users ? users.map((temp) => <h1 key={temp.acNo}>{temp.name}  {temp.bal}</h1>) : null
      }
    </div>
  );
}
 
export default App;









// import axios from "axios";
// import "./App.css"
// import { useEffect, useState } from "react";
 
// const App=()=>
// {
 
// let[actno,setActNo]=useState()
// let [msg,setMsg]=useState("")
// let[name,setName]=useState()
 
// let[bal,setBal]=useState()
// let[users,setUsers]=useState()
// const getData=async()=>
//   {
 
//     let res=await axios.get("http://localhost:1000/api/getcust")
//     setUsers(res.data)
//     console.log(res.data)
 
//   }
 
// useEffect(()=>
//   getData()
//   ,[])
// const add= async()=>
// {
//   let user={
//     "acNo":actno,
//     "name":name,
//     "bal":bal
//   }
 
 
//  let res=await axios.post("http://localhost:1000/api/savecust",user)
//  setUsers(res.data);
//  console.log(res)
 
//   if(res.data)
//   {
//     setMsg("Record added")
 
//   }
//   else{
//     setMsg("not add")
 
//   }
 
 
 
// }
// const remove= async ()=>
// {
//   let res=await axios.delete(`http://localhost:1000/api/delcust/${actno}`)
//   if(res.data)
//     {
//       setMsg("Record Removed")
   
//     }
//     else{
//       setMsg("not Removed")
 
//     }
 
// }
 
// const update= async()=>
// {
//   //updatedatabyq
 
//   let res=await axios.put(`http://localhost:1000/api/updatedatabyq/${bal}/${actno}`)
//   if(res.data)
//     {
//       setMsg("Record updated")
   
//     }
//     else{
//       setMsg("not updated")
 
//     }
 
// }
 
 
 
 
 
// return(<>
 
 
// <div className="div1">
 
// <input type="text" placeholder="enter ur act no  " onChange={(e)=>setActNo(e.target.value)}/>
// <br/>
 
// <input type="text" placeholder="enter ur name  " onChange={(e)=>setName(e.target.value)}/>
// <br/>
 
// <input type="text" placeholder="enter ur balance  " onChange={(e)=>setBal(e.target.value)}/>
// <br/>
 
 
// <button onClick={add}> add data</button>
 
// <button onClick={remove}> Remove data</button>
 
// <button onClick={update}> update data</button>
 
 
// <h1> {msg}</h1>
 
 
// {
//   users.map((temp)=><h1>{temp.name}</h1>)
// }
 
 
 
 
 
// </div>
 
 
 
 
 
// </>)
 
 
// }
 
// export default App;


//GPT
// import axios from "axios";
// import "./App.css";
// import { useEffect, useState } from "react";

// const App = () => {
//   let [actno, setActNo] = useState();
//   let [msg, setMsg] = useState("");
//   let [name, setName] = useState();
//   let [bal, setBal] = useState();
//   let [users, setUsers] = useState([]);  // Initialize users as an empty array

//   const getData = async () => {
//     try {
//       let res = await axios.get("http://localhost:1000/api/getcust");
//       setUsers(res.data);
//       console.log(res.data);
//     } catch (error) {
//       console.error("Error fetching users:", error);
//     }
//   };

//   useEffect(() => {
//     getData();
//   }, []);

//   const add = async () => {
//     let user = {
//       "acNo": actno,
//       "name": name,
//       "bal": bal,
//     };

//     try {
//       let res = await axios.post("http://localhost:1000/api/savecust", user);
//       setUsers([...users, res.data]);  // Add the new user to the existing array
//       console.log(res);

//       if (res.data) {
//         setMsg("Record added");
//       } else {
//         setMsg("Not added");
//       }
//     } catch (error) {
//       console.error("Error adding user:", error);
//       setMsg("Failed to add record");
//     }
//   };

//   const remove = async () => {
//     try {
//       let res = await axios.delete(`http://localhost:1000/api/delcust/${actno}`);
//       if (res.data) {
//         setMsg("Record Removed");
//         setUsers(users.filter((user) => user.acNo !== actno));  // Update the users list
//       } else {
//         setMsg("Not Removed");
//       }
//     } catch (error) {
//       console.error("Error removing user:", error);
//       setMsg("Failed to remove record");
//     }
//   };

//   const update = async () => {
//     try {
//       let res = await axios.put(`http://localhost:1000/api/updatedatabyq/${bal}/${actno}`);
//       if (res.data) {
//         setMsg("Record updated");
//         getData();  // Refresh the data after the update
//       } else {
//         setMsg("Not updated");
//       }
//     } catch (error) {
//       console.error("Error updating user:", error);
//       setMsg("Failed to update record");
//     }
//   };

//   const updateName = async () => {
//     try {
//       let res = await axios.put(`http://localhost:1000/api/update/${name}/${actno}`);
//       if (res.data) {
//         setMsg("Name Updated");
//       } else {
//         setMsg("Name not updated");
//       }
//     } catch (error) {
//       console.error("Error updating name:", error);
//       setMsg("Failed to update name");
//     }
//   };

//   return (
//     <>
//       <div className="div1">
//         <input type="text" placeholder="Enter your account number" onChange={(e) => setActNo(e.target.value)} />
//         <br />
//         <input type="text" placeholder="Enter your name" onChange={(e) => setName(e.target.value)} />
//         <br />
//         <input type="text" placeholder="Enter your balance" onChange={(e) => setBal(e.target.value)} />
//         <br />
//         <button onClick={add}>Add data</button>
//         <button onClick={remove}>Remove data</button>
//         <button onClick={update}>Update data</button>
//         <button onClick={updateName}>Update Name</button> {/* New button to update name */}
//         <h1>{msg}</h1>

//         {/* Render the user list */}
//         {users && users.length > 0 ? (
//           users.map((temp) => <h1 key={temp.acNo}>{temp.name}</h1>)
//         ) : (
//           <p>No users found</p>
//         )}
//       </div>
//     </>
//   );
// };

// export default App;
