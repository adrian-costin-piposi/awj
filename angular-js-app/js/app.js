var app = angular.module('blog', [ ]);

app.controller('HomeController', ['$scope', '$http', function($scope, $http) {
    $scope.helloWorld = 'Aplicatii Web cu suport Java!';
  
  var url = "http://localhost:8080/persoana";
   $scope.persoane = [];
   $scope.keys = [];
    $scope.obj={};
   $scope.person = {};
   $scope.editPerson = {};
 
 
 
   $http.get('http://localhost:8080/persoana').then(
     function successCallback(response) {
        $scope.obj=response;
     $scope.persoane = $scope.obj.data;
     $scope.keys = Object.keys(response.data[0]);
   });
 
 
   $scope.addPersoana = function(persoana) {
        persoana.id = parseInt(persoana.id);
        console.log(persoana.id);
        $http({
            method: 'POST',
            url: url,
            data: persoana
        }).then(function successCallback(response) {
            console.log(response);
            $scope.persoane.push(persoana);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deletePersoana = function(id) {
		angular.element('[data-id=' + id + ']').remove();
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.persoane = $scope.persoane.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };

    $scope.setUpdatePerson = function(person) {
        $scope.editPerson = person;
    };


    $scope.updatePerson = function () {
        $http({
            method: "PUT",
            url: 'http://localhost:8080/persoana' + '/' + $scope.editPerson.id + '/' + $scope.editPerson.name
        }).then(function successCallback(response) {
        }, function errorCallback(response) {
        });
    };
  }]);

app.controller('MasinaController', ['$scope', '$http', function($scope, $http) {
    $scope.helloWorld = 'Aplicatii Web cu suport Java!';
  
  var url = "http://localhost:8080/masina";
   $scope.masini = [];
   $scope.keys = [];
    $scope.obj={};
   $scope.masina = {};
   $scope.editMasina = {};
 
 
 
   $http.get('http://localhost:8080/masina').then(
     function successCallback(response) {
        $scope.obj=response;
     $scope.masini = $scope.obj.data;
     $scope.keys = Object.keys(response.data[0]);
   });
 
 
   $scope.addMasina = function(masina) {
        masina.id = parseInt(masina.id);
        console.log(masina.id);
        $http({
            method: 'POST',
            url: url,
            data: masina
        }).then(function successCallback(response) {
            console.log(response);
            $scope.masini.push(masina);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteMasina = function(id) {
		angular.element('[data-id=' + id + ']').remove();
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.masini = $scope.masini.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };

    $scope.setUpdateMasina = function(masina) {
        $scope.editMasina = masina;
    };


    $scope.updateMasina = function () {
        $http({
            method: "PUT",
            url: 'http://localhost:8080/masina' + '/' + $scope.editMasina.id + '/' + $scope.editMasina.name
        }).then(function successCallback(response) {
        }, function errorCallback(response) {
        });
    };
  }]);


app.controller('AnimalController', ['$scope', '$http', function($scope, $http) {
    $scope.helloWorld = 'Aplicatii Web cu suport Java!';
  
  var url = "http://localhost:8080/animal";
   $scope.animale = [];
   $scope.keys = [];
    $scope.obj={};
   $scope.animal = {};
   $scope.editAnimal = {};
 
 
 
   $http.get('http://localhost:8080/animal').then(
     function successCallback(response) {
        $scope.obj=response;
     $scope.animale = $scope.obj.data;
     $scope.keys = Object.keys(response.data[0]);
   });
 
 
   $scope.addAnimal = function(animal) {
        animal.id = parseInt(animal.id);
        console.log(animal.id);
        $http({
            method: 'POST',
            url: url,
            data: animal
        }).then(function successCallback(response) {
            console.log(response);
            $scope.animale.push(animal);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteAnimal = function(id) {
		angular.element('[data-id=' + id + ']').remove();
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.animale = $scope.animale.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };

    $scope.setUpdateAnimal = function(animal) {
        $scope.editAnimal = animal;
    };


    $scope.updateAnimal = function () {
        $http({
            method: "PUT",
            url: 'http://localhost:8080/animal' + '/' + $scope.editAnimal.id + '/' + $scope.editAnimal.name
        }).then(function successCallback(response) {
        }, function errorCallback(response) {
        });
    };
  }]);


app.controller('ProdusController', ['$scope', '$http', function($scope, $http) {
    $scope.helloWorld = 'Aplicatii Web cu suport Java!';
  
  var url = "http://localhost:8080/produs";
   $scope.produse = [];
   $scope.keys = [];
    $scope.obj={};
   $scope.produs = {};
   $scope.editDrink = {};
 
 
 
   $http.get('http://localhost:8080/produs').then(
     function successCallback(response) {
        $scope.obj=response;
     $scope.produse = $scope.obj.data;
     $scope.keys = Object.keys(response.data[0]);
   });
 
 
   $scope.addDrink = function(produs) {
        produs.id = parseInt(produs.id);
        console.log(produs.id);
        $http({
            method: 'POST',
            url: url,
            data: produs
        }).then(function successCallback(response) {
            console.log(response);
            $scope.produse.push(produs);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteDrink = function(id) {
		angular.element('[data-id=' + id + ']').remove();
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.produse = $scope.produse.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };

    $scope.setUpdateProdus = function(produs) {
        $scope.editProdus = produs;
    };


 $scope.updateProdus = function () {
        $http({
            method: "PUT",
            url: 'http://localhost:8080/produs' + '/' + $scope.editProdus.id + '/' + $scope.editProdus.name
        }).then(function successCallback(response) {
        }, function errorCallback(response) {
        });
    };
  }]);