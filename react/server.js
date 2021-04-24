//importing express
const express = require('express');
//importing express-graphql
const expressGraphQL = require('express-graphql').graphqlHTTP;

//importing schema.js in server.js
//so canbe picked by server at runtime
const schema = require('./schema/schema');

//defining a variable here
//if no variable defined at runtime externally
//then default will be 4000
const PORT = process.env.PORT || 4000; 

//making a new express app
const app = express();

//initialising endpoints
//http://localhost:4000/graphql
app.use('/graphql', expressGraphQL({
    schema,
    //is a development tool to allow to make query to server in a GUI way
    graphiql: true
}));


//this app will listen on port 4000
//localhost:4000
app.listen(PORT,()=> {
    console.log("server started and listening on 4000. Can be accessible via http://localhost:4000");
})