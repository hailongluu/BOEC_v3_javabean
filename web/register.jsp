<%--
  Created by IntelliJ IDEA.
  User: hailongluu
  Date: 4/18/2019
  Time: 7:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration form</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/my.css" rel="stylesheet">
</head>

<body style="margin: 0 10%">
<a class="navbar-brand" href="#" style="padding: 1px;"><img class="img-responsive" alt="Brand"
                                                            src="img/logo_blue_n.jpg"
                                                            style="width: 147px;margin: 0px;"></a>
<h1>Register Form</h1>

<form action="register" method="post">
    <div class="form-group">
        <label for="fname">First Name</label>
        <input type="text" class="form-control" id="fname" placeholder="Enter your Firstname" name="firstName">
    </div>

    <div class="form-group">
        <label for="lname">Last Name</label>
        <input type="text" class="form-control" id="lname" placeholder="Your Lastname" name="lastName">
    </div>

    <div class="form-group">
        <label for="uname">UserName</label>
        <input type="text" class="form-control" id="uname" placeholder="Your username" name="username">
    </div>

    <div class="form-group">
        <label for="pass">Password</label>
        <input type="password" class="form-control" id="pass" placeholder="Password" name="password">
    </div>

    <div class="form-group">
        <label for="add">Address</label>
        <input type="text" class="form-control" id="add" placeholder="Enter your address" name="add" aria-describedby="addHelp">
        <small id="addHelp" class="form-text text-muted">We'll never share your information with anyone else.</small>
    </div>

    <div class="form-group">
        <label for="contact">Contact No</label>
        <input type="text" class="form-control" id="contact" placeholder="Your Contact Number" name="contact">
    </div>

    <div class="form-group form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1">
        <label class="form-check-label" for="exampleCheck1">I am not a robot</label>
    </div>

    <button type="submit" class="btn btn-primary" value="Submit">Submit</button>
</form>

</body>
</html>