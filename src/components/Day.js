import React from 'react';
import { Card } from 'semantic-ui-react'

class Day extends React.Component{

  render(){

    let date = new Date(this.props.day.dateTimeISO).toString().split(' ').slice(0, 4).join(' ')

    return(
      <Card>
        <Card.Content>
          <Card.Header>
            {date}
          </Card.Header>
          <Card.Description>
            High: {this.props.temp ? this.props.day.maxTempF : this.props.day.maxTempC}
            <br/>
            Low: {this.props.temp ? this.props.day.minTempF : this.props.day.minTempC}
          </Card.Description>
        </Card.Content>
      </Card>
    )
  }
}

export default Day
