<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <body>
    <h1>Tomcat replica</h1>
    <p>Hostname: <%= java.net.InetAddress.getLocalHost().getHostName() %></p>
    <p>Time: <%= new java.util.Date() %></p>
  </body>
</html>