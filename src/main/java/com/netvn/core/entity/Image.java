package com.netvn.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.netvn.converter.JsonImageSerializer;
import com.netvn.core.abstracts.AbstractEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "image")
@JsonSerialize(using = JsonImageSerializer.class)
public class Image extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = -3589517223910805025L;

	@Column(name = "PATH", columnDefinition = "longtext")
	private String path;
	
	@Column(name = "TITLE")
	private String title;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}

