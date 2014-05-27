package com.github.walterfan.gtd.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;





/**
 * @author walter
 *
 */
public class Role extends BaseObject {
    
	private int roleID;
	private String roleName;
	private String description;
	private int parentRoleID = 0;
	
	public int getParentRoleID() {
		return parentRoleID;
	}

	public void setParentRoleID(int parentRoleID) {
		this.parentRoleID = parentRoleID;
	}

	public Role() {
		
	}
	
	public Role(int roleID, String roleName) {
		this.roleID = roleID;
		this.roleName = roleName;
	}
	
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	
	
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

    
    
    
    public boolean isSuperAdmin() {
    	return "SuperAdmin".equalsIgnoreCase(this.roleName);
    }
    


    
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
   
	@Override
	public String toString() {
		return "Role [description=" + description + ", moduleList="
				+ ", parentRoleID=" + parentRoleID + ", roleID="
				+ roleID + ", roleName=" + roleName + "]";
	}
    
    
}
