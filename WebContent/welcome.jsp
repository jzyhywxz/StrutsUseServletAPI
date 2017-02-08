<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><s:text name="welcomePage"/></title>
</head>
<body>
  <s:text name="welcomeTip">
    <s:param>${sessionScope.username}</s:param>
    <s:param>${applicationScope.visitCount}</s:param>
    <s:param>${requestScope.currentTime}</s:param>
  </s:text>
</body>
</html>