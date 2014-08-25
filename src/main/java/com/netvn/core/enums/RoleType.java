package com.netvn.core.enums;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RoleType {
	SUPER_ADMIN("ROLE_SUPER_ADMIN"), 
	ADMIN("ROLE_ADMIN"), 
	USER("ROLE_USER");

	private String type;
	private int id;

	RoleType(String initType) {
		this.type = initType;
		this.id = ordinal();
	}

	public static RoleType getById(Integer _id) {
		for (RoleType e : values()) {
			if (e.getId() == _id)
				return e;
		}
		return null;
	}
	
	public static RoleType[] getVisibleRoles(RoleType role) {
		List<RoleType> results = new ArrayList<RoleType>();
		int ordinal = role.ordinal();
		for (RoleType r : values()) {
			if (r.ordinal() > ordinal && r.ordinal() < USER.ordinal()) {
				results.add(r);
			}
		}
		return results.toArray(new RoleType[results.size()]);
	}

	public String getType() {
		return type;
	}

	public int getId() {
		return id;
	}
}
