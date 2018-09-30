<!DOCTYPE html>
<%@ page language="java" 
		contentType="text/html; charset=UTF-8" 
		pageEncoding="UTF-8"%>
<html>

<head>
	<meta charset="utf-8">
	<title>Welcome</title>
	<style>
	body { font-size:14pt; color:#666; }
	h1 { font-size:70pt; color:#aaa; margin:-15px 0px; }
	</style>
</head>

<body>
	<h1>Index Page</h1>
	<p>${msg}</p>
	<form method="post" action="./post">
	<table>
	<tr><th>TITLE</th>
	<td><input type="text" name="title"></td></tr>
	<tr><th>CONTENT</th>
	<td><textarea name="content"></textarea></td></tr>
	<tr><th></th><td><input type="submit"></td></tr>
	</table>
	</form>
</body>

</html>
