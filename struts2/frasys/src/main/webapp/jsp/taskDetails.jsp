<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="task.name"/></title>
</head>
<body>
	<span style="font-weight:bold;">Código:</span> <s:property value="task.id"/><br/><br/>
    <span style="font-weight:bold;">Local:</span> <s:property value="task.location"/><br/><br/>
    <span style="font-weight:bold;">Resource:</span> <s:property value="task.resource"/><br/><br/>
    <span style="font-weight:bold;">Item:</span> <s:property value="task.item.description"/><br/><br/>
    <span style="font-weight:bold;">Iteration:</span> <s:property value="task.item.iteration.name"/><br/><br/>
    <span style="font-weight:bold;">Status:</span> <s:property value="task.status"/><br/><br/>
    <s:if test="%{isUser('MANAGER') || isUser('RESOURCE') || isUser('CLIENT')}">
       <a href="#"><button>Adicionar Comentário</button></a>
    </s:if>
    <s:if test="%{isUser('MANAGER') || isUser('RESOURCE')}">
       <a href="#"><button>Concluir Task</button></a>
    </s:if>
    <s:if test="%{isUser('CLIENT')}">
       <a href="#"><button>Aprovar Task</button></a>
    </s:if>
</body>
</html>