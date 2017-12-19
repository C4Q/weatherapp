import React, { Component } from 'react';
import DaysContainer from './components/DaysContainer';
import './App.css';
import 'semantic-ui-css/semantic.min.css';


class App extends Component {

  componentDidMount(){
    let url = `http://api.aerisapi.com/forecasts/11101?client_id=${process.env.REACT_APP_ID}&client_secret=${process.env.REACT_APP_SECRET}`
    fetch(url)
      .then(res => res.json())
      .then(json => this.setState({days: json.response[0].periods}))
  }

  state = {
    days: []
  }

  render() {
    console.log(this.state.days);
    return (
      <div className="App">
        <header className="App-header">
          <h1 className="App-title">Welcome to Your Weather App</h1>
          <img src={'sun.png'} className="App-logo" alt="logo" />
        </header>
        <DaysContainer days={this.state.days}/>
      </div>
    );
  }
}

export default App;
