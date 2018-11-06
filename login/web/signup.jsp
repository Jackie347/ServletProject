<%-- 
    Document   : index
    Created on : Nov 4, 2018, 6:17:16 PM
    Author     : jackie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en"> 

    <head>
        <!-- Required meta tags -->
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Signup</title>

        <!-- Bootstrap CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <!-- Other CSS -->
        <link rel="stylesheet" type="text/css" href="css/index.css">
    </head>
    
    <body>
        <h1>Sign up</h1>
        <div class="container">
            <div class="row">
                <div class="col-3"></div>
                <div class="col-6">
                    <form method = "POST" action="SignupServlet" id="signupform">
                        <input type="hidden" name="sign" />
                        <div class="form-group row">
                            <label for="inputUsername" class="col-2 col-form-label">Username</label>
                            <div class="col-10">
                                <input type="text" class="form-control" name="username" id="username" placeholder="Username">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="inputPassword" class="col-2 col-form-label">Password</label>
                            <div class="col-10">
                                <input type="password" class="form-control" name="password" id="password" placeholder="Password">
                            </div>              
                        </div>
                        <div class="form-group row">
                            <div class="col-9">
                              
                            </div>    
                            <div class="col-3">
                                <button type="submit" class="btn btn-primary">Sign up</button>
                            </div>         
                        </div>
                    </form>
                </div>
                <div class="col-3"></div>
            </div>
        </div>
    </body>
</html>
