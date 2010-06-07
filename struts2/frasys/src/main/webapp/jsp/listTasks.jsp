<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tasks</title>
</head>
<body>
	<display:table list="${tasks}" class="defaultTable"
                   requestURI="${pageContext.request.contextPath}/jsp/project!tasks.action"
                   pagesize="5" id="task" cellpadding="0" cellspacing="0" sort="list">
        <display:column title="Código" property="id"/>
        <display:column title="Nome" property="name"/>
        <display:column title="Local" property="location" sortable="true"/>
        <display:column title="Resource" property="resource" sortable="true"/>
        <display:column title="Item" property="item.description" sortable="true"/>
        <display:column title="Iteration" property="item.iteration.name" sortable="true"/>
        <display:column title="Status" property="status" sortable="true"/>
        <display:column title="Edit">
            <a href="${pageContext.request.contextPath}/jsp/project!show.action?project.id=${task.item.iteration.project.id}&iteration.id=${task.item.iteration.id}&item.id=${task.item.id}&task.id=${task.id}">
                Edit
            </a>
        </display:column>
    </display:table>
</body>
</html>