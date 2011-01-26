
<%@ page import="tdcg.Carro" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'carro.label', default: 'Carro')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'carro.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="ano" title="${message(code: 'carro.ano.label', default: 'Ano')}" />
                        
                            <g:sortableColumn property="modelo" title="${message(code: 'carro.modelo.label', default: 'Modelo')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${carroInstanceList}" status="i" var="carroInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${carroInstance.id}">${fieldValue(bean: carroInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: carroInstance, field: "ano")}</td>
                        
                            <td>${fieldValue(bean: carroInstance, field: "modelo")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${carroInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
