<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

	<head>
	
	    <meta charset="utf-8">
		<title>Consultar Usuario</title>
		
		 <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <meta name="author" content="Videojuegos & Desarrollo">
        <meta name="description" content="Muestra de un formulario de acceso en HTML y CSS">
        <meta name="keywords" content="Formulario Acceso, Formulario de LogIn">
        
        <link href="https://fonts.googleapis.com/css?family=Nunito&display=swap" rel="stylesheet"> 
        <link href="https://fonts.googleapis.com/css?family=Overpass&display=swap" rel="stylesheet">
        
        <!-- Link hacia el archivo de estilos css -->
        <link rel="stylesheet" href="css\consultausuario.css">
        
        <style type="text/css">
            
        </style>
        
        <script type="text/javascript">
        
        </script>
	</head>
	<body>
		
		 <div id="contenedor">
            <div id="central">
                <div id="cusuario">
                    <div class="titulo">
                        Consulta Usuario
                    </div>
                    <form id="Cusuarioform">
                        <select class="form-select" multiple aria-label="El select de los nicknames">
						  <option selected>Seleccione un Usuario</option>
						  <option value="1">Uno</option>
						  <option value="2">Dos</option>
						  <option value="3">Tres</option>
						</select>
                        
                        <label for="Email">Email:</label>
                        <label for="EmailR">EmailR</label><br>
                        <label for="Nombre">Nombre:</label>
                        <label for="NombreR">NombreR</label><br>
                        <label for="Apellido">Apellido:</label>
                        <label for="ApellidoR">ApellidoR</label><br>
                        <label for="Fecha de nacimiento">Fecha de nacimiento:</label>
                        <label for="Fecha de nacimientoR">Fecha de nacimiento</label> <br>
                        
                        <button type="submit" title=VerClases name="VerClases">Ver Clases</button>
                        <button type="submit" title=VerAct name="VerAct">Ver Actividades</button>
                        <button type="submit" title=Salir name="Salir">Salir</button>
                    </form>
                   
                </div>

            </div>
        </div>
		
	</body>
	
</html>