<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>:FRASYS: - Add Task</title>
</head>
<body>
	<s:form action="project!addTask" namespace="/admin" method="post">
    	<input type="hidden" name="project.id" value="${empty project.id ? param.project : project.id}"/>
    	<input type="hidden" name="iteration.id" value="${empty iteration.id ? param.iteration : iteration.id}"/>
    	<input type="hidden" name="item.id" value="${empty item.id ? param.item : item.id}"/>
    	<s:textfield key="task.name"/>
    	<s:textfield key="task.location"/>
    	<s:submit key="task.add"/>
	</s:form>
</body>
</html>