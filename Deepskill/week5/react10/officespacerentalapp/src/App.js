import React from "react";
import "./App.css";
import officeImg from "./images/office.jpg";

function App() {
  const offices = [
    {
      id: 1,
      name: "Skyline Tech Park",
      rent: 55000,
      address: "Noida, Uttar Pradesh",
    },
    {
      id: 2,
      name: "Cyber Hub",
      rent: 75000,
      address: "Gurugram, Haryana",
    },
    {
      id: 3,
      name: "Business Square",
      rent: 48000,
      address: "Lucknow, Uttar Pradesh",
    },
    {
      id: 4,
      name: "Corporate Plaza",
      rent: 90000,
      address: "Delhi",
    },
  ];

  return (
    <div className="container">
      <h1>Office Space Rental App</h1>

      <img src={officeImg} alt="Office" className="office-image" />

      <hr />

      {offices.map((office) => (
        <div className="card" key={office.id}>
          <h2>{office.name}</h2>

          <p>
            <strong>Address :</strong> {office.address}
          </p>

          <p>
            <strong>Rent :</strong>

            <span
              style={{
                color: office.rent < 60000 ? "red" : "green",
                fontWeight: "bold",
              }}
            >
              ₹ {office.rent}
            </span>
          </p>
        </div>
      ))}
    </div>
  );
}

export default App;
