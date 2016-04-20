package com.neu.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;

@Entity
@Table(name = "login")
public class Login {

	final static Logger logger = Logger.getLogger(Login.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loginId;

	@NotNull(message = "Username is a required field")
	private String username;

	@NotNull(message = "Password is a required field")
	private String password;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roleId")
	private Role role;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "empId")
	private Employee employee;

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
