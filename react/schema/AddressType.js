const graphql = require('graphql');
const {
    GraphQLObjectType,
    GraphQLString
} = graphql;

const AddressType = new GraphQLObjectType({
    name: 'Address',
    //tell what all the properties has
    fields: () => ({
       id: { type: GraphQLString},
       address1: { type: GraphQLString},
       address2: {type: GraphQLString}
    })
});


module.exports = AddressType;