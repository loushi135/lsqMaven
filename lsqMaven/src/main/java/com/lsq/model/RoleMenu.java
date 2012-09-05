package com.lsq.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Table(name="RoleMenu")
@Entity
//@Cacheable
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class RoleMenu extends BaseTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3437405179378096849L;
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	@ManyToOne
	@JoinColumn(name = "MENUID")
	private Menu menu;
	@ManyToOne
	@JoinColumn(name = "ROLEID")
	private Role role;

	public RoleMenu(String id, Menu menu, Role role) {
		super();
		this.id = id;
		this.menu = menu;
		this.role = role;
	}

	public RoleMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
