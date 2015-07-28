/**
 * Created by ikka on 26.07.2015.
 */
angular.module("app", ["ui.bootstrap"])
    .controller("MyCntrl", ["$scope", function ($scope) {
      $scope.items = [
        'The first choice!',
        'And another choice for you.',
        'but wait! A third!'
      ];

      $scope.status = {
        isopen: false
      };

      $scope.toggled = function (open) {
        $log.log('Dropdown is now: ', open);
      };

      $scope.toggleDropdown = function ($event) {
        $event.preventDefault();
        $event.stopPropagation();
        $scope.status.isopen = !$scope.status.isopen;
      };

    }]);
