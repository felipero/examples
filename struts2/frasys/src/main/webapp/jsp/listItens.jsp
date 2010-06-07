<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Itens</title>
</head>
<body>
	<display:table list="${itens}" class="defaultTable"
                   requestURI="${pageContext.request.contextPath}/jsp/project!itens.action"
                   pagesize="5" id="item" cellpadding="0" cellspacing="0" sort="list">
        <display:column title="Código" property="id"/>
        <display:column title="Descrição" property="description"/>
        <display:column title="Prioridade" property="priority" sortable="true"/>
        <display:column title="Iteration" property="iteration.name" sortable="true"/>
        <display:column title="Edit">
            <a href="${pageContext.request.contextPath}/jsp/project!show.action?project.id=${item.iteration.project.id}&iteration.id=${item.iteration.id}&item.id=${item.id}">
                Edit
            </a>
        </display:column>
    </display:table>
</body>
</html>