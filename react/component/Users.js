import React, { Component } from 'react';
import gql from 'graphql-tag';

class Users extends Component{

    render(){
        return (
            <div>
                UserList
            </div>
        );
    }
}

const query = gql`
{
    user(id: "1"){
      id
      firstName
    }
  }
`;

export default Users;