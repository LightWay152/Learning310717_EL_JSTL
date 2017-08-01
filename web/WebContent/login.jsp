<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset=utf-8">
	<title>Login</title>
</head>
<body>
	<h1>Hello Servlet</h1>
	<form action="login.php" method="post">
		<div>
			<label>Username</label>
			<input name="id" value="${cookie['uid'].value}">
		</div>
		<div>
			<label>Password</label>
			<input name="password" value="${cookie['upw'].value}">
		</div>
		<div>
			<input type="checkbox" name="remember">
			<label>Remember me?</label>
		</div>
		<div>
			<button>Login</button>
		</div>
	</form>
	${message}
</body>
</html>