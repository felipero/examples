
<%@ page import="transit.Cenario" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="layout" content="main" />
  <g:set var="entityName" value="${message(code: 'cenario.label', default: 'Cenario')}" />
  <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<div class="nav">
  <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
  <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
</div>
<div class="body">

  <g:form nome="search_form" action="search">
    <p>Nome: <g:textField name="nome" value="${params.nome}" /></p>
    <p>CSP: <g:select name="csp.id" from="${transit.CSP.list()}" noSelection="${['null':'Select One...']}" optionValue="value" optionKey="id" value="${cenarioInstance?.csp?.id}"  /></p>
    <p>Sentido: <select id="sentido" name="sentido">
                <option selected value="">----</option>
                <option value="0">Entrada</option>
                <option value="1">Saída</option>
              </select></p>
    <g:submitButton name="submit" value="Search" />
  </g:form>
  <h1><g:message code="default.list.label" args="[entityName]" /></h1>
  <g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
  </g:if>
  <div class="list">
    <table>
      <thead>
      <tr>

        <g:sortableColumn property="id" title="${message(code: 'cenario.id.label', default: 'Id')}" />

        <th><g:message code="cenario.csp.label" default="Csp" /></th>

        <g:sortableColumn property="descricao" title="${message(code: 'cenario.descricao.label', default: 'Descricao')}" />

        <g:sortableColumn property="nome" title="${message(code: 'cenario.nome.label', default: 'Nome')}" />

        <g:sortableColumn property="sentido" title="${message(code: 'cenario.sentido.label', default: 'Sentido')}" />

      </tr>
      </thead>
      <tbody>
      <g:each in="${cenarioInstanceList}" status="i" var="cenarioInstance">
        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

          <td><g:link action="show" id="${cenarioInstance.id}">${fieldValue(bean: cenarioInstance, field: "id")}</g:link></td>

          <td>${fieldValue(bean: cenarioInstance, field: "csp")}</td>

          <td>${fieldValue(bean: cenarioInstance, field: "descricao")}</td>

          <td>${fieldValue(bean: cenarioInstance, field: "nome")}</td>

          <td><g:formatBoolean boolean="${cenarioInstance.sentido}" /></td>

        </tr>
      </g:each>
      </tbody>
    </table>
  </div>
  <div class="paginateButtons">
    <g:paginate total="${cenarioInstanceTotal}" />
  </div>
</div>
</body>
</html>
