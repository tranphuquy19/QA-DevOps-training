var express = require('express');
var router = express.Router();

const USERS = {
  'admin': {
    password: 'root@123'
  },
  'invalid_user': {
    password: 'invalid'
  }
}

const POSTS = [];

/* GET home page. */
router.get('/', function (req, res, next) {
  res.status(200).json({ message: 'Welcome to the Postman API Testing App' });
});

router.get('/login', function (req, res, next) {
  res.status(200).render('login', { title: 'Login' });
});

router.post('/login', function (req, res, next) {
  const { username, password } = req.body;
  if (USERS[username] && USERS[username].password === password) {
    return res.redirect('/welcome');
  } else {
    return res.redirect('/login');
  }
});

router.get('/welcome', function (req, res, next) {
  res.status(200).render('welcome', { title: 'Welcome' });
});

router.post('/posts', function (req, res, next) {
  const { title, body } = req.body;
  POSTS.push({ title, body });
  res.render('posts', { title: 'Posts', posts: POSTS });
});

router.get('/new-post', function (req, res, next) {
  res.render('new_post');
});

module.exports = router;
