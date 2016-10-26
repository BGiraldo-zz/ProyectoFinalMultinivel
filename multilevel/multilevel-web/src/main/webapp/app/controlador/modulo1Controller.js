
app.controller("modulo1Controller",function ($scope,$http,$window,$sessionStorage) {

	//Modelo o mapeo de los atributos del formulario
	$scope.formData = {};

	//Mensaje por defecto del boton
	$scope.saveButtonText = "Agregar";

	$scope.mensaje = "";

	$scope.login=function(){
		//codificacion al contenttype
		var xsrf = $.param({ced:$scope.formData.user, cod:$scope.formData.pass});
		$http({
			url : '../rest/seguridad/validarlog',
			method : "POST",

			data : xsrf,
			headers : {
				"Content-Type" : "application/x-www-form-urlencoded"
			}

		}).success(function(data, status, headers, config) {
			if(data.cod=='00'){
				
				$sessionStorage.usuario=data.objeto;
				console.log($sessionStorage.usuario);
				$window.location.href='#/cursos';
			}else{
				alert(data.mensaje);
			}
			
			
		}).error(function(data, status, headers, config) {
			alert('error::'+data.mensaje);
		});
	};
	
	/**
	 * Agergar un nuevo espacio disponible
	 * 
	 * @param {[type]}
	 *            $event [description]
	 * @param {[type]}
	 *            $id [description]
	 * @return {[type]} [description]
	 */
	$scope.submitForm = function($event) {

		// $event, es para controlar el evento por defecto de enviar un formulario y evitar
		// que se recargue la pagina

		//Se serializa las variables del formulario listas para enviar a un webservice
		var data = this.formData;


		$scope.saveButtonText = "Guardando...";

		$http({
			url: '../addEspacio',
		    method: "GET",
		    params: data
		    
		}).success(function(data, status, headers, config) {
			

			if(data.status){

				//Limpiar los campos del formulario
				$scope.formData = [];
				$scope.saveButtonText = "Agregar";
				$scope.mensaje = "Solicitud enviada"
				
			}else{
				
				$scope.saveButtonText = "Agregar";
				$scope.mensaje = "Error en el envio"
			}

			
		}).error(function(data, status, headers, config) {
			$scope.saveButtonText = "Agregar";
			alert("Oops, Error en el servidor...");
		});

		
		$event.preventDefault();


	}


	//Envio con peticion POST
	$scope.submitFormPost = function($event) {

		// $event, es para controlar el evento por defecto de enviar un formulario y evitar
		// que se recargue la pagina

		//Se serializa las variables del formulario listas para enviar a un webservice
		//var data = this.formData;


		$scope.saveButtonText = "Guardando...";

		//Se arman los parametros de envio
		var xsrf = $.param({name:$scope.formData.nombre, lastname:$scope.formData.apellido});
		$http({
		    method: 'POST',
		    url: '../addEspacio',
		    data: xsrf,
		    headers: {'Content-Type': 'application/x-www-form-urlencoded'}

		}).success(function(data, status, headers, config) {

			//data: es la respuesta del servicio
			

			if(data.status){

				//Limpiar los campos del formulario
				$scope.formData = [];
				$scope.saveButtonText = "Agregar";
				$scope.mensaje = "Solicitud enviada"
				
			}else{
				
				$scope.saveButtonText = "Agregar";
				$scope.mensaje = "Error en el envio"
			}

			
		}).error(function(data, status, headers, config) {
			alert("Oops, Error en el servidor...");
		});

		
		$event.preventDefault();


	}

	

});