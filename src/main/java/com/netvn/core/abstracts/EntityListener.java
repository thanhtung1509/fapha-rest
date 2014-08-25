package com.netvn.core.abstracts;

import java.util.Date;

import javax.persistence.PrePersist;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 * 
 * @author thanhtung1509
 *
 */
public class EntityListener {
	//private static final Logger logger = LoggerFactory.getLogger(EntityListener.class);

	@PrePersist
	protected void onCreate(AbstractEntity entity) {
		entity.setLastModified(new Date());
	}
}
