import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {

  componentDidMount(){
    let url = `http://api.aerisapi.com/forecasts/11101?client_id=${process.env.REACT_APP_ID}&client_secret=${process.env.REACT_APP_SECRET}`
    fetch(url)
      .then(res => res.json())
      .then(json => console.log(json.response[0]))
  }

  state = {}

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p>
      </div>
    );
  }
}

export default App;
