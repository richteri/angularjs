buggerApp.controller("mainCtrl", function ($scope, growl, BugResource, $filter) {
	// Init current bug
	$scope.currentBug = new BugResource();
	
	// Querying all bugs
	$scope.listBugs = function () {
		$scope.bugs = BugResource.query();
	}
	
	// Reloading bug list from server
	$scope.refresh = function () {
		// update list view
		$scope.listBugs();
		
		// update detail view
		if (angular.isDefined($scope.currentBug.id)) {
			BugResource.get({id: $scope.currentBug.id}, function (bug) {
				$scope.currentBug = bug;
			});
		}
	}
	
	// Delete bug
	$scope.deleteBug = function (bug) {
		bug.$delete(function () {
			$scope.bugs.splice($scope.bugs.indexOf(bug), 1);
			growl.success("Bug was deleted");
		});
	}
	
	// Insert new bug
	$scope.createBug = function () {
		$scope.currentBug.$save(function () {
			$scope.bugs.push($scope.currentBug);
			$scope.resetDetails();
			growl.success("Bug saved");
		}, function (err) {
			console.log(err);
			growl.error("Bug name is already in use", {title: 'ERROR'});
		});
	}
	
	// Update bug
	$scope.updateBug = function () {
		$scope.currentBug.$update(function () {
			$scope.resetDetails();
			growl.success("Bug was updated");
		}, function (err) {
			console.log(err);
			growl.error("Bug name is already in use", {title: 'ERROR'});
		});
	}
	
	
	// UpSert bug
	$scope.saveBug = function () {
		if ($scope.currentBug.id) {
			$scope.updateBug();
		} else {
			$scope.createBug();
		}
	}
	
	
	$scope.resetDetails = function () {
		$scope.currentBug = new BugResource();
		/*
		$scope.bugForm.$setPristine();
		$scope.bugForm.$setUntouched();
		*/
		/*
		$scope.bugForm.name.$setPristine();
		$scope.bugForm.name.$setUntouched();
		$scope.bugForm.summary.$setPristine();
		$scope.bugForm.summary.$setUntouched();
		*/
	}
	
	// Selecting bug for editing
	$scope.editBug = function (bug) {
		$scope.currentBug = bug;
	}

	// Call the listing query
	$scope.listBugs();
})