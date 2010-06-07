<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
<s:head theme="ajax"/>
</head>
<body>
	<s:url id="projectListURL" action="project!list" namespace="/ajax"/>
	<s:div href="%{projectListURL}" theme="ajax" errorText="An error ocurred!!!" loadingText="Loading Projects List!">
	</s:div>
	<div style="padding: 20px;">
       <div align="center">
         <a href="project/create.jsp"><button>Create Project</button></a>
       </div>
	</div>
</body>
</html>