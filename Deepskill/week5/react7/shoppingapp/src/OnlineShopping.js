import React, { Component } from "react";
import Cart from "./Cart";
import "./OnlineShopping.css";

class OnlineShopping extends Component {
  constructor() {
    super();

    this.items = [
      { Itemname: "Laptop", Price: 80000 },
      { Itemname: "Desktop", Price: 120000 },
      { Itemname: "Washing Machine", Price: 50000 },
      { Itemname: "Mobile", Price: 30000 },
      { Itemname: "Fridge", Price: 70000 },
    ];
  }

  render() {
    return (
      <div className="container">
        <h1>Items Ordered :</h1>

        <table>
          <thead>
            <tr>
              <th>Name</th>
              <th>Price</th>
            </tr>
          </thead>

          <tbody>
            {this.items.map((item, index) => (
              <Cart key={index} Itemname={item.Itemname} Price={item.Price} />
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default OnlineShopping;
