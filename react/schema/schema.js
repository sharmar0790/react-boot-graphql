//importing graphql
const graphql = require('graphql');
const axios = require('axios');

const {
    GraphQLObjectType,
    GraphQLString,
    GraphQLInt,
    GraphQLSchema,
    GraphQLList,
    GraphQLNonNull
} = graphql;

const users = [
    {id: '1',firstName: 'Kelly',age: 23},
    {id: '2',firstName: 'John',age: 32}
]

const AddressType = new GraphQLObjectType({
    name: 'Address',
    //tell what all the properties has
    fields: () => ({
       id: { type: GraphQLString},
       address1: { type: GraphQLString},
       address2: {type: GraphQLString}
    })
});

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


const mutation = new GraphQLObjectType({
    name: 'Mutation',
    fields: {
        addUser: {
            type: UserType,
            args: {
                // id: { type: new GraphQLNonNull(GraphQLString)},
                firstName: { type: GraphQLString},
                age: { type: GraphQLInt}, 
            },
            resolve(parentValue,{firstName,age}){
                return axios.post(`http://localhost:8070/api/users`,{firstName,age})
                .then(r => r.data);
            }
        }
    }
});

//assigning this to `module.exports`
//so that other part of app can also access
//this GraphQLSchema
module.exports = new GraphQLSchema({
    query: RootQuery,
    mutation
});