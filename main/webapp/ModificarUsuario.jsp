<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

	<head>
	
	    <meta charset="utf-8">
		<title>Modificar Usuario</title>
		
		 <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <meta name="author" content="Videojuegos & Desarrollo">
        <meta name="description" content="Muestra de un formulario de acceso en HTML y CSS">
        <meta name="keywords" content="Formulario Acceso, Formulario de LogIn">
        
        <link href="https://fonts.googleapis.com/css?family=Nunito&display=swap" rel="stylesheet"> 
        <link href="https://fonts.googleapis.com/css?family=Overpass&display=swap" rel="stylesheet">
        
        <!-- Link hacia el archivo de estilos css -->
        <link rel="stylesheet" href="css\modificarusuario.css">
        
        <style type="text/css">
            
        </style>
        
        <script type="text/javascript">
        
        </script>
	</head>
	<body>
		
		 <div id="contenedor">
            <div id="central">
                <div id="musuario">
                    <div class="titulo">
                        Modificar Usuario
                    </div>
                    <form id="Cusuarioform">
                    
					    <select class="form-select" multiple aria-label="El select de los nicknames">
					  		<option selected>Seleccione un Usuario</option>
					 		<option value="1">Uno</option>
					 		<option value="2">Dos</option>
					 		<option value="3">Tres</option>
						</select>
						
						</form>
							
						<form>
						  <p>
						    <label for="Nombre">Nombre:</label>
                        	<input type="text" id="fname" name="fname"><br>
						  </p>
						  <p>
						    <label for="Apellido">Apellido:</label>
                        	<input type="text" id="fapellido" name="fapellido"><br>
						  </p>
						  <p>
						  	<label for="Fecha de nacimiento">Fecha de nacimiento:</label>
                        	<input type="text" id="ffecha" name="ffecha"><br>
						  </p>
						</form>

                        <button type="submit" title=Aceptar name="Aceptar">Aceptar</button>
                   
                </div>

            </div>
        </div>
		
	</body>
	
</html>