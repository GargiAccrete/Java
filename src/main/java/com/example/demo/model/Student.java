package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//import com.example.demo.customAnnotation.UniqueEmail;

@Entity
@Table(name="student")
public class Student {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
//	@NotBlank(message = "First name is required")
	@Size(max = 100, message = "First name must not exceed 100 characters")
	@Column(name="f_name",length=100)
    private String f_name;

	@Size(max = 100, message = "Middle name must not exceed 100 characters")
	@Column(name="m_name",length=100)
	private String m_name;

	@Size(max = 100, message = "Last name must not exceed 100 characters")
	@Column(name="l_name",length=100)
	private String l_name;
	
	@Column(name="is_male")
    private boolean is_male;
	
//	@UniqueEmail
	@NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(max = 100, message = "Email must not exceed 100 characters")
	@Column(name="email",length=100)
    private String email;
	
	@Size(max = 10, message = "Mobile number must not exceed 10 characters")
	@Column(name="mobile_no",length=10)
    private String mobile_no;
	
	@Column(name="institute_type_id")
    private Long institute_type_id;
	
	@Column(name="institute_id")
    private Long institute_id;
	
	@Column(name="department_id", nullable = false)
    private Long department_id;
	
	@Column(name="designation_id")
    private Long designation_id;
	
	@Column(name="hobbies",length=100)
    private String hobbies;
	
	@Column(name="imageUrl",length=1000)
    private String imageUrl; // File upload field
    
	@Column(name="created_at",length=10)
    private long created_at; 
	
	@Column(name="updated_at",length=10)
    private long updated_at;
	
	@Column(name="is_deleted")
	private boolean is_deleted;

	
	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public boolean isIs_male() {
		return is_male;
	}

	public void setIs_male(boolean is_male) {
		this.is_male = is_male;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public Long getInstitute_type_id() {
		return institute_type_id;
	}

	public void setInstitute_type_id(Long institute_type_id) {
		this.institute_type_id = institute_type_id;
	}

	public Long getInstitute_id() {
		return institute_id;
	}

	public void setInstitute_id(Long institute_id) {
		this.institute_id = institute_id;
	}

	public Long getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Long department_id) {
		this.department_id = department_id;
	}

	public Long getDesignation_id() {
		return designation_id;
	}

	public void setDesignation_id(Long designation_id) {
		this.designation_id = designation_id;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public long getCreated_at() {
		return created_at;
	}

	public void setCreated_at(long l) {
		this.created_at = l;
	}

	public long getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(long l) {
		this.updated_at = l;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", f_name=" + f_name + ", m_name=" + m_name + ", l_name=" + l_name + ", is_male="
				+ is_male + ", email=" + email + ", mobile_no=" + mobile_no + ", institute_type_id=" + institute_type_id
				+ ", institute_id=" + institute_id + ", department_id=" + department_id + ", designation_id="
				+ designation_id + ", hobbies=" + hobbies + ", imageUrl=" + imageUrl + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + ", is_deleted=" + is_deleted + "]";
	}

		
}
