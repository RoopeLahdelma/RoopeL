<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Weapon Class</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
</head>
<body>
	<h1>New Weapon Class</h1>
		<form action="new-category" method="post">
			<table>
				<tr>
					<td>Type:</td>
					<td><input type="text" 
					value=""
					name="types" size="50"  />
				</td>
				</tr>
				<tr>
					<td>Buildtype:</td>
					<td><input type="text" 
					value=""
					name="buildtype" size="50"  />
					</td>
				</tr>
				<tr>	
					<td>Info:</td>
					<td><input type="text" 
					value=""
					name="lisat" size="50"  />
					</td>
				</tr>
					
				<tr>
					<td>
						<input type="submit" name="submit-button" class="btn btn-success" value="Submit" />
						<a href="weapons"><input type="button" class="btn btn-danger" value="Cancel"/></a>
					</td>
					
				</tr>	
			</table>
			</form>
			
			
			
			
		
</body>
</html>