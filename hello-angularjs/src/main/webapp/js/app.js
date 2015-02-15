'use strict';

var buggerApp = angular.module("buggerApp", [
	"ngResource",
	"angular-growl"
]).
config(['growlProvider', function(growlProvider) {
  growlProvider.onlyUniqueMessages(false);
  growlProvider.globalTimeToLive(3000);
}]);
