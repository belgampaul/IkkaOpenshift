/**
 * Created by ikka on 07.08.2015.
 */
angular.module("surveys", ["ui.router"])
    .config(function ($stateProvider, $urlRouterProvider) {
      //
      // For any unmatched url, redirect to /state1
      $urlRouterProvider
          .when('', '/surveys')
          .otherwise("/surveys");
      //
      // Now set up the states
      $stateProvider
          .state('surveys.survey.question', {
            url: "/{questionId:[0-9]{1,4}}",
            controller: function ($stateParams, $state, $scope) {
              $scope.questionId = $stateParams.questionId;
              $scope.scope = $state;
            },
            templateUrl: 'views/surveys/question.html'
          })
          .state('surveys.survey', {
            url: "/{surveyId:[0-9]{1,4}}",
            controller: function ($stateParams, $state, $scope) {
              $scope.questionId = $stateParams.questionId;
              $scope.scope = $state;
            },
            templateUrl: 'views/surveys/survey.html'
          })
          .state('surveys', {
            url: "/surveys",
            controller: function ($stateParams, $state, $scope) {
              $scope.surveys = [];
              $scope.$state = $state;
            },
            templateUrl: "views/surveys/surveys.html"
          })

    });

