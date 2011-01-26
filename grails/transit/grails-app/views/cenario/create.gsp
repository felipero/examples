

<%@ page import="transit.Cenario" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'cenario.label', default: 'Cenario')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1>att = ${session.some_att}<g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${cenarioInstance}">
            <div class="errors">
                <g:renderErrors bean="${cenarioInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="csp"><g:message code="cenario.csp.label" default="Csp" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: cenarioInstance, field: 'csp', 'errors')}">
                                    <g:select name="csp.id" from="${transit.CSP.list()}" optionValue="value" optionKey="id" value="${cenarioInstance?.csp?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="descricao"><g:message code="cenario.descricao.label" default="Descricao" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: cenarioInstance, field: 'descricao', 'errors')}">
                                    <g:textField name="descricao" value="${cenarioInstance?.descricao}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="nome"><g:message code="cenario.nome.label" default="Nome" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: cenarioInstance, field: 'nome', 'errors')}">
                                    <g:textField name="nome" value="${cenarioInstance?.nome}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="sentido"><g:message code="cenario.sentido.label" default="Sentido" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: cenarioInstance, field: 'sentido', 'errors')}">
                                    %{--<g:checkBox name="sentido" value="${cenarioInstance?.sentido}" />--}%
                                  %{--<g:select name="sentido" from="${['Entrada', 'Saída':1]}"/> --}%
                                  <select id="sentido" name="sentido">
                                    <option value="0">Entrada</option>
                                    <option value="1">Saída</option>
                                  </select>
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
