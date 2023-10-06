var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.status(200).json({ message: 'Welcome to the Postman API Testing App' });
});

/* GET random success endpoint. */
router.get('/success', function(req, res, next) {
  var random = Math.floor(Math.random() * 2);
  if (random === 0) {
    var responseTime = Math.floor(Math.random() * 1000);
    setTimeout(function() {
      res.status(200).json({ message: 'This is a successful response' });
    }, responseTime);
  } else {
    var responseTime = Math.floor(Math.random() * 1000);
    setTimeout(function() {
      res.status(500).json({ message: 'This is an error response' });
    }, responseTime);
  }
});

/* GET random failure endpoint. */
router.get('/failure', function(req, res, next) {
  var random = Math.floor(Math.random() * 2);
  if (random === 0) {
    var responseTime = Math.floor(Math.random() * 1000);
    setTimeout(function() {
      res.status(500).json({ message: 'This is an error response' });
    }, responseTime);
  } else {
    var responseTime = Math.floor(Math.random() * 1000);
    setTimeout(function() {
      res.status(200).json({ message: 'This is a successful response' });
    }, responseTime);
  }
});

/* GET random delay endpoint. */
router.get('/delay', function(req, res, next) {
  var random = Math.floor(Math.random() * 2);
  if (random === 0) {
    var responseTime = Math.floor(Math.random() * 1000);
    setTimeout(function() {
      res.status(200).json({ message: 'This is a successful response' });
    }, responseTime);
  } else {
    var responseTime = Math.floor(Math.random() * 1000);
    setTimeout(function() {
      res.status(500).json({ message: 'This is an error response' });
    }, responseTime);
  }
});



module.exports = router;
