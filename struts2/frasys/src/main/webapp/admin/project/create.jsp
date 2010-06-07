<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="s" uri="/struts-tags" %>
<s:head theme="ajax"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>:FRASYS: - Create Project</title>
</head>
<body>
	<s:form action="project!add" namespace="/admin" method="post">
		<s:textfield key="project.name"/>
		<s:textfield key="project.description"/>
        <s:datetimepicker label="%{getText('project.lastdate')}" name="lastDate" displayFormat="dd/MM/yyyy" theme="ajax"/>
        <s:textfield key="project.location"/>
        <s:submit key="project.add"/>
	</s:form>
</body>
</html>