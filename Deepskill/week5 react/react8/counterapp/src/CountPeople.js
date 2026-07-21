import React, { Component } from "react";

class CountPeople extends Component {
  constructor() {
    super();

    this.state = {
      entrycount: 0,
      exitcount: 0,
    };
  }

  UpdateEntry = () => {
    this.setState((prevState) => ({
      entrycount: prevState.entrycount + 1,
    }));
  };

  UpdateExit = () => {
    this.setState((prevState) => ({
      exitcount: prevState.exitcount + 1,
    }));
  };

  render() {
    return (
      <div className="container">
        <div className="box">
          <button onClick={this.UpdateEntry}>Login</button>
          <h3>{this.state.entrycount} People Entered!!</h3>
        </div>

        <div className="box">
          <button onClick={this.UpdateExit}>Exit</button>
          <h3>{this.state.exitcount} People Left!!</h3>
        </div>
      </div>
    );
  }
}

export default CountPeople;
