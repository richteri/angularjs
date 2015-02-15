package bugger.model;

/**
 * Severity of the bug:
 * <ul>
 * <li>
 * MINOR: does not affect the usability
 * </li>
 * <li>
 * MAJOR: affect the usability / data integrity
 * </li>
 * <li>
 * CRITICAl: results in the termination of the system/component or results in the termination
 * </li>
 * </ul>
 * @author richteri
 *
 */
public enum SeverityEnum {
	MINOR, MAJOR, CRITICAL;
}
