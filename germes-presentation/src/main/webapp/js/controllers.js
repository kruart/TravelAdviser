app.controller('CityCtrl', ['$scope', function ($scope) {
    $scope.cities = [{
        'name': 'Odessa',
        'distinct': '',
        'region': 'Odesssa'
    },{
        'name' : 'Izmail',
        'district' : 'Izmail',
        'region' : 'Odessa'
    }]
}]);