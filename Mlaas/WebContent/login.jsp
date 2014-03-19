<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

 <body bgcolor="Teal">
        <form method="post" action="checkLogin.jsp">
            <table cellspacing="8" cellpadding="8">
                <tr>
                    <td>UserName:</td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>PassWord:</td>
                    <td><input type="password" name="password"></td>
                </tr>
            </table>
            <br>
            <table cellspacing="4">
                <tr>
                    <td><input type="submit" name="Done" value="Done"></td>
                </tr>
            </table>
        </form>
    </body>

</html>