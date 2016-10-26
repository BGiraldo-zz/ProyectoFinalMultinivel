app.controller("cursosController", function($scope, $http, httpservice,
		$sessionStorage) {

	$scope.codigo = $sessionStorage.usuario.cod;
	$scope.cursos = [];

	function cargarCursos() {
		// console.log('accediendo.....');
		// console.log($sessionStorage.usuario.ced);
		// console.log($sessionStorage.usuario.cod);
		// httpservice.post('estudiante/cursoestudiante',
		// {ced:$sessionStorage.usuario.ced, cod:$sessionStorage.usuario.cod},
		// success = function(data, status, headers,
		// config) {
		// console.log('success.......');
		// $scope.cursos = data.obj;
		// }, null);

		var xsrf = $.param({
			ced : $sessionStorage.usuario.ced,
			cod : $sessionStorage.usuario.cod
		});
		console.log($sessionStorage.usuario.ced);
		$http({
			url : '../rest/estudiante/cursoestudiante',
			method : "POST",

			data : xsrf,
			headers : {
				"Content-Type" : "application/x-www-form-urlencoded",
				"Authorization" : $sessionStorage.usuario.token
			}

		}).success(function(data, status, headers, config) {
			if (data.cod == '00') {

				$scope.cursos = data.objeto;
				console.log($sessionStorage.usuario);
			} else {
				alert(data.mensaje);
			}

		}).error(function(data, status, headers, config) {
			alert('error::' + data.mensaje);
		});

	}

	/**
	 * funcion de inicializacion
	 */
	(function() {
		// cargar los cursos.

		cargarCursos();

	}());

});