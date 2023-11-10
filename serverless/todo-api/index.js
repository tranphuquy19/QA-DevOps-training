const serverless = require("serverless-http");
const express = require("express");
const app = express();

app.use(express.json());

const todoRoutes = require("./routes/todo.api");

app.get("/", (req, res, next) => {
  return res.status(200).json({
    message: "Hello from root! I'm a DevOps guy",
  });
});

app.use("/todo", todoRoutes);

app.use((req, res, next) => {
  return res.status(404).json({
    error: "Not Found",
  });
});

module.exports.handler = serverless(app);
