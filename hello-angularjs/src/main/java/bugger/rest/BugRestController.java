package bugger.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bugger.model.Bug;
import bugger.model.specification.BugSpecification;
import bugger.repository.BugRepository;

/**
 * Minimal REST controller for CRUD operations on bugs
 * @author richter
 *
 */
@RestController
@RequestMapping("/api/bugs")
public class BugRestController {

	@Autowired
	private BugRepository repository;
	
	/**
	 * List all bugs
	 * @return all bugs
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Bug> findAll() {
		return repository.findAll();
	}
	
	/**
	 * Get one bug
	 * @param id the id to match
	 * @return bug with the specified id
	 */
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Bug findOne(@PathVariable Long id) {
		return repository.findOne(id);
	}

	/**
	 * Find bug by filter
	 * @param filter the filter to match
	 * @return bug with a matching properties
	 */
	@RequestMapping(method = RequestMethod.POST, value="/search")
	public Iterable<Bug> search(@RequestBody Bug criteria) {
		BugSpecification spec = new BugSpecification(criteria);
		return repository.findAll(spec);
	}
	
	/**
	 * Insert a new bug
	 * @param bug the bug to insert
	 * @return Bug inserted
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Bug create(@RequestBody Bug bug) {
		return repository.save(bug);
	}

	/**
	 * Update the bug
	 * @param id the id of the bug to update
	 * @param bug the updated bug
	 * @return the updated bug
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Bug update(@PathVariable Long id, @RequestBody Bug bug) {
		return repository.save(bug);
	}
	
	/**
	 * Delete the bug with the specified ID
	 * @param id the id to match
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable Long id) {
		repository.delete(id);
	}

	/**
	 * Error handler for data integrity violations
	 * eg. violating unique constraints 
	 * @author richteri
	 *
	 */
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(HttpStatus.CONFLICT)  // status code 409
	public void handleConflict() {
		// Nothing to do
	}
}
