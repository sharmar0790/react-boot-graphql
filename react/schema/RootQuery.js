
const UserType = require('./UserType');
const AddressType = require('./AddressType');
const axios = require('axios');
const graphql = require('graphql');

const {
    GraphQLObjectType,
    GraphQLString
} = graphql;

//RootQuery is the actual
//app will be receiving from client
const RootQuery = new GraphQLObjectType({
    name: 'RootQueryType',
    fields: {
        user: {
            type: UserType,
            args: {id: {type: GraphQLString}},
            //this is the method where we will be
            //writing the actual code to retrieve the data from
            //actual database
            resolve(parentValue,args){
                return axios.get(`http://localhost:8070/api/users/${args.id}`)
                .then(resp => resp.data);
            }
        },
        address: {
            type: AddressType,
            args: {id: {type: GraphQLString}},
            //this is the method where we will be
            //writing the actual code to retrieve the data from
            //actual database
            resolve(parentValue,args){
                return axios.get(`http://localhost:8070/api/address/${args.id}`)
                .then(r => r.data);
            }
        }
    }
});

module.exports = RootQuery;