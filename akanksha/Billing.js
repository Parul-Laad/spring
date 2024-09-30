// Billing.js
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Billing = () => {
  const navigate = useNavigate();
  const [name, setName] = useState('');
  const [price, setPrice] = useState('');
  const [qty, setQty] = useState('');

  const handleBilling = () => {
    const total = Number(price) * Number(qty);
    navigate('/billing-summary', { state: { name, price, qty, total } });
  };

  return (
    <div className="container">
      <h2>Billing</h2>
      <div>
        <label>Name:</label>
        <input
          type="text"
          value={name}
          onChange={(e) => setName(e.target.value)}
          placeholder="Enter Name"
        />
      </div>
      <div>
        <label>Price:</label>
        <input
          type="number"
          value={price}
          onChange={(e) => setPrice(e.target.value)}
          placeholder="Enter Price"
        />
      </div>
      <div>
        <label>Quantity:</label>
        <input
          type="number"
          value={qty}
          onChange={(e) => setQty(e.target.value)}
          placeholder="Enter Quantity"
        />
      </div>
      <div>
        <button onClick={handleBilling}>Calculate Total</button>
      </div>
    </div>
  );
};

export default Billing;
