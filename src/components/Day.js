import React from 'react';

class Day extends React.Component{

  render(){

    let date = new Date(this.props.day.dateTimeISO).toString().split(' ').slice(0, 4).join(' ')

    return(
      <div>
        <h4>{date}</h4>
        <ul>
          <li>High: {this.props.day.maxTempF}</li>
          <li>Low: {this.props.day.minTempF}</li>
        </ul>

      </div>
    )
  }
}

export default Day
