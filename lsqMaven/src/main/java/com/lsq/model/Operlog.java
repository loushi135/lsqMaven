package com.lsq.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Operlog entity. @author MyEclipse Persistence Tools
 */
@Table(name="OperLog")
@Entity
public class Operlog extends BaseTO implements
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
	@ManyToOne
	@JoinColumn(name = "OPERID")
	private Oper oper;
	@Column(name = "CONTENT")
	private String content;
	@Column(name = "IP")
	private String ip;
	@Column(name = "OPERTIME")
	private Timestamp opertime;

	// Constructors

	/** default constructor */
	public Operlog() {
	}

	public Operlog(String id, Oper oper, String content, String ip,
			Timestamp opertime) {
		super();
		this.id = id;
		this.oper = oper;
		this.content = content;
		this.ip = ip;
		this.opertime = opertime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Oper getOper() {
		return oper;
	}

	public void setOper(Oper oper) {
		this.oper = oper;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Timestamp getOpertime() {
		return opertime;
	}

	public void setOpertime(Timestamp opertime) {
		this.opertime = opertime;
	}


}