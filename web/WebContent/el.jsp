<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Expression Language</title>
</head>
<body>
	<h1>Expression Language</h1>
	<h2>Scope</h2>
	<ul>
		<li>${x}</li>
		<li>${requestScope['x']}</li>
		<li>${sessionScope['x']}</li>
		<li>${applicationScope['x']}</li>
	</ul>
		
	<h2>Bean</h2>
	<ul>
		<li>${bean.name}</li>
		<li>${bean.nameVN}</li>
	</ul>
		
	<h2>Collection</h2>
	<ul>
		<li>${cols[0]}</li>
		<li>${cols[1]}</li>
	</ul>
	
	<h2>Map</h2>
	<ul>
		<li>${map['Tuan']}</li>
		<li>${map['Huong']}</li>
	</ul>
	
	<h2>Parameters</h2>
	<ul>
		<li>${param['name']}</li>
		<li>${param.age}</li>
	</ul>
	
</body>
</html>