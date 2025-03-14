<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
String id = request.getParameter("userId");
String driverName = "org.postgresql.Driver";
String connectionUrl = "jdbc:postgresql:";
String dbName = "tybcs";
String userId = "postgres";
String password = "Postgres";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h2 align="center"><font><strong>Retrieve data from database in jsp</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="blue">
<td><b>Patient No</b></td>
<td><b>Patient Name</b></td>
<td><b>Patient Address</b></td>
<td><b>Patient Age</b></td>
<td><b>Patient Diseases</b></td>
</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM Patient";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
	
%>
<tr bgcolor="#DEB887">

<td><%=resultSet.getInt("pid") %></td>
<td><%=resultSet.getString("pname") %></td>
<td><%=resultSet.getString("padd") %></td>
<td><%=resultSet.getInt("page") %></td>
<td><%=resultSet.getString("pdis") %></td>

</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%></table>
</body>
</html>