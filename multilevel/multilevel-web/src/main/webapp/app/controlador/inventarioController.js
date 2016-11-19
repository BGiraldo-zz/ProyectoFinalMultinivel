app.controller("inventarioController", function($scope, $http, httpservice,
		$window, $sessionStorage,$location) {
//	 var res = filtrod($window,$location);
//		if (res == true) {
	alert('hola');
	
	$scope.listaProductos = [];
	
	
	$scope.listarInventario = function() {
		var xsrf = $.param({
			ced : $sessionStorage.objeto.cedula
			
		});
		
		$http({
			url : '../rest/representante/inventario',
			method : "POST",
			data : xsrf,
			headers : {
				"Content-Type" : "application/x-www-form-urlencoded",
			   
			}
		}).success(function(data, status, headers, config) {
			if (data.codigo == '00') {
				$scope.listaProductos = data.obj;
				$sessionStorage.objt = data.obj;
				
			} else {
				alert(data.mensaje);
			}
		}).error(function(data, status, headers, config) {
			alert('error::' + data.mensaje);
		});
	}
	
	$scope.editarpro = function(a,b) {
		var xsrf = $.param({
			re : $sessionStorage.objeto.cedula,
			idpro :a,
			precio:b
		});
		
		$http({
			url : '../rest/representante/editarprecio',
			method : "POST",
			data : xsrf,
			headers : {
				"Content-Type" : "application/x-www-form-urlencoded",
			   
			}
		}).success(function(data, status, headers, config) {
			if (data.codigo == '00') {
				alert('se edito con exito el precio');
				
			} else {
				alert(data.mensaje);
			}
		}).error(function(data, status, headers, config) {
			alert('error::' + data.mensaje);
		});
	}
	
	$scope.buscar=function(a) {
		var encontro = false;
		for (var int = 0; int < $scope.listaProductos.length; int++) {
			console.log($scope.listaProductos[int].producto.id);
			if($scope.listaProductos[int].producto.id==a){
				encontro=true;
				$scope.formData.precio = $sessionStorage.objt[int].precioBase;
			}
		}
		if (encontro==false) {
			alert('no existe un producto con ese id en este inventario');
		}
		
	}
	
	$scope.editar=function(a,b) {
		var encontro = false;
		var proaedit = null;
		for (var int = 0; int < $scope.listaProductos.length; int++) {
			console.log($scope.listaProductos[int].producto.id);
			if($scope.listaProductos[int].producto.id==a){
				encontro=true;
				
			}
		}
		
		if (encontro==false) {
			alert('no existe un producto con ese id en este inventario');
		}
		if(encontro==true){
			
			
			if (b<=0) {
				alert('no se puede colocar 0 en el precio')
			}else{
				$scope.editarpro(a,b);
			}
		}
		
	}
	$scope.iniciar = function() {
		alert('inicia');
		$scope.listarInventario();
	}
	$scope.iniciar()
		
		
//		}
});