//importing graphql
const graphql = require('graphql');

const {
    GraphQLSchema
} = graphql;

// const users = [
//     {id: '1',firstName: 'Kelly',age: 23},
//     {id: '2',firstName: 'John',age: 32}
// ]

const RootQueryType = require('./RootQuery');
const mutations = require('./Mutations');


//assigning this to `module.exports`
//so that other part of app can also access
//this GraphQLSchema
module.exports = new GraphQLSchema({
    query: RootQueryType,
    mutation: mutations
});