<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<s:head theme="ajax"/>
<html>
<head>
<title>:FRASYS: - Add Project Iteration</title>
</head>
<body>
	<s:form action="project!addIteration" namespace="/admin" method="post">
		<s:textfield key="iteration.name"/>
		<s:datetimepicker key="iteration.startDate" displayFormat="dd/MM/yyyy" name="startDate"/>
		<s:datetimepicker key="iteration.endDate" displayFormat="dd/MM/yyyy" name="endDate"/>
	    <s:submit key="iteration.add"/>
	    <input type="hidden" name="project.id" value="${empty project.id ? param.project : project.id}" />
	</s:form>	
</body>
</html>