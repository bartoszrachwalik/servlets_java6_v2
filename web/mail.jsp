<%@ page import = "java.io.*,java.util.*,javax.mail.*"%>
<%@ page import = "javax.mail.internet.*,javax.activation.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import = "org.sda.util.SMTPAuthenticator" %>


<%
    String result;

    // Recipient's email ID needs to be mentioned.
    String to = "javawro6@gmail.com";

    // Sender's email ID needs to be mentioned
    String from = "urzadskarbowy@gov.pl";

    String host = "smtp.gmail.com";

    // Get system properties object
    Properties properties = System.getProperties();

    // Setup mail server
    properties.setProperty("mail.transport.protocol", "smtp");
    properties.setProperty("mail.smtp.host", host);
    properties.setProperty("mail.smtp.port", "587");
    properties.setProperty("mail.smtp.auth", "true");
    properties.setProperty("mail.smtp.starttls.enable", "true");


    // Get the default Session object.
    Authenticator auth = new SMTPAuthenticator();

    Session mailSession = Session.getDefaultInstance(properties, auth);

    try {
        // Create a default MimeMessage object.
        MimeMessage message = new MimeMessage(mailSession);

        // Set From: header field of the header.
        message.setFrom(new InternetAddress(from, from));
        message.setReplyTo(new Address[]{new InternetAddress(to, to)});

        // Set To: header field of the header.
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(to));
        // Set Subject: header field
        message.setSubject("WEZWANIE","UTF-8");

        // Now set the actual message
//        message.setText("<h1>This is fake address message</h1>");
        String text = request.getParameter("text");
        if(text == null){
            text = "Default message";
        }
        message.setContent(text, "text/html" );

//        message.setHeader("Content-Type","text/html; charset=UTF-8");
        // Send message
        Transport.send(message);
        result = "Sent message successfully....";
    } catch (MessagingException mex) {
        mex.printStackTrace();
        result = "Error: unable to send message....";
    }

%>

<html>
<head>
    <title>Send Email using JSP</title>
</head>

<body>
<center>
    <h1>Send Email using JSP</h1>
</center>

<p align = "center">
    <%
        out.println("Result: " + result + "\n");
    %>
</p>
</body>
</html>