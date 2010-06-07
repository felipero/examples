<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Iterations</title>
</head>
<body>
<div style="padding: 10px; padding-left: 20px;">
	<display:table list="${iterations}" class="defaultTable" pagesize="5" cellspacing="0" cellpadding="0" 
	 sort="list" id="iteration" requestURI="${pageContext.request.contextPath}/jsp/project!iterations.action">
	 	<display:column title="Código" property="id" />
	 	<display:column title="Nome" property="name"/>
        <display:column title="Data de Início" sortable="true">
            <fmt:formatDate value="${iteration.startDate}" dateStyle="long"/>
        </display:column>
        <display:column title="Data Final" sortable="true">
            <fmt:formatDate value="${iteration.endDate}" dateStyle="long"/>
        </display:column>
        <display:column title="Edit">
        	<a href="${pageContext.request.contextPath}/jsp/project!show.action?project.id=${iteration.project.id}&iteration.id=${iteration.id}">Edit</a>
        </display:column>
	</display:table>
</div>
</body>
</html>