package com.lsq.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * Oper entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Table(name="Oper")
@Entity
public class Oper extends BaseTO implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLEID")
	private Role role;
	@Column(name = "NAME")
	private String name;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "TEL")
	private String tel;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "LOGINNAME")
	private String loginname;
	@Column(name = "IDNO")
	private String idno;
	@Column(name = "POSTCODE")
	private String postcode;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "REMARK")
	private String remark;
	@Column(name="CREATEDATE")
	private Timestamp createDate;
	@Column(name="LASTOPDATE")
	private Timestamp lastOpDate;
	@Column(name = "STATUS")
	private Integer status;//0 锁定，1正常 ，2已注销
	@OneToMany(mappedBy = "oper", targetEntity = Operlog.class, fetch = FetchType.LAZY)
	@OrderBy("opertime desc")
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<Operlog> operlogs = new HashSet<Operlog>(0);

	// Constructors

	/** default constructor */
	public Oper() {
	}

	public Oper(String id, Role role, String name, String email, String tel,
			String password, String loginname, String idno, String postcode,
			String address, String remark, Timestamp createDate,
			Timestamp lastOpDate, Integer status, Set<Operlog> operlogs) {
		super();
		this.id = id;
		this.role = role;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.password = password;
		this.loginname = loginname;
		this.idno = idno;
		this.postcode = postcode;
		this.address = address;
		this.remark = remark;
		this.createDate = createDate;
		this.lastOpDate = lastOpDate;
		this.status = status;
		this.operlogs = operlogs;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getLastOpDate() {
		return lastOpDate;
	}

	public void setLastOpDate(Timestamp lastOpDate) {
		this.lastOpDate = lastOpDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set<Operlog> getOperlogs() {
		return operlogs;
	}

	public void setOperlogs(Set<Operlog> operlogs) {
		this.operlogs = operlogs;
	}

	
}