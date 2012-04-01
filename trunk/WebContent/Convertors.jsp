<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Celsius to Fahrenheit Convertor</title>
</head>
<body>

<% 
String status =request.getParameter("action");

out.println("Status value is-->"+status);
%>
<f:view>
	<h:form>
	</h:form>
	
	<h:outputText value="#{action}"></h:outputText>
	
<h:outputLink onclick="window.open('Convertor.jsp', 'DeployWindow', 'height=400,width=400,status=yes,toolbar=no,menubar=no,location=no, scrollbars=1'); return false;" value="#"> 
<f:param name="action" value="delete" />
<h:outputText value="popup" /> 
</h:outputLink> 
</f:view>
</body>
</html>
