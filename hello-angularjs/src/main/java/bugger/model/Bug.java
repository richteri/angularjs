package bugger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Represents an issue in the bug tracking system
 * @author richteri
 *
 */
@Entity
public class Bug extends AbstractTimestampEntity {

	/**
	 * Internal ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/**
	 * Unique, human-readable identifier
	 */
	@NotNull
	@Column(unique=true)
	private String name;
	
	/**
	 * Short description of the bug
	 */
	@NotNull
	@Column(length=200)
	private String summary;
	
	/**
	 * Full description of the bug
	 */
	private String description;
	
	/**
	 * Bug severity (MINOR, MAJOR, CRITICAL)
	 */
	private SeverityEnum severity;
	
	/**
	 * Current status (OPEN, IN_PROGRESS, CLOSED)
	 */
	private StatusEnum status;
	
	/**
	 * Verison(s) affected by this bug
	 */
	private String affectedVer;
	
	/**
	 * Version in which the bug was fixed
	 */
	private String fixVer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SeverityEnum getSeverity() {
		return severity;
	}

	public void setSeverity(SeverityEnum severity) {
		this.severity = severity;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public String getAffectedVer() {
		return affectedVer;
	}

	public void setAffectedVer(String affectedVer) {
		this.affectedVer = affectedVer;
	}

	public String getFixVer() {
		return fixVer;
	}

	public void setFixVer(String fixVer) {
		this.fixVer = fixVer;
	}	
	
}
