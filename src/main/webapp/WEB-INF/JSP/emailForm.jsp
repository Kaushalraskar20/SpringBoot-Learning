<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Send Email</title>
</head>
<body>
    <h2>Send Email</h2>

    <% if ("success".equals(request.getParameter("status"))) { %>
        <p>
            Email sent successfully to <%= request.getParameter("to") %>
        </p>
    <% } else if ("error".equals(request.getParameter("status"))) { %>
        <p>
            Failed to send email. Please try again.
        </p>
    <% } %>

    <form action="${pageContext.request.contextPath}/EmailFormServlet"
          method="post">

        <label>Recipient Email:</label>
        <input type="email" name="to" required>
        <br><br>

        <label>Subject:</label>
        <input type="text" name="subject" required>
        <br><br>

        <label>Name:</label>
        <input type="text" name="name" required>
        <br><br>

        <label>Message:</label>
        <textarea name="message" required></textarea>
        <br><br>

        <button type="submit">Send Email</button>
    </form>
</body>
</html>