package com.example.demo.controller;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class studentForm {
    private MultipartFile file;

    private String f_name;

    private String m_name;

    private String l_name;

    private boolean is_male;

    @Email
    private String email;

    private String mobile_no;

    private Long institute_type_id;
    private Long institute_id;
    private Long department_id;
    private Long designation_id;
    private String hobbies;

    // getters and setters...

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
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

    // Add getters and setters for other properties...
}
