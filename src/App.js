import React, { Component } from 'react';
import DaysContainer from './components/DaysContainer';
import { Button } from 'semantic-ui-react'
import 'semantic-ui-css/semantic.min.css';
import './App.css';


class App extends Component {

  componentDidMount(){
    let url = `${process.env.REACT_APP_URL}client_id=${process.env.REACT_APP_ID}&client_secret=${process.env.REACT_APP_SECRET}`
    fetch(url)
      .then(res => res.json())
      .then(json => this.setState({days: json.response[0].periods}))
  }

  handleNext = () =>{
    let url = `${process.env.REACT_APP_URL}limit=14&client_id=${process.env.REACT_APP_ID}&client_secret=${process.env.REACT_APP_SECRET}`
    fetch(url)
      .then(res => res.json())
      .then(json => this.setState({
        days: (this.state.next ? json.response[0].periods.slice(0, 7) : json.response[0].periods.slice(7)),
        next: !this.state.next
      }))
  }

  state = {
    days: [],
    next: false
  }

  render() {
    let thisWeek = <Button size='tiny' onClick={this.handleNext} name='this'>Back to This Week</Button>
    let nextWeek = <Button size='tiny' onClick={this.handleNext} name='next'>Next 7 Days</Button>
    return (
      <div className="App">
        <header className="App-header">
          <h1 className="App-title">Welcome to The Weather App</h1>
          <img src={'sun.png'} className="App-logo" alt="logo" />
        </header>
        <DaysContainer days={this.state.days}/>
        {this.state.next ? thisWeek : nextWeek }
      </div>
    );
  }
}

export default App;
