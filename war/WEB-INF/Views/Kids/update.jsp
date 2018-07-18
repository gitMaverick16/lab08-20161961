<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.Kids" %>
<%@ page import ="java.util.Date" %>
<%@ page import ="java.text.SimpleDateFormat" %>
<% SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd") ;%>
<%Kids p = (Kids)request.getAttribute("niños"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Actualizar Niño</title>
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
    </div><br><br>
	
	<body>
	<form method="post" action="/kids/update">
	<h1>Niño</h1>
    <fieldset>
	<input type="text" name="id" value="<%=p.getId() %>" hidden>
	<label>Nombre y apellidos completos:</label>
	<input type="text" name="name" value="<%= p.getName() %>" placeholder="Nombre " required>
	
	<label>Nombre de tutor:</label>
	<input type="text" name="tutor" value="<%= p.getTutor() %>" placeholder="tutor" required>
	
	<label>DNI:</label>
	<input type="text" name="DNI" value="<%= p.getDNI() %>" placeholder="DNI" required>
	
	<label>Fecha de ingreso:</label>
	<input type="date" name="created" value="<%=sdf.format(p.getCreated()) %>"  required><br>
	
	<%if(p.isGender()==true){ %>
	<input type="radio" name="gender" value="true" checked>Hombre<br>
	<input type="radio" name="gender" value="false">Mujer<br>
	<%}else { %>
	<input type="radio" name="gender" value="true" >Hombre<br>
	<input type="radio" name="gender" value="false" checked>Mujer<br>
	<%} %>
	
	<label>Grado:</label><br>
	<%if(p.getGrado().equals("1p")) {%>
		  <input type="radio" name="grado" value="1p" checked>1° primaria 
		  <input type="radio" name="grado" value="2p" >2° primaria 
		  <input type="radio" name="grado" value="3p" >3° primaria 
		  <input type="radio" name="grado" value="4p" >4° primaria 
		  <input type="radio" name="grado" value="5p" >5° primaria 
		  <input type="radio" name="grado" value="6p" >6° primaria 
		  <input type="radio" name="grado" value="1s" >1° secundaria 
		  <input type="radio" name="grado" value="2s" >2° secundaria
		  <input type="radio" name="grado" value="3s" >3° secundaria <br>
	<%}if(p.getGrado().equals("2p")){ %>
	<input type="radio" name="grado" value="1p" >1° primaria 
		  <input type="radio" name="grado" value="2p" checked >2° primaria 
		  <input type="radio" name="grado" value="3p" >3° primaria 
		  <input type="radio" name="grado" value="4p" >4° primaria 
		  <input type="radio" name="grado" value="5p" >5° primaria 
		  <input type="radio" name="grado" value="6p" >6° primaria 
		  <input type="radio" name="grado" value="1s" >1° secundaria 
		  <input type="radio" name="grado" value="2s" >2° secundaria
		  <input type="radio" name="grado" value="3s" >3° secundaria <br>
	<%}if(p.getGrado().equals("3p")){ %>
	<input type="radio" name="grado" value="1p" >1° primaria 
		  <input type="radio" name="grado" value="2p" >2° primaria 
		  <input type="radio" name="grado" value="3p" checked>3° primaria 
		  <input type="radio" name="grado" value="4p" >4° primaria 
		  <input type="radio" name="grado" value="5p" >5° primaria 
		  <input type="radio" name="grado" value="6p" >6° primaria 
		  <input type="radio" name="grado" value="1s" >1° secundaria 
		  <input type="radio" name="grado" value="2s" >2° secundaria
		  <input type="radio" name="grado" value="3s" >3° secundaria <br>
	<%}if(p.getGrado().equals("4p")){ %>
	<input type="radio" name="grado" value="1p">1° primaria 
		  <input type="radio" name="grado" value="2p" >2° primaria 
		  <input type="radio" name="grado" value="3p" >3° primaria 
		  <input type="radio" name="grado" value="4p" checked>4° primaria 
		  <input type="radio" name="grado" value="5p" >5° primaria 
		  <input type="radio" name="grado" value="6p" >6° primaria 
		  <input type="radio" name="grado" value="1s" >1° secundaria 
		  <input type="radio" name="grado" value="2s" >2° secundaria
		  <input type="radio" name="grado" value="3s" >3° secundaria <br>
	<%}if(p.getGrado().equals("5p")){ %>
	<input type="radio" name="grado" value="1p" >1° primaria 
		  <input type="radio" name="grado" value="2p" >2° primaria 
		  <input type="radio" name="grado" value="3p" >3° primaria 
		  <input type="radio" name="grado" value="4p" >4° primaria 
		  <input type="radio" name="grado" value="5p" checked>5° primaria 
		  <input type="radio" name="grado" value="6p" >6° primaria 
		  <input type="radio" name="grado" value="1s" >1° secundaria 
		  <input type="radio" name="grado" value="2s" >2° secundaria
		  <input type="radio" name="grado" value="3s" >3° secundaria <br>
	<%}if(p.getGrado().equals("6p")){ %>
	<input type="radio" name="grado" value="1p">1° primaria 
		  <input type="radio" name="grado" value="2p" >2° primaria 
		  <input type="radio" name="grado" value="3p" >3° primaria 
		  <input type="radio" name="grado" value="4p" >4° primaria 
		  <input type="radio" name="grado" value="5p" >5° primaria 
		  <input type="radio" name="grado" value="6p" checked>6° primaria 
		  <input type="radio" name="grado" value="1s" >1° secundaria 
		  <input type="radio" name="grado" value="2s" >2° secundaria
		  <input type="radio" name="grado" value="3s" >3° secundaria <br>
	<%}if(p.getGrado().equals("1s")){ %>
	<input type="radio" name="grado" value="1p">1° primaria 
		  <input type="radio" name="grado" value="2p" >2° primaria 
		  <input type="radio" name="grado" value="3p" >3° primaria 
		  <input type="radio" name="grado" value="4p" >4° primaria 
		  <input type="radio" name="grado" value="5p" >5° primaria 
		  <input type="radio" name="grado" value="6p" >6° primaria 
		  <input type="radio" name="grado" value="1s" checked>1° secundaria 
		  <input type="radio" name="grado" value="2s" >2° secundaria
		  <input type="radio" name="grado" value="3s" >3° secundaria <br>
	<%}if(p.getGrado().equals("2s")){ %>
	<input type="radio" name="grado" value="1p">1° primaria 
		  <input type="radio" name="grado" value="2p" >2° primaria 
		  <input type="radio" name="grado" value="3p" >3° primaria 
		  <input type="radio" name="grado" value="4p" >4° primaria 
		  <input type="radio" name="grado" value="5p" >5° primaria 
		  <input type="radio" name="grado" value="6p" >6° primaria 
		  <input type="radio" name="grado" value="1s" >1° secundaria 
		  <input type="radio" name="grado" value="2s" checked>2° secundaria
		  <input type="radio" name="grado" value="3s" >3° secundaria <br>
	<%}if(p.getGrado().equals("3s")){ %>
	<input type="radio" name="grado" value="1p">1° primaria 
		  <input type="radio" name="grado" value="2p" >2° primaria 
		  <input type="radio" name="grado" value="3p" >3° primaria 
		  <input type="radio" name="grado" value="4p" >4° primaria 
		  <input type="radio" name="grado" value="5p" >5° primaria 
		  <input type="radio" name="grado" value="6p" >6° primaria 
		  <input type="radio" name="grado" value="1s" >1° secundaria 
		  <input type="radio" name="grado" value="2s" >2° secundaria
		  <input type="radio" name="grado" value="3s" checked>3° secundaria <br>
	<%}%>
	
	<label>Lugar de nacimiento:</label>
	<input type="text" name="place_birth" value="<%= p.getPlace_birth() %>" placeholder="lugar de nacimiento" required>
	
	<label>Fecha de nacimiento:	</label>
	<input type="date" name="birth" value="<%=sdf.format( p.getBirth()) %>"required>
	
	</label>Correo del padre:</label>
	<input type="email" name="correo" value="<%= p.getCorreo() %>" placeholder="asd@gmail.com" required><br>
	
	<label>Padre:</label>
	<input type="text" name="padre" value="<%= p.getPadre() %>" placeholder="padre" required>
	
	<label>Madre:</label>
	<input type="text" name="madre" value="<%= p.getMadre() %>" placeholder="madre" required>
	
	<label>Religion:</label>
	<input type="text" name="religion" value="<%= p.getReligion() %>" placeholder="religion" required>
	
	<label>Hobby:</label>
	<input type="text" name="hobby" value="<%= p.getHobby() %>" placeholder="hobby" required>
	
	<button type="submit">Registrar niño</button>
	</fieldset>
	</form>
	</body>
</html>
