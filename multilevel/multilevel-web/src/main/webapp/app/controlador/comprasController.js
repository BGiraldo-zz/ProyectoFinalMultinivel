app.controller("comprasController", function($scope, $http, httpservice,
		$window, $sessionStorage,$location) {

	console.log('hola');
	
	$scope.productos = [];
	$scope.acomprar= [];

	
	
	
	$scope.listarPro = function() {
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
				$scope.productos = data.obj;
				$sessionStorage.productos = data.obj;
				
			} else {
				alert(data.mensaje);
			}
		}).error(function(data, status, headers, config) {
			alert('error::' + data.mensaje);
		});
	}
	
	$scope.comprar = function() {
		var pedido = $scope.acomprar
		//var xsrf = $.param({
			
		//	 pedidoo: pedido
			
	//	});
		
		var pedidodto = {
				pedido:$scope.acomprar,
				cedula: $sessionStorage.objeto.cedula
		};
		
		$http({
			url : '../rest/representante/pedidolist',
			method : "POST",
			data : pedidodto,
			headers : {
				"Content-Type" : "application/json",
			   
			}
		}).success(function(data, status, headers, config) {
			if (data.codigo == '00') {
				alert('Se realizo la compra correctamente');
				
			} else {
				alert(data.mensaje);
			}
		}).error(function(data, status, headers, config) {
			alert('error::' + data.mensaje);
		});
	}
	$scope.agregar = function (pro) {
		var exi = false;
		for (var int = 0; int < $scope.acomprar.length; int++) {
			if ($scope.acomprar[int].producto.id==pro.id) {
				$scope.acomprar[int].cantidad = $scope.acomprar[int].cantidad+1;
				$scope.acomprar[int].precio = $scope.acomprar[int].precio+pro.precioVenta;
				exi=true;
			}
		}
		if(!exi){
			$scope.acomprar.push({
				cantidad : 1,
				producto : pro,
				precio : pro.precioVenta
			});
			
		}
	}
	
	$scope.eliminar = function (pro) {
		var exi = false;
		var precio = 0;
			if (pro.cantidad!=1) {
				for (var int = 0; int < $scope.productos.length; int++) {
					console.log('etro');
					if ($scope.productos[int].id==pro.producto.id) {
						precio = $scope.productos[int].precioVenta;
						console.log(precio);
					}
				}
			
				pro.cantidad = pro.cantidad-1;
				pro.precio = pro.precio-precio;
				exi=true;
			}
		
		if (!exi) {
			alert('elimina completo');
			var pos = $scope.acomprar.indexOf(pro);
			$scope.acomprar.splice(pos,1);
		}
		
		
	}
	
	$scope.iniciar = function() {
		console.log('inicia');
		$scope.listarPro();
	}
	$scope.iniciar()
		
		
//		}
	
	
});