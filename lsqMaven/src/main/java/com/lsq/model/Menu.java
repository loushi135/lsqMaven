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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
@Table(name="Menu")
@Entity
public class Menu extends BaseTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4888415625794311334L;
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@DocumentId
	private String menuId;
	@Column(name = "MENUNAME")
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.YES)
	private String menuName;
	@Column(name = "MENULEVEL")
	private String menuLevel;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PARENTID")
	private Menu parentMenu;
	@Column(name = "REMARK")
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.YES)
	private String remark;
	@Column(name = "MENUURL")
	private String menuUrl;
	@Column(name = "MENUORDER")
	private Integer menuOrder;
	@Column(name = "TYPE")
	private Integer type;
	@OneToMany(mappedBy="menu",targetEntity=RoleMenu.class,fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<RoleMenu> roleMenus = new HashSet<RoleMenu>(0);
	@OneToMany(mappedBy="parentMenu",targetEntity=Menu.class,fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	@OrderBy("menuOrder")
	@NotFound(action=NotFoundAction.IGNORE)
	private List<Menu> childList = new ArrayList<Menu>();
	public Menu(String menuId, String menuName, String menuLevel,
			Menu parentMenu, String remark, String menuUrl, Integer menuOrder,
			Integer type, Set<RoleMenu> roleMenus) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuLevel = menuLevel;
		this.parentMenu = parentMenu;
		this.remark = remark;
		this.menuUrl = menuUrl;
		this.menuOrder = menuOrder;
		this.type = type;
		this.roleMenus = roleMenus;
	}
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(String menuLevel) {
		this.menuLevel = menuLevel;
	}
	public Menu getParentMenu() {
		return parentMenu;
	}
	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public Integer getMenuOrder() {
		return menuOrder;
	}
	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Set getRoleMenus() {
		return roleMenus;
	}
	public void setRoleMenus(Set roleMenus) {
		this.roleMenus = roleMenus;
	}
	public List<Menu> getChildList() {
		return childList;
	}
	public void setChildList(List<Menu> childList) {
		this.childList = childList;
	}
	
	
}
