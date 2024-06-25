<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error</title>
<script type="text/javascript">
	function showMessageAndRedirect(error, url) {
		alert(error);
		window.location.href = url;
	}
</script>
</head>
<body>
	<script type="text/javascript">
		showMessageAndRedirect('${error}', '${url}');
	</script>
</body>
</html>