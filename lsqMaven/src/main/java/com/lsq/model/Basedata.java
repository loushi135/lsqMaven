package com.lsq.model;

import java.util.ArrayList;
import java.util.List;

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


@Table(name="BaseData")
@Entity
public class Basedata extends BaseTO implements
		java.io.Serializable {

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
	@JoinColumn(name = "PARENTID")
	private Basedata parentBaseData;
	@Column(name="NAME")
	private String name;
	@Column(name="CODE")
	private String code;
	@Column(name="REMARK")
	private String remark;
	@Column(name="STATUS")
	private Integer status;
	@Column(name="TYPE")
	private Integer type;  // 1表示合作部门,2为个人信息
	@Column(name="ORDERINFO")
	private Integer orderInfo;
	@OneToMany(mappedBy="parentBaseData",targetEntity=Basedata.class,fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	@OrderBy("orderInfo")
	@NotFound(action=NotFoundAction.IGNORE)
	private List<Basedata> childList = new ArrayList<Basedata>();
	public Basedata() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Basedata(String id, Basedata parentBaseData, String name,
			String code, String remark, Integer status, Integer type,
			Integer orderInfo, List<Basedata> childList) {
		super();
		this.id = id;
		this.parentBaseData = parentBaseData;
		this.name = name;
		this.code = code;
		this.remark = remark;
		this.status = status;
		this.type = type;
		this.orderInfo = orderInfo;
		this.childList = childList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Basedata getParentBaseData() {
		return parentBaseData;
	}
	public void setParentBaseData(Basedata parentBaseData) {
		this.parentBaseData = parentBaseData;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(Integer orderInfo) {
		this.orderInfo = orderInfo;
	}
	public List<Basedata> getChildList() {
		return childList;
	}
	public void setChildList(List<Basedata> childList) {
		this.childList = childList;
	}
	
}