<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
<%@taglib prefix="s" uri="/struts-tags" %>

<html lang="en">
<head>
	<title>Sign In</title>
	<s:head />
</head>
<body>
	<s:form action="j_security_check">
		<s:textfield label="Fratech's Login" name="j_username" />
		<s:password label="Password" name="j_password" />
		<s:submit />
	</s:form>
</body>
</html>
	