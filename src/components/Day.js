import React from 'react';
import { Card, Image } from 'semantic-ui-react'

class Day extends React.Component{



  render(){
    let date = new Date(this.props.day.dateTimeISO).toString().split(' ').slice(0, 3).join(' ')
    let letter = (this.props.temp ?  'F' : 'C')

    return(
      <Card>
        <Image src={`icons/${this.props.day.icon}`} />
        <Card.Content>
          <Card.Header>
            {date}
          </Card.Header>
          <Card.Description>
            High: {this.props.temp ? `${this.props.day.maxTempF}° ${letter}` : `${this.props.day.maxTempC}° ${letter}`}
            <br/>
            Low: {this.props.temp ? `${this.props.day.minTempF}° ${letter}`: `${this.props.day.minTempC}° ${letter}`}
          </Card.Description>
        </Card.Content>
      </Card>
    )
  }
}

export default Day
