const express = require("express");
const router = express.Router();

router.get("/", (req, res, next) => {
    return res.status(200).json({
        message: "Hello from todo list",
    });
});

router.post("/", (req, res, next) => {
    return res.status(200).json({
        message: "Post todo list",
        body: req.body,
        reqHeaders: req.headers,
        reqObj: req,
    });
});

module.exports = router;
