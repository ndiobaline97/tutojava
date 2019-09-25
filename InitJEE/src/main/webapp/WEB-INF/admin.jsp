<%@ page contentType="text/html" isELIgnored="false" language="java" %>
<!DOCTYPE html>
<html>
<body>
<h2>Voici ma page admin!</h2>${pageContext.request.contextPath}
<a href="${pageContext.request.contextPath}/employe?action=add">voici le lien</a>
</body>
</html>