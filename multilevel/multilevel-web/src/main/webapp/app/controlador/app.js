var app = angular.module("miApp", [ "ngRoute", "ngStorage" ]);

app.config(function($routeProvider) {
	$routeProvider.when("/", {
		controller : "modulo1Controller",
		controllerAs : "m1",
		templateUrl : "vistas/form.html"
	}).when("/cursos", {
		controller : "cursosController",
		controllerAs : "cur",
		templateUrl : "vistas/cursos.html"
	}).when("/Compras", {
		controller : "cursosController",
		controllerAs : "cur",
		templateUrl : "vistas/Compras.html"
	})
	.when("/Promociones", {
		controller : "cursosController",
		controllerAs : "cur",
		templateUrl : "vistas/Promociones.html"
	}).when("/Afiliado", {
		controller : "cursosController",
		controllerAs : "cur",
		templateUrl : "vistas/Afiliado.html"
	}).when("/Pedido", {
		controller : "cursosController",
		controllerAs : "cur",
		templateUrl : "vistas/Pedido.html"
	})
});
