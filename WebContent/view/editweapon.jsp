
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Edit Weapon</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
</head>
<body>
<h1>Edit Weapon type = ${weapon.types}</h1>

<form action="edit-weapon" method="post">
<input type="hidden" value="${weapon.id}" name="id"/>
<label>Weapon name:</label>
<input type="text" name="types" value="${weapon.types}" class="form-control" size="50"/>
<br/>
<label>Buildtype:</label>
<input type="text" name="buildtype" value="${weapon.buildtype}" class="form-control" size="50"/>
<br/>
<label>Info:</label>
<input type="text" name="lisat" value="${weapon.lisat}" class="form-control" size="50"/>
<br/>
<input type="submit" class="btn btn-success" name="submit-button" value="Modify"/>
<a href="weapons"><input type="button" class="btn btn-danger" value="Cancel"/></a>
</form>
</body>
</html>