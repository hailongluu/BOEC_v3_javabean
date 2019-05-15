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
    <title>Log in</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/my.css" rel="stylesheet">
</head>

<body>
<div style="text-align: center;">
    <a class="navbar-brand" href="#" style="padding: 1px;"><img class="img-responsive" alt="Brand"
                                                                src="img/logo_blue_n.jpg"
                                                                style="width: 147px;margin: 20px 0px;"></a>


    <div class="card" style="width: 40rem;text-align: center; margin: 0 auto; /* Added */
        float: none; /* Added */
        margin-bottom: 10px; /* Added */">
        <div class="card-body">
            <h1 class="card-title">Login</h1>
            <form action="login" method="post">
                <div class="form-group row">
                    <label for="uname" class="col-sm-2 col-form-label">Username</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="uname" placeholder="Your username" name="username">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="pass" class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="pass" placeholder="Password" name="password">
                    </div>
                </div>

                <div class="form-group form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">I am not a robot</label>
                </div>

                <button type="submit" class="btn btn-primary" value="Submit" style="width: 20%">Submit</button>
            </form>
        </div>
    </div>

</div>
</body>
</html>