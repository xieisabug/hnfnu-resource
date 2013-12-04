package com.hnfnu.zyw.dto.system.pk;

import java.io.Serializable;

public class UserRolePK implements Serializable{
	private static final long serialVersionUID = -1961761080753827851L;
	private Integer userId;
	private Integer roleId;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	
	  @Override
	    public boolean equals(Object obj) {
	        if (obj instanceof UserRolePK) {
	        	UserRolePK userRole = (UserRolePK) obj;
	            if (this.userId == userRole.userId && this.roleId == userRole.roleId)
	                return true;
	        }
	        return false;
	    }

	    @Override
	    public int hashCode() {
	        return this.roleId.hashCode();
	    }
}
