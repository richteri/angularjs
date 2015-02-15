buggerApp.factory('BugResource', function ($resource) {
	return $resource('/api/bugs/:id', { id: '@id' }, {
	    update: {method: 'PUT'}
	});
});
