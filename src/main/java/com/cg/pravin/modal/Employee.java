package com.cg.pravin.modal;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Locale.IsoCountryCode;

@Entity
@Table(name = "Employee_Data")
public class Employee {

	@Id
	private Integer empId;

	@NotNull(message = "Name may not be null")
	private String firstName;

	private String lastName;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	private String password;
	
	private boolean isLogged = false;
	
	private String confirmationToken;
	
	private String Country;

	//	@Column(name = "mobile_number", nullable = false, unique = true)
	//	private String mobileNumber;
	
	//	private String gender;

	public Employee() {
		super();
	}

	public Employee(Integer empId, @NotNull(message = "Name may not be null") String firstName, String lastName,
			 String email, String password, boolean isLogged, String confirmationToken) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.isLogged = isLogged;
		this.confirmationToken = confirmationToken;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName 
				+ ", email=" + email + ", isLogged=" + isLogged + ", confirmationToken=" + confirmationToken + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(confirmationToken, email, empId, firstName, isLogged, lastName, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(confirmationToken, other.confirmationToken) && Objects.equals(email, other.email)
				&& Objects.equals(empId, other.empId) && Objects.equals(firstName, other.firstName)
				&& isLogged == other.isLogged
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password);
	}
		
}
