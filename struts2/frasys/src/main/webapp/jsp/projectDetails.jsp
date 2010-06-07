<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="project.name"/></title>
</head>
<body>
<div style="padding: 10px; padding-left: 20px;">
	<span style="font-weight:bold;">Código:</span><s:property value="project.id"/><br/><br/>
	<span style="font-weight:bold;">Descrição:</span><s:property value="project.description"/><br/><br/>
	<span style="font-weight:bold;">Local:</span><s:property value="project.location"/><br/><br/>	
	<span style="font-weight:bold;">Deadline:</span><s:date name="project.lastDate" nice="true"/><br/><br/>
	<s:if test="%{isUser('MANAGER') || isUser('ADMIN')}">
		<a href="${pageContext.request.contextPath}/admin/project/addIteration.jsp?project=${project.id}"><button>Adicionar Iteração</button></a>
	</s:if>
	<s:if test="%{isUser('MANAGER') || isUser('RESOURCE') || isUser('CLIENT')}">
		<a href="#"><button>Adicionar Comentário</button></a>
	</s:if>
</div>
<h5>Iterations</h5>
<s:include value="listIterations.jsp"/>
</body>
</html>