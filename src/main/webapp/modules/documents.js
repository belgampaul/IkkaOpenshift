/**
 * Created by ikka on 07.08.2015.
 */
angular.module("documents", ["ui.router"])
    .config(function ($stateProvider, $urlRouterProvider) {
      //
      // For any unmatched url, redirect to /state1
      $urlRouterProvider
          .when('', '/document')
          .otherwise("/document");
      //
      // Now set up the states
      $stateProvider
          .state('document.line', {
            url: "/{lineId:[0-9]{1,4}}",
            controller: function ($stateParams, $state, $scope) {
              $scope.lineId = $stateParams.lineId;
              $scope.scope = $state;

              $scope.doc.docId = new Date().getTime();
              //$stateParams.itemId //*** Exists! ***//
            },
            templateUrl: 'views/documents/line.html'
            //views: {
            //  "@": { //targeted view. @ puts child template at the place of its parent? i.e. hides it.
            //
            //  }
            //}
            ////templateProvider: function ($stateParams) { return "<div class='panel panel-danger'>" + $stateParams.lineId  + "</div>"}
          })
          .state('document', {
            url: "/document",
            controller: function ($stateParams, $state, $scope) {
              $scope.doc = {};
              $scope.$state = $state;
              $scope.doc.docId = new Date().getTime();
              $scope.testTexObj = {msg: "test"};

              //$stateParams.itemId //*** Exists! ***//
            },
            templateUrl: "views/documents/document.html"
          })

    });

