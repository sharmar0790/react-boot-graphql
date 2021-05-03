const UserType = require('./UserType');
const axios = require('axios');
const graphql = require('graphql');

const {
    GraphQLObjectType,
    GraphQLString,
    GraphQLInt
} = graphql;

const Mutation = new GraphQLObjectType({
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

module.exports = Mutation;