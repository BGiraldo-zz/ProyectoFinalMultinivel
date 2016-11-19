app.controller("promoController", function($scope, $http, httpservice,
		$window, $sessionStorage,$location) {

	console.log('hola');
	
	
	$scope.listar= [];

	
	
	
	$scope.listarProd = function() {
		var xsrf = $.param({
			ced : $sessionStorage.objeto.cedula
			
		});
		
		$http({
			url : '../rest/representante/productos',
			method : "POST",
			data : xsrf,
			headers : {
				"Content-Type" : "application/x-www-form-urlencoded",
			   
			}
		}).success(function(data, status, headers, config) {
			if (data.codigo == '00') {
				
				$sessionStorage.productospromo = data.obj;
				
			} else {
				alert(data.mensaje);
			}
		}).error(function(data, status, headers, config) {
			alert('error::' + data.mensaje);
		});
	}
	
	$scope.cargarPromo = function(){
		for (var int = 0; int < $sessionStorage.productospromo.length; int++) {
			if ($sessionStorage.productospromo[int].promocion!=null) {
				
			
			if ($sessionStorage.productospromo[int].promocion.descuento!=0) {
				alert('1');
				$scope.listar.push($sessionStorage.productospromo[int])
			}
			}
		}
		
	}
	
	$scope.iniciar = function() {
		console.log('inicia');
		$scope.listarProd();
		$scope.cargarPromo();
	}
	$scope.iniciar()
	
	
		
		

	
	
});