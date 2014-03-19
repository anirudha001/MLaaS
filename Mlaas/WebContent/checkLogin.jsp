<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

<%
            String username = request.getParameter("username");
            String password = request.getParameter("password");
           out.println("Checking login<br>");
            if (username == null || password == null) {

                out.print("Invalid paramters ");
            }

            // Here you put the check on the username and password
            if (username.toLowerCase().trim().equals("anirudha") && password.toLowerCase().trim().equals("anirudha")) {
                //out.println("Welcome " + username + " <a href=\"login.jsp\">Back to main</a>");
                session.setAttribute("username", username);
                //response.sendRedirect("login.jsp");
                RequestDispatcher rd=getServletContext().getRequestDispatcher("/Actionn");
                rd.forward(request,response);
            }
           else 
               {
                out.println("Invalid username and password");
                int i=22;
                //RequestDispatcher rd=getServletContext().getRequestDispatcher("/Actionn");
                //rd.include(request,response);
           }


%>
 
</body>
</html>