package com.lsq.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
@Table(name="Role")
@Entity
public class Role extends BaseTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5359551663102176627L;
	
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String roleId;
	@Column(name="ROLEDESC")
	private String roleDesc;
	@Column(name="ROLENAME")
	private String roleName;
	@Column(name="ROLESTATUS")
	private String roleStatus;
	@Column(name="ROLEREMARK")
	private String roleRemark;
	@OneToMany(mappedBy="role",targetEntity=RoleMenu.class,fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	//@JoinColumn(name="ROLEID",insertable=true,updatable=true)
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<RoleMenu> roleMenus = new HashSet<RoleMenu>(0);
	@OneToMany(mappedBy="role",targetEntity=Oper.class,fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private List<Oper> operList = new ArrayList<Oper>();
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Role(String roleId, String roleDesc, String roleName,
			String roleStatus, String roleRemark, Set<RoleMenu> roleMenus,
			List<Oper> operList) {
		super();
		this.roleId = roleId;
		this.roleDesc = roleDesc;
		this.roleName = roleName;
		this.roleStatus = roleStatus;
		this.roleRemark = roleRemark;
		this.roleMenus = roleMenus;
		this.operList = operList;
	}



	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleStatus() {
		return roleStatus;
	}
	public void setRoleStatus(String roleStatus) {
		this.roleStatus = roleStatus;
	}
	public String getRoleRemark() {
		return roleRemark;
	}
	public void setRoleRemark(String roleRemark) {
		this.roleRemark = roleRemark;
	}
	public Set<RoleMenu> getRoleMenus() {
		return roleMenus;
	}
	public void setRoleMenus(Set<RoleMenu> roleMenus) {
		this.roleMenus = roleMenus;
	}

	public List<Oper> getOperList() {
		return operList;
	}

	public void setOperList(List<Oper> operList) {
		this.operList = operList;
	}
	
	
}
