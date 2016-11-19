app.controller("reporController", function($scope, httpservice,
		$window, $sessionStorage) {

	$scope.abrirReporte = function() {
		$window.location.href = "../reporte";
	}
	
});