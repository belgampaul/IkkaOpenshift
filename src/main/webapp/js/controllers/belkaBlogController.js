/**
 * Created by ikka on 27.07.2015.
 */
angular.module("app")
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
      }]);

