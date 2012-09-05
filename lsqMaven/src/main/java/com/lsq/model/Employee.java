package com.lsq.model;

import java.util.Date;

import javax.persistence.Cacheable;
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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Table(name="employee")
@Entity
public class Employee extends BaseTO{
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	@Column(name = "empNo")
	private String empNo;
	@Column(name = "empName")
	private String empName;
	@Column(name = "empSex")
	private Integer empSex;
	@Column(name = "empHometown")
	private String empHometown;
	@Column(name = "empMarriage")
	private Integer empMarriage;
	@Column(name = "empIDNO")
	private String empIDNO;
	@Column(name = "empEducation")
	private String empEducation;
	@Column(name = "empSchool")
	private Integer empSchool;
	@Column(name = "graduateDate")
	private Date graduateDate;
	@ManyToOne(fetch=FetchType.EAGER,optional=true,cascade=CascadeType.PERSIST)
	@JoinColumn(name="deptId")
	private Basedata dept;
	@Column(name = "empStatus")
	private Integer empStatus;
	@Column(name = "empTitle")
	private String empTitle;
	@Column(name = "empPhone")
	private Integer empPhone;
	@Column(name = "empAddress")
	private String empAddress;
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	@JoinColumn(name="operId")
	private Oper oper;
	@OneToOne(mappedBy="employee")
	@NotFound(action=NotFoundAction.IGNORE)
	private BaseSalary baseSalary;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String id, String empNo, String empName, Integer empSex,
			String empHometown, Integer empMarriage, String empIDNO,
			String empEducation, Integer empSchool, Date graduateDate,
			Basedata dept, Integer empStatus, String empTitle,
			Integer empPhone, String empAddress, Oper oper) {
		super();
		this.id = id;
		this.empNo = empNo;
		this.empName = empName;
		this.empSex = empSex;
		this.empHometown = empHometown;
		this.empMarriage = empMarriage;
		this.empIDNO = empIDNO;
		this.empEducation = empEducation;
		this.empSchool = empSchool;
		this.graduateDate = graduateDate;
		this.dept = dept;
		this.empStatus = empStatus;
		this.empTitle = empTitle;
		this.empPhone = empPhone;
		this.empAddress = empAddress;
		this.oper = oper;
	}

	public BaseSalary getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(BaseSalary baseSalary) {
		this.baseSalary = baseSalary;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Integer getEmpSex() {
		return empSex;
	}
	public void setEmpSex(Integer empSex) {
		this.empSex = empSex;
	}
	public String getEmpHometown() {
		return empHometown;
	}
	public void setEmpHometown(String empHometown) {
		this.empHometown = empHometown;
	}
	public Integer getEmpMarriage() {
		return empMarriage;
	}
	public void setEmpMarriage(Integer empMarriage) {
		this.empMarriage = empMarriage;
	}
	public String getEmpIDNO() {
		return empIDNO;
	}
	public void setEmpIDNO(String empIDNO) {
		this.empIDNO = empIDNO;
	}
	public String getEmpEducation() {
		return empEducation;
	}
	public void setEmpEducation(String empEducation) {
		this.empEducation = empEducation;
	}
	public Integer getEmpSchool() {
		return empSchool;
	}
	public void setEmpSchool(Integer empSchool) {
		this.empSchool = empSchool;
	}
	
	public Date getGraduateDate() {
		return graduateDate;
	}

	public void setGraduateDate(Date graduateDate) {
		this.graduateDate = graduateDate;
	}

	public Basedata getDept() {
		return dept;
	}
	public void setDept(Basedata dept) {
		this.dept = dept;
	}
	public Integer getEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(Integer empStatus) {
		this.empStatus = empStatus;
	}
	public String getEmpTitle() {
		return empTitle;
	}
	public void setEmpTitle(String empTitle) {
		this.empTitle = empTitle;
	}
	public Integer getEmpPhone() {
		return empPhone;
	}
	public void setEmpPhone(Integer empPhone) {
		this.empPhone = empPhone;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public Oper getOper() {
		return oper;
	}
	public void setOper(Oper oper) {
		this.oper = oper;
	}
	
	
}
