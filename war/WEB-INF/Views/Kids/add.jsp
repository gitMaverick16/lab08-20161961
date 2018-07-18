<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Agregar Niño</title>
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

      <form method="post" action="/kids/add">
      
        <h1>Niño</h1>
        <fieldset>
          <label>Nombre y apellidos completos:</label>
		  <input type="text" name="name" placeholder="Nombre " required >
          
		  <label>Nombre del tutor:</label>
		  <input type="text" name="tutor" placeholder="tutor" required>
		  
		  <label>DNI:</label>
		  <input type="text" name="DNI" placeholder="90909090 " pattern="[0-9]{8}" required>
			
          <label>Fecha de ingreso:</label>
		  <input type="date" name="created" required >
		 
		  <label>Sexo:</label><br>
          <input type="radio" name="gender" value="true" checked >Hombre
		  <input type="radio" name="gender" value="false" >Mujer<br>
		  
		  <label>Grado:</label><br>
		  <input type="radio" name="grado" value="1p" checked>1° primaria 
		  <input type="radio" name="grado" value="2p" >2° primaria 
		  <input type="radio" name="grado" value="3p" >3° primaria 
		  <input type="radio" name="grado" value="4p" >4° primaria 
		  <input type="radio" name="grado" value="5p" >5° primaria 
		  <input type="radio" name="grado" value="6p" >6° primaria 
		  <input type="radio" name="grado" value="1s" >1° secundaria 
		  <input type="radio" name="grado" value="2s" >2° secundaria
		  <input type="radio" name="grado" value="3s" >3° secundaria <br>
		  
          <label>Lugar de nacimiento:</label>
		  <input type="text" name="place_birth" placeholder="lugar de nacimiento" required>
          
		  <label>Fecha de nacimiento:	</label>
		  <input type="date" name="birth"  required>
		  
		  <label for="correo">Correo del padre:</label>
		  <input type="email" name="correo" placeholder="asd@gmail.com" required>
				
		  <label>Padre:</label>
		  <input type="text" name="padre" placeholder="padre" requiered>
		  
		  <label>Madre:</label>
		  <input type="text" name="madre" placeholder="madre" required>
		  
		  <label>Religion:</label>
		  <input type="text" name="religion" placeholder="religion" required>
		  
		  <label for="civil_status">Hobby:</label>
		  <input type="text" name="hobby" placeholder="hobby" required>
        </fieldset>
        <button type="submit">Registrar niño</button>
      </form>
    </body>
</html>