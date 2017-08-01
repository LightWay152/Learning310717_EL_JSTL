<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset=utf-8">
	<title>Register</title>
</head>
<body>
	<h1>Hello Servlet</h1>
	<form action="register.php" method="post">
		<div>
			<label>Username</label>
			<input name="id">
		</div>
		<div>
			<label>Password</label>
			<input name="password">
		</div>
		<div>
			<label>Fullname</label>
			<input name="fullname">
		</div>
		<div>
			<label>Email</label>
			<input name="email">
		</div>
		<div>
			<label>Photo</label>
			<input name="photo">
		</div>
		<div>
			<button>Register</button>
		</div>
	</form>
	${message}
</body>
</html>