<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
		<style>
			body{
				font-size:14pt;
				color:red;
			}
			h1{
				font-size:80pt;
				color:blue;
			}
		</style>
	</head> 
<body>
		<h1>Wellcome!</h1>
		<h2>${msg}</h2>
		
		<form method="post" action="./post">
		<input type="text" name="text1">
		<input type="submit" value="submit">
	</body>
</html>
