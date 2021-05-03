const graphql = require('graphql');
const axios = require('axios');
const AddressType = require('./AddressType');
const {
    GraphQLObjectType,
    GraphQLString,
    GraphQLInt,
    GraphQLList
} = graphql;

//defining UserType object
const UserType = new GraphQLObjectType({
    name: 'User',
    //tell what all the properties has
    fields: () => ({
       id: { type: GraphQLString},
       firstName: { type: GraphQLString},
       age: { type: GraphQLInt},     
       address: {
            type: new GraphQLList(AddressType),
            resolve(parentValue,args){
                return axios.get(`http://localhost:8070/api/address/${parentValue.id}`)
                .then(r => r.data);
            }
       }
    })
});

module.exports = UserType;