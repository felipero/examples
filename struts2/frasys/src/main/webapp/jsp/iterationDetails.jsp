<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="iteration.name"/></title>
</head>
<body>
<div style="padding: 10px; padding-left: 20px;">
	<span style="font-weight:bold;">Código:</span> <s:property value="iteration.id"/> <br/><br/>
	<span style="font-weight:bold;">Projeto:</span> <s:property value="iteration.project.name"/> <br/><br/>
	<span style="font-weight:bold;">Data de Início:</span> <s:date name="iteration.startDate" nice="true"/> <br/><br/>
	<span style="font-weight:bold;">Data Final:</span> <s:date name="iteration.endDate" nice="true" /> <br/><br/>
	<s:if test="%{isUser('MANAGER') || isUser('ADMIN')}">
		<a href="${pageContext.request.contextPath}/admin/project/addItem.jsp?project=${iteration.project.id}&iteration=${iteration.id}"><button>Adicionar Item</button></a>
	</s:if>
	<s:if test="%{isUser('MANAGER') || isUser('RESOURCE') || isUser('CLIENT')}">
		<a href="#"><button>Adicionar Comentário</button></a>
	</s:if>
</div>
<h5>Itens</h5>
<s:include value="listItens.jsp"/> 
</body>
</html>