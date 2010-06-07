<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>:FRASYS: - Add Item</title>
</head>
<body>
	<s:form action="project!addItem" namespace="/admin" method="post">
    	<input type="hidden" name="project.id" value="${empty project.id ? param.project : project.id}" />
    	<input type="hidden" name="iteration.id" value="${empty iteration.id ? param.iteration : iteration.id}" />
    	<s:textfield key="item.description"/>
    	<s:select list="{'1','2','3','4','5'}" key="item.priority"/>
    	<s:submit key="item.add"/>
	</s:form>
</body>
</html>