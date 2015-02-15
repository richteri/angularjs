package bugger.model.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import bugger.model.Bug;

/**
 * Build search criteria for bugs manually
 * @author richteri
 *
 */
public class BugSpecification implements Specification<Bug> {
	
	/**
	 * Use bug model for simplicity
	 */
	private final Bug criteria;
	
	public BugSpecification(Bug criteria) {
		this.criteria = criteria;
	}

	@Override
	public Predicate toPredicate(Root<Bug> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		// TODO Handle complex searches
		
		// dealing with searches by name
		if (criteria.getName() !=null && !criteria.getName().trim().isEmpty()) {
			Expression<String> path = builder.lower(root.<String> get("name"));
			String expression = criteria.getName().toLowerCase();
			if (criteria.getName().contains("%")) {
				// Joker found
				return builder.like(path, expression);
			} else {
				// strict search
				return builder.equal(path, expression);
			}
		}
		return null;
	}

}
