/*angular.module('app')
    .directive('onlyDigits', function () {

      return {
        restrict: 'A',
        require: '?ngModel',
        link: function (scope, element, attrs, ngModel) {
          if (!ngModel) return;
          ngModel.$parsers.unshift(function (inputValue) {
            var digits = inputValue.split('').filter(function (s) {
              return (!isNaN(s) && s != ' ');
            }).join('');
            ngModel.$viewValue = digits;
            ngModel.$render();
            return digits;
          });
        }
      };
    });*/
angular.module("app")
    .factory('FeedService',['$http',function($http){
  return {
    parseFeed : function(url){
      return $http.jsonp('//ajax.googleapis.com/ajax/services/feed/load?v=1.0&num=50&callback=JSON_CALLBACK&q=' + encodeURIComponent(url));
    }
  }
}]);
