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
	$scope.agregar = function (pro) {
		var exi = false;
		for (var int = 0; int < $scope.acomprar.length; int++) {
			if ($scope.acomprar[int].id==pro) {
				exi=true;
			}
		}
		if(exi){
			alert('no se puede agregar otra vez')
		}else{
			$scope.acomprar.push(pro);
		}
	}
	
	$scope.eliminar = function (dato) {
		var pos = $scope.acomprar.indexOf(dato);
		$scope.acomprar.splice(pos,1);
	}
	
	$scope.iniciar = function() {
		console.log('inicia');
		$scope.listarPro();
	}
	$scope.iniciar()
		
		
//		}
	
	
});