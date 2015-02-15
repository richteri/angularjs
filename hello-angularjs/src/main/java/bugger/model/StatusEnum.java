package bugger.model;

/**
 * Bug statuses:
 * <ul>
 * <li>
 * OPEN: new entry, yet to be assigned to a team member
 * </li>
 * <li>
 * IN_PROGRESS: work has already begun
 * </li>
 * <li>
 * CLOSED: fixed, tested, SCM introduced, reviewed, accepted
 * </li>
 * </ul>
 * @author richteri
 *
 */
public enum StatusEnum {
	OPEN, IN_PROGRESS, CLOSED
}
