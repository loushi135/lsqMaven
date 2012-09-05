package com.lsq.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Table(name="baseSalary")
@Entity
public class BaseSalary extends BaseTO {
	
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	@Column(name = "baseSalary")
	private Float baseSalary;
	@Column(name = "positionSalary")
	private Float positionSalary;
	@Column(name = "ageSalary")
	private Float ageSalary;
	@Column(name = "liveSalary")
	private Float liveSalary;
	@Column(name = "houseSalary")
	private Float houseSalary;
	@Column(name = "transportSalary")
	private Float transportSalary;
	@Column(name = "social")
	private Float social;
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.PERSIST)
	@JoinColumn(name = "empId")
	private Employee employee;
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.PERSIST)
	@JoinColumn(name = "operId")
	@NotFound(action=NotFoundAction.IGNORE)
	private Oper oper;
	private Integer status;
	public BaseSalary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BaseSalary(String id, Float baseSalary, Float positionSalary,
			Float ageSalary, Float liveSalary, Float houseSalary,
			Float transportSalary, Float social, Employee employee, Oper oper) {
		super();
		this.id = id;
		this.baseSalary = baseSalary;
		this.positionSalary = positionSalary;
		this.ageSalary = ageSalary;
		this.liveSalary = liveSalary;
		this.houseSalary = houseSalary;
		this.transportSalary = transportSalary;
		this.social = social;
		this.employee = employee;
		this.oper = oper;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Float getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(Float baseSalary) {
		this.baseSalary = baseSalary;
	}
	public Float getPositionSalary() {
		return positionSalary;
	}
	public void setPositionSalary(Float positionSalary) {
		this.positionSalary = positionSalary;
	}
	public Float getAgeSalary() {
		return ageSalary;
	}
	public void setAgeSalary(Float ageSalary) {
		this.ageSalary = ageSalary;
	}
	public Float getLiveSalary() {
		return liveSalary;
	}
	public void setLiveSalary(Float liveSalary) {
		this.liveSalary = liveSalary;
	}
	public Float getHouseSalary() {
		return houseSalary;
	}
	public void setHouseSalary(Float houseSalary) {
		this.houseSalary = houseSalary;
	}
	public Float getTransportSalary() {
		return transportSalary;
	}
	public void setTransportSalary(Float transportSalary) {
		this.transportSalary = transportSalary;
	}
	public Float getSocial() {
		return social;
	}
	public void setSocial(Float social) {
		this.social = social;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Oper getOper() {
		return oper;
	}
	public void setOper(Oper oper) {
		this.oper = oper;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
