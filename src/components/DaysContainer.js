import React from 'react';
import Day from './Day.js'
import { Card } from 'semantic-ui-react'

class DaysContainer extends React.Component{

  state={
    Farenheit: true
  }

  switch = () =>{
    this.setState({Farenheit: !this.state.Farenheit})
  }

  render(){

    let days = this.props.days.map( (day, ind) => <Day day={day} key={ind} temp={this.state.Farenheit} />)

    return(
      <div>
        <button onClick={this.switch}>C/F</button>
        <Card.Group itemsPerRow={7}>
          {days}
        </Card.Group>
      </div>
    )
  }
}

export default DaysContainer
