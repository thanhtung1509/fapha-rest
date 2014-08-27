package com.netvn.core.abstracts;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netvn.core.abstracts.EntityListener;

/**
 * 
 * @author thanhtung1509
 *
 */

@Inheritance(strategy = InheritanceType.JOINED)
@MappedSuperclass
@EntityListeners(value = EntityListener.class)
public abstract class AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "ID", unique = true, nullable = false, length = 36)
	private String id;

	@Column(name = "LAST_MODIFIED", updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	private Date lastModified;

	@Version
	@Column(name = "VERSION", updatable = true)
	private Long version;

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
