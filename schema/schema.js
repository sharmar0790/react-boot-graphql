//importing graphql
const graphql = require('graphql');
const _ = require('lodash');

const {
    GraphQLObjectType,
    GraphQLString,
    GraphQLInt,
    GraphQLSchema
} = graphql;

const users = [
    {id: '1',firstName: 'Kelly',age: 23},
    {id: '2',firstName: 'John',age: 32}
]

//defining UserType object
const UserType = new GraphQLObjectType({
    name: 'User',
    //tell what all the properties has
    fields: {
       id: { type: GraphQLString},
       firstName: { type: GraphQLString},
       age: { type: GraphQLInt}     
    }
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
                return _.find(users,{id: args.id});
            }
        }
    }
});

//assigning this to `module.exports`
//so that other part of app can also access
//this GraphQLSchema
module.exports = new GraphQLSchema({
    query: RootQuery
});