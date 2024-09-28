import React, { useEffect, useState } from 'react';
import axios from 'axios';
//import './codingchallenge.css';
 
function CodingChallenge() {
  // States for login, signup, and book management
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [signupEmail, setSignupEmail] = useState('');
  const [signupPassword, setSignupPassword] = useState('');
  const [name, setName] = useState('');
  const [userRole, setUserRole] = useState('0'); // Default to Admin (0 for admin, 1 for user)
 
  const [title, setTitle] = useState('');
  const [author, setAuthor] = useState('');
  const [publicationYear, setPublicationYear] = useState('');
  const [isbn, setIsbn] = useState('');
  const [newTitle, setNewTitle] = useState('');
  const [books, setBooks] = useState([]);
 
  // Fetch all books when the component loads after login
  /*useEffect(() => {
    const token = localStorage.getItem('token');
    if (token) {
      fetchBooks();
    }
  }, []);*/
 
 
  const fetchBooks = () => {
    const token = localStorage.getItem('token');
    axios.get('http://localhost:9000/api/admin/getBooks', {
      headers: {
        Authorization: `Bearer ${token}`//
      }
    })
      .then(response => {
        setBooks(response.data);
      })
      .catch(error => {
        console.error('There was an error fetching the books!', error);
      });
  };
 
  // Handle login
  const loginUser = (e) => {
    e.preventDefault();
    const loginData = { email, password };
 
    axios.post('http://localhost:9000/api/auth/login', loginData)
      .then(response => {
        const token = response.data.jwt; // Get JWT token from response
        localStorage.setItem('token', token); // Save token in localStorage
        alert('Login successful!');
        fetchBooks(); // Fetch books after login
      })
      .catch(error => {
        console.error('There was an error logging in!', error);
        alert('Login failed! Please check your credentials.');
      });
  };
 
  // Handle signup with user role
  const signupUser = (e) => {
    e.preventDefault();
    const signupData = {
      email: signupEmail,
      password: signupPassword,
      name,
      userRole: parseInt(userRole, 10) // Convert role to number (0 for Admin, 1 for User)
    };
 
    axios.post('http://localhost:9000/api/auth/signup', signupData)
      .then(response => {
        alert('Signup successful! You can now log in.');
      })
      .catch(error => {
        console.error('There was an error signing up!', error);
        alert('Signup failed! Please try again.');
      });
  };
 
  // Add book
 const addBook = (e) => {
  e.preventDefault();
  const book = { title, author, publicationYear: parseInt(publicationYear, 10) };
  const token = localStorage.getItem('token'); // Retrieve token from localStorage
 
  console.log(token)
 
  axios.post('http://localhost:9000/api/admin/addNewBook', book, {
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json'
    }
  })
    .then(response => {
      alert('Book added successfully');
      fetchBooks(); // Refresh book list
    })
    .catch(error => {
      console.error('There was an error adding the book!', error);
      if (error.response) {
        // The request was made and the server responded with a status code
        // that falls out of the range of 2xx
        console.error(error.response.data);
        console.error(error.response.status);
        console.error(error.response.headers);
      } else if (error.request) {
        // The request was made but no response was received
        console.error(error.request);
      } else {
        // Something happened in setting up the request that triggered an Error
        console.error('Error', error.message);
      }
    });
};
  // Update book title
  const updateBook = (e) => {
    e.preventDefault();
    const token = localStorage.getItem('token');
 
    axios.put(`http://localhost:9000/api/admin/updateBook/${isbn}/${newTitle}`, {}, {
      headers: {
        Authorization: `Bearer ${token}`
      }
    })
      .then(response => {
        alert('Book updated successfully');
        fetchBooks(); // Refresh book list
      })
      .catch(error => {
        console.error('There was an error updating the book!', error);
      });
  };
 
  // Remove book
  const removeBook = (e) => {
    e.preventDefault();
    const token = localStorage.getItem('token');
 
    axios.delete(`http://localhost:9000/api/admin/removeBook/${isbn}`, {
      headers: {
        Authorization: `Bearer ${token}`
      }
    })
      .then(response => {
        alert('Book removed successfully');
        fetchBooks(); // Refresh book list
      })
      .catch(error => {
        console.error('There was an error removing the book!', error);
      });
  };
 
  return (
    <div>
      <h1>Login & Signup</h1>
 
      {/* Login Form */}
      <h2>Login</h2>
      <form onSubmit={loginUser}>
        <input
          type="email"
          placeholder="Email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
        <button type="submit">Login</button>
      </form>
 
      {/* Signup Form */}
      <h2>Signup</h2>
      <form onSubmit={signupUser}>
        <input
          type="text"
          placeholder="Name"
          value={name}
          onChange={(e) => setName(e.target.value)}
          required
        />
        <input
          type="email"
          placeholder="Email"
          value={signupEmail}
          onChange={(e) => setSignupEmail(e.target.value)}
          required
        />
        <input
          type="password"
          placeholder="Password"
          value={signupPassword}
          onChange={(e) => setSignupPassword(e.target.value)}
          required
        />
        <select value={userRole} onChange={(e) => setUserRole(e.target.value)}>
          <option value="0">Admin</option>
          <option value="1">User</option>
        </select>
        <button type="submit">Signup</button>
      </form>
 
      {/* Book Management Section */}
      <h1>Book Management</h1>
 
      {/* Add Book Section */}
      <h2>Add New Book</h2>
      <form onSubmit={addBook}>
        <input type="text" placeholder="Title" value={title} onChange={e => setTitle(e.target.value)} required />
        <input type="text" placeholder="Author" value={author} onChange={e => setAuthor(e.target.value)} />
        <input type="number" placeholder="Publication Year" value={publicationYear} onChange={e => setPublicationYear(e.target.value)} required />
        <button type="submit">Add Book</button>
      </form>
 
      {/* Update Book Section */}
      <h2>Update Book Title</h2>
      <form onSubmit={updateBook}>
        <input type="number" placeholder="ISBN" value={isbn} onChange={e => setIsbn(e.target.value)} required />
        <input type="text" placeholder="New Title" value={newTitle} onChange={e => setNewTitle(e.target.value)} required />
        <button type="submit">Update Book</button>
      </form>
 
      {/* Remove Book Section */}
      <h2>Remove Book</h2>
      <form onSubmit={removeBook}>
        <input type="number" placeholder="ISBN" value={isbn} onChange={e => setIsbn(e.target.value)} required />
        <button type="submit">Remove Book</button>
      </form>
 
      {/* List of Books */}
      <h2>Book List</h2>
      <ul>
        {books.map(book => (
          <li key={book.isbn}>
            {book.title} by {book.author} (Published: {book.publicationYear})
          </li>
        ))}
      </ul>
    </div>
  );
}
 
export default CodingChallenge;