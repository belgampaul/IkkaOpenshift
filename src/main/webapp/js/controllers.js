angular.module("app"/*, ['ngAnimate']*/)

    .controller("ExchangeRatesViewController", ["$scope", "$http", function ($scope, $http) {
      $scope.controllerName = "ExchangeRatesViewController";
      $scope.data = {};

      $http.get("https://query.yahooapis.com/v1/public/yql?q=select+*+from+yahoo.finance.xchange+where+pair+=+%22USDRUB,EURRUB%22&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
          .success(function (data, status, headers, config) {
            // this callback will be called asynchronously
            // when the response is available
            console.log(data);
            $scope.data = data;
          })
          .error(function (data, status, headers, config) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
          });


    }])


    .controller("FirebaseViewController", ["$scope", "$http", 'FeedService', "$sce",
      function ($scope, $http, feedService, $sce) {
        $scope.controllerName = "FirebaseViewController";
        var myDataRef = new Firebase('https://glaring-inferno-5251.firebaseio.com');
        $scope.bool = false;

        $scope.table = "entries";


        $scope.insertNewRecord = function (tableName) {
          $scope.entries.forEach(function (el) {
            var title = el.title;
            myDataRef.child(tableName).push(el);
          });
        };

        $scope.feedUrl = "http://ecureuil-86.livejournal.com/data/rss";
        $scope.feedObject = null;
        $scope.entries = [];
        $scope.entry = null;

        $scope.fetchFeedObject = function (url) {
          feedService.parseFeed(url).then(
              function (result) { //success
                $scope.feedObject = result;
                $scope.entries = result.data.responseData.feed.entries;
                $scope.entries.forEach(function (entry) {
                });
                $scope.tmp = null;
              }
          );
        };

        $scope.fetchFeedObject($scope.feedUrl);
      }])

    .controller("BelkaBlogController", ["$scope", "$http", 'FeedService', "$sce",
      function ($scope, $http, feedService, $sce) {
        $scope.controllerName = "BelkaBlogController";

        $scope.feedUrl = "http://ecureuil-86.livejournal.com/data/rss";
        $scope.feedObject = null;
        $scope.entries = [];
        $scope.entry = null;

        $scope.fetchFeedObject = function (url) {
          feedService.parseFeed(url).then(
              function (result) { //success
                $scope.feedObject = result;
                $scope.entries = result.data.responseData.feed.entries;
                $scope.entries.forEach(function (entry) {
                  entry.contentAsHtml = $sce.trustAsHtml(entry.content);
                });
                $scope.tmp = null;
              }
          );
        };

        $scope.fetchFeedObject($scope.feedUrl);

        $scope.showEntry = function (entry) {
          $scope.entry = entry;
        };

        $scope.hideEntry = function () {
          $scope.entry = null;
        }
      }])


    .controller("Base64DecoderController", ["$scope", function ($scope) {
    }])

    .controller("Base64DecoderViewController", ["$scope", function ($scope) {
    }])


    .controller("Base64EncoderController", ["$scope", function ($scope) {
      $scope.controllerName = "Base64EncoderController";
    }])

    .controller("BowerJsonViewController", ["$scope", "$http", function ($scope, $http) {
      $scope.controllerName = "BowerJsonViewController";

      $scope.bowerJsonInstance = {};

      //$http.get('assets/libs/angular-bootstrap/bower.json')
      $http.get('http://cors.io/?u=https://www.dropbox.com/s/v9pg1cnf3yph7i2/currencies.json?dl=1')
          .success(function (data, status, headers, config) {
            $scope.bowerJsonInstance = data;
          }).
          error(function (data, status, headers, config) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
          });


    }])


    .controller("NavigationController", ["$scope", function ($scope) {
      var pages = ['base64Decoder',
        'base64Encoder',
        'alert',
        'bowerJsonView',
        'exchangeRatesView',
        'belkaBlog',
        'firebaseView'
      ];

      var examples = [
        'firebaseView',
        'base64DecoderView'
      ];

      $scope.pages = [];
      $scope.examples = [];
      $scope.debug = { on: false};

      //$scope.radio = {model :  undefined};
      //$scope.radioModelButtons = ["a", "b", "c"];


      angular.forEach(pages,
          function (pageName) {
            $scope.pages.push({name: pageName, url: 'views/' + pageName + '.html'});
          });

      angular.forEach(examples,
          function (pageName) {
            $scope.examples.push({name: pageName, url: 'views/' + pageName + '.html'});
          });

      $scope.page = $scope.pages[$scope.pages.length - 1];
      //$scope.radioModel  = $scope.page.name;


      $scope.pageChosen = function (url) {
        console.log("pageChosen");
        $scope.pages.forEach(function f(p) {
          if (p.url == url) {
            $scope.page = p;
          }
        });

        $scope.examples.forEach(function f(p) {
          if (p.url == url) {
            $scope.page = p;
          }
        });
      };

    }]);

