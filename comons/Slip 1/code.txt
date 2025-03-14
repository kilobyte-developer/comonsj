<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>

<html>
<head>
    <title>JSP Implicit Objects Example</title>
</head>
<body>

    <!-- 1. 'out' to display current date and time -->
    <h3>Current Date and Time:</h3>
    <p><%= new Date() %></p>

    <!-- 2. 'request' to get header information -->
    <h3>Request Headers:</h3>
    <ul>
        <li>User-Agent: <%= request.getHeader("User-Agent") %></li>
        <li>Host: <%= request.getHeader("Host") %></li>
    </ul>

    <!-- 3. 'response' to add a cookie -->
    <%
        Cookie cookie = new Cookie("UserVisit", "FirstVisit");
        response.addCookie(cookie);
    %>
    <h3>Cookie Added Successfully</h3>

    <!-- 4. 'config' to get parameter values defined in web.xml -->
    <h3>Config Parameter Value:</h3>
    <p><%= config.getInitParameter("paramName") %></p>

    <!-- 5. 'application' to get parameter values -->
    <h3>Application Scope Parameter:</h3>
    <p><%= application.getInitParameter("paramName") %></p>

    <!-- 6. 'session' to display current session ID -->
    <h3>Session ID:</h3>
    <p><%= session.getId() %></p>

    <!-- 7. 'pageContext' to set and get attributes -->
    <%
        pageContext.setAttribute("message", "This is stored in pageContext");
    %>
    <h3>PageContext Attribute:</h3>
    <p><%= pageContext.getAttribute("message") %></p>

    <!-- 8. 'page' to get the name of the generated servlet -->
    <h3>Generated Servlet Class:</h3>
    <p><%= this.getClass().getName() %></p>

</body>
</html>