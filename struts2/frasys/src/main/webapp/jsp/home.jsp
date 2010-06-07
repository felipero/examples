<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
<%@taglib prefix="s" uri="/struts-tags" %>

<html lang="en">
<head>
	<title>Frasys - Initial</title>
	<s:head theme="ajax" />
</head>
<body>
	<s:url id="projectListURL" action="project!list" namespace="/ajax"/>
	<s:div href="%{projectListURL}" theme="ajax" errorText="An error ocurred!!!" loadingText="Loading Projects List!">
	</s:div>
</body>
</html>
