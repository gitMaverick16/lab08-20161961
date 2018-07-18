<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.Kids"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ver Niño</title>
<link rel="stylesheet" type="text/css" href="../css/estilo.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  		<link type="text/css" href="../menu.css" rel="stylesheet" />
    <link type="text/css" href="../menu2.css" rel="stylesheet" />
     <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="../slide.js" type="text/javascript"></script>
    <script src="../nav.js" type="text/javascript"></script>
    </head>
    <body>
	  <div class="grid-container">
            <div class="logo">
                <a href="../"><img id="circa" src="../circalogo.png"><h4>Santo Tomas de Aquino</h4></a>
            </div>

            <div class="login">
                <h6>
                <a href="/users/login">Log in</a>
                <a href="/users/logout">Log out</a>
                </h6>
            </div>
    </div>
    <div id="menu">
        <ul class="menu">
            <li><a href="#" class="parent"><span>Menu</span></a>
                <ul>
                    <li><a href="/kids"><span>Niños</span></a></li>
                    <li><a href="/homeworks"><span>Tareas</span></a></li>
                    <li><a href="/users"><span>Usuarios</span></a></li>
                    <li><a href="/access"><span>Accesos</span></a></li>
                    <li><a href="/resources"><span>Recursos</span></a></li>
                    <li><a href="/roles"><span>Roles</span></a></li>
                    <li><a href="/listas"><span>Listas</span></a></li>
                </ul>
            </li>
            <li><a href="#" class="parent"><span>Galeria</span></a>
                <ul>
                    <li><a href="../galeriaNinios.html"><span>Misión España</span></a></li>
                    <li><a href="../galeriaNinios.html"><span>Albergue</span></a></li>
                    <li><a href="../galeriaNinios.html"><span>Niños</span></a></li>
                </ul>
            </li>
        </ul>
    </div>
	<br>
	<br>


	<%
		Kids p = (Kids) request.getAttribute("niños");
	%>
	<center>
		<h2>Datos del niño</h2>
	</center>
	<center>
		<table>


			<tr>
				<td>Id del niño:</td>
				<td><%=p.getId()%></td>
			</tr>
			<tr>
				<td>Nombre del niño:</td>
				<td><%=p.getName()%></td>
			</tr>
			<tr>
				<td>Nombre del tutor:</td>
				<td><%=p.getTutor()%></td>
			</tr>
			<tr>
				<td>DNI del niño:</td>
				<td><%=p.getDNI()%></td>
			</tr>
			<tr>
				<td>Fecha de ingreso:</td>
				<td><%=p.getCreated()%></td>
			</tr>
			<tr>
				<td>Sexo del niño:</td>
				<%
					if (p.isGender() == true) {
				%>
				<td>Hombre</td>
				<%
					} else {
				%>
				<td>Mujer</td>
				<%
					}
				%>
			</tr>
			<tr>
				<td>Grado del niño:</td>
				<%
					if (p.getGrado().equals("1p")){
				%>
				<td>1° de primaria</td>
				<%
					}
				%>
				<%
				if (p.getGrado().equals("2p")){
				%>
				<td>2° de primaria</td>
				<%
					}
				%>
				<%
				if (p.getGrado().equals("3p")){
				%>
				<td>3° de primaria</td>
				<%
					}
				%>
				<%
				if (p.getGrado().equals("4p")){
				%>
				<td>4° de primaria</td>
				<%
					}
				%>
				<%
				if (p.getGrado().equals("5p")){
				%>
				<td>5° de primaria</td>
				<%
					}
				%>
				<%
				if (p.getGrado().equals("6p")){
				%>
				<td>6° de primaria</td>
				<%
					}
				%>
				<%
				if (p.getGrado().equals("1s")){
				%>
				<td>1° de secundaria</td>
				<%
					}
				%>
				<%
				if (p.getGrado().equals("2s")){
				%>
				<td>2° de secundaria</td>
				<%
					}
				%>
				<%
				if (p.getGrado().equals("3s")){
				%>
				<td>3° de secundaria</td>
				<%
					}
				%>
			</tr>
			<tr>
				<td>Lugar de nacimiento:</td>
				<td><%=p.getPlace_birth()%></td>
			</tr>
			<tr>
				<td>Fecha de nacimiento:</td>
				<td><%=p.getBirth()%></td>
			</tr>
			<tr>
				<td>Correo del padre:</td>
				<td><%=p.getCorreo()%></td>
			</tr>
			<tr>
				<td>Padre:</td>
				<td><%=p.getPadre()%></td>
			</tr>
			<tr>
				<td>Madre:</td>
				<td><%=p.getMadre()%></td>
			</tr>
			<tr>
				<td>Religion:</td>
				<td><%=p.getReligion()%></td>
			</tr>
			<tr>
				<td>Hobby:</td>
				<td><%=p.getHobby()%></td>
			</tr>
		</table>
	</center>

</body>
</html>