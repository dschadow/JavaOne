<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="resources/css/styles.css" />
	<title>Cross-Site Scripting (XSS)</title>
</head>
<body>
	<h1>Cross-Site Scripting (XSS)</h1>

    <p></p>

    <form action="unprotected" method="post">
        <fieldset>
            <legend>Unprotected</legend>
            <label for="unprotectedName">Name</label>
            <input type="text" id="unprotectedName" name="unprotectedName" />
            <input type="submit" value=" Send" />
        </fieldset>
    </form>

    <form action="validated" method="post">
        <fieldset>
            <legend>+ Input Validation</legend>
            <label for="inputValidatedName">Name</label>
            <input type="text" id="inputValidatedName" name="inputValidatedName" />
            <input type="submit" value=" Send" />
        </fieldset>
    </form>

    <form action="escaped" method="post">
        <fieldset>
            <legend>+ Output Escaping</legend>
            <label for="outputEscapedName">Name</label>
            <input type="text" id="outputEscapedName" name="outputEscapedName" />
            <input type="submit" value=" Send" />
        </fieldset>
    </form>

    <form action="csp" method="post">
        <fieldset>
            <legend>+ Content Security Policy (CSP)</legend>
            <label for="cspName">Name</label>
            <input type="text" id="cspName" name="cspName" />
            <input type="submit" value=" Send" />
        </fieldset>
    </form>
</body>
</html>