package bugger.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bugger.model.Bug;

/**
 * CRUD repository of bugs with criteria support.
 * @author richteri
 *
 */
@Repository
public interface BugRepository extends CrudRepository<Bug, Long>, JpaSpecificationExecutor<Bug> {

	/**
	 * Find bugs by name (without manual specification)
	 * @param name full or partial name of the bug
	 * @return List of bugs matching the (partial) name
	 */
	Bug findByName(String name);

}
