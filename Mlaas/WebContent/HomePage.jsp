<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body bgcolor="Teal">
        <form method="post" action="checkLogin.jsp">
            <table cellspacing="8" cellpadding="8">
                <tr>
                    <td>Select user id :</td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>Select Item id :</td>
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