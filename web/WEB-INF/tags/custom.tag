<%@tag description="Example tag" pageEncoding="UTF-8"%>
<%@attribute name="student" required="true" type="org.sda.dto.Student"%>

Imie i Nazwisko: ${student.name} <br>
Email: ${student.email} <br>
Obecny?: ${student.present} <br>