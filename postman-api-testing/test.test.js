pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

pm.test("Response contains welcome message", function () {
    pm.response.to.have.jsonBody({
        message: "Welcome to Postman api testing"
    });
});