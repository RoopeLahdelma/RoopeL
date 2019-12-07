<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Weapon List</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />

</head>
<body>
	
	<h1>Weapons</h1>
<a class="btn btn-secondary" href="new-category">New weapon category</a>
<a class="btn btn-secondary" href="DS3_GAME_INFO">Control Page</a>
	<table class="table table-striped" >
		
		<thead>
      <tr>
        <th>WeaponType</th>
        <th>Build</th>
        <th>Info</th>
      </tr>
    </thead>
    
    <tbody>
		<c:forEach items="${weapons}" var="weapon">
			
			<tr>
				<td><c:out value="${weapon.types}" /></td>
				<td><c:out value="${weapon.buildtype}" /></td> 
				<td><c:out value="${weapon.lisat}" /></td>
				<td><a class="btn btn-primary" href="edit-weapon?id=<c:out value='${weapon.id}' />">Edit</a></td>
				<td><a class="btn btn-danger" onclick="return confirm('Are you sure you want to delete weapon with type = ${weapon.types}?')" href="delete_weapon?id=<c:out value='${weapon.id}' />">Delete</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<p><c:out value="${param.viesti}" /></p>
	
</body>
</html>