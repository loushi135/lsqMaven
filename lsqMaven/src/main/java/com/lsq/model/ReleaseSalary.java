package com.lsq.model;

import java.util.Date;

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
@Table(name="releaseSalary")
@Entity
public class ReleaseSalary extends BaseTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8136464145762640953L;
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	@Column(name = "releaseSalary")
	private Float releaseSalary;
	@Column(name = "totalSalary")
	private Float totalSalary;
	@Column(name = "tax")
	private Float tax;
	@Column(name = "reward")
	private Float reward;
	@Column(name = "punish")
	private Float punish;
	@Column(name = "punishReason")
	private String punishReason;
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.PERSIST)
	@JoinColumn(name = "empId")
	private Employee employee;
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.PERSIST)
	@JoinColumn(name = "operId")
	@NotFound(action=NotFoundAction.IGNORE)
	private Oper oper;
	private Date beginDate;
	private Date endDate;
	public ReleaseSalary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReleaseSalary(String id, Float releaseSalary, Float totalSalary,
			Float tax,  Float reward, Float punish,
			String punishReason, Employee employee, Oper oper, Date beginDate,
			Date endDate) {
		super();
		this.id = id;
		this.releaseSalary = releaseSalary;
		this.totalSalary = totalSalary;
		this.tax = tax;
		this.reward = reward;
		this.punish = punish;
		this.punishReason = punishReason;
		this.employee = employee;
		this.oper = oper;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Float getReleaseSalary() {
		return releaseSalary;
	}
	public void setReleaseSalary(Float releaseSalary) {
		this.releaseSalary = releaseSalary;
	}
	public Float getTotalSalary() {
		return totalSalary;
	}
	public void setTotalSalary(Float totalSalary) {
		this.totalSalary = totalSalary;
	}
	public Float getTax() {
		return tax;
	}
	public void setTax(Float tax) {
		this.tax = tax;
	}
	public Float getReward() {
		return reward;
	}
	public void setReward(Float reward) {
		this.reward = reward;
	}
	public Float getPunish() {
		return punish;
	}
	public void setPunish(Float punish) {
		this.punish = punish;
	}
	public String getPunishReason() {
		return punishReason;
	}
	public void setPunishReason(String punishReason) {
		this.punishReason = punishReason;
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
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
