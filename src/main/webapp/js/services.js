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

    .service('Session', function () {
      this.create = function (sessionId, userId, userRole) {
        this.id = sessionId;
        this.userId = userId;
        this.userRole = userRole;
      };
      this.destroy = function () {
        this.id = null;
        this.userId = null;
        this.userRole = null;
      };
    })

    .factory('FeedService', ['$http', function ($http) {
      return {
        parseFeed: function (url) {
          return $http.jsonp('//ajax.googleapis.com/ajax/services/feed/load?v=1.0&num=50&callback=JSON_CALLBACK&q=' + encodeURIComponent(url));
        }
      }
    }])
    .factory('AuthService', function ($http, Session) {
      var authService = {};

      authService.login = function (credentials) {
        return $http
            .post('/login', credentials)
            .then(function (res) {
              Session.create(res.data.id, res.data.user.id,
                  res.data.user.role);
              return res.data.user;
            });
      };

      authService.isAuthenticated = function () {
        return !!Session.userId;
      };

      authService.isAuthorized = function (authorizedRoles) {
        if (!angular.isArray(authorizedRoles)) {
          authorizedRoles = [authorizedRoles];
        }
        return (authService.isAuthenticated() &&
        authorizedRoles.indexOf(Session.userRole) !== -1);
      };

      return authService;
    });
