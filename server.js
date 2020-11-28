const express = require('express'),
  app = express(),
  port = process.env.PORT || 3000,
  bodyParser = require('body-parser');

const Gpio = require('onoff').Gpio;

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());


var routes = require('./api/routes/routes'); //importing route
routes(app); //register the route


app.listen(port);

console.log('=============================================================');
console.log('Welcome to LazyBones.  Hardwired API control of your remotes.');
console.log('See drivers directrory for home automation system drivers.');
console.log('=============================================================');

if  (Gpio.accessible){
  console.log('System is GPIO capable');
}else{
  console.log('System is not GPIO capable. API results are mocked.');
}
console.log('LazyBones started on port: ' + port);
