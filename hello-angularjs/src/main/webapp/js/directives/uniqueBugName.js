buggerApp.directive('uniqueBugName', function($q, $http, growl) {
  return {
    require: 'ngModel',
    link: function(scope, element, attrs, ngModel) {
    	ngModel.$asyncValidators.uniqueBugName = function(modelValue, viewValue) {

        if (ngModel.$isEmpty(modelValue)) {
          // consider empty model valid
          return $q.when();
        }

        var def = $q.defer();
        console.log("trying to find a bug with matching name", modelValue, viewValue);
        $http.post("/api/bugs/search", {name: modelValue}).success(function (data) {
        	console.log("search is over", data);
        	// if not the same bug: error
        	if (data.length > 0 && data[0].id != scope.currentBug.id) {
        		growl.error("Bug name is already in use", {title: 'ERROR'});
        		def.reject();
        	} else {
        		def.resolve();
        	}
        });

        return def.promise;
      };
    }
  };
});
