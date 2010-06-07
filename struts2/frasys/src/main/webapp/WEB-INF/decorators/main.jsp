<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html lang="en">
<head>
	<title><decorator:title default="Frasys"/></title>
	
    <link href="<s:url value='/styles/main.css'/>" rel="stylesheet" type="text/css" media="all"/>
    
    <link href="<s:url value='/struts/niftycorners/niftyCorners.css'/>" rel="stylesheet" type="text/css"/>
    <link href="<s:url value='/struts/niftycorners/niftyPrint.css'/>" rel="stylesheet" type="text/css" media="print"/>
    <script language="JavaScript" type="text/javascript" src="<s:url value='/struts/niftycorners/nifty.js'/>"></script>
	<script language="JavaScript" type="text/javascript">
        window.onload = function(){
            if(!NiftyCheck()) {
                return;
            }
            // perform niftycorners rounding
            // eg.
            // Rounded("blockquote","tr bl","#ECF1F9","#CDFFAA","smooth border #88D84F");
        }
    </script>
    <decorator:head/>
</head>
<body id="page-home">
    <div id="page">
        <div id="header" class="clearfix">
        	FRASYS - Task Control System
            <hr />
        </div>
        
        <div id="content" class="clearfix">
            <div id="main">
            	<h3><decorator:title default="Frasys" /></h3>
            	<decorator:body/>
                <hr />
            </div>
            
            <div id="local">
            </div>

            <div id="nav">
                <div class="wrapper">
                <h3>Actions</h3>
                <ul class="clearfix">
                     <li><a href="${pageContext.request.contextPath}/jsp/project!list.action">My Projects</a></li>
                     <li><a href="${pageContext.request.contextPath}/jsp/project!iterations.action">My Iterations</a></li>
                     <li><a href="${pageContext.request.contextPath}/jsp/project!itens.action">My Itens</a></li>
                     <li><a href="${pageContext.request.contextPath}/jsp/project!tasks.action">My Tasks</a></li>                     
                </ul>
                </div>
                <hr />
            </div>
        </div>
        
        <div id="footer" class="clearfix">
            <p>Copyright © 2007 - Fratech IT</p>
        </div>
        
    </div>
    
    <div id="extra1">&nbsp;</div>
    <div id="extra2">&nbsp;</div>
</body>
</html>
