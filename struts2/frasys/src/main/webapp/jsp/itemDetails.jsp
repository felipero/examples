<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="item.description"/></title>
</head>
<body>
<div style="padding: 10px; padding-left: 20px;">
    <span style="font-weight:bold;">Código:</span> <s:property value="item.id"/><br/><br/>
    <span style="font-weight:bold;">Descrição:</span> <s:property value="item.description"/><br/><br/>
    <span style="font-weight:bold;">Priority:</span> <s:property value="item.priority"/><br/><br/>
    <span style="font-weight:bold;">Iteration:</span> <s:property value="item.iteration.name"/><br/><br/>
    <span style="font-weight:bold;">Projeto:</span> <s:property value="item.iteration.project.name"/><br/><br/>
    <s:if test="%{isUser('MANAGER') || isUser('ADMIN')}">
        <a href="${pageContext.request.contextPath}/admin/project/addTask.jsp?project=${item.iteration.project.id}&iteration=${item.iteration.id}&item=${item.id}">
            <button>Adicionar Task</button>
        </a>
    </s:if>
    <s:if test="%{isUser('MANAGER') || isUser('RESOURCE') || isUser('CLIENT')}">
       <a href="#"><button>Adicionar Comentário</button></a>
    </s:if>
</div>
<h5>Tasks</h5>
<s:include value="listTasks.jsp"/>
</body>
</html>