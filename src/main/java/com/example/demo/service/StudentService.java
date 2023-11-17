package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.exception.CustomException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student, MultipartFile file) throws IOException {
    		
//    		if (file != null && !file.isEmpty()) {
//            // Handle file upload logic here
//    			String fileName = "product_" + System.currentTimeMillis() + "_" + file.getOriginalFilename();
//            // Define your file storage logic here
//
//            // Save the file path in the product entity
//    			student.setImageUrl(fileName);
//    		}
        	if(student.getF_name().isBlank()) {
        		throw new CustomException("Name of the student is required");
        	}
    		if (student.getMobile_no() != null && student.getMobile_no().length() != 10) {
    			throw new IllegalArgumentException("Mobile number must be 10 characters long.");
    		}
    		if(studentRepository.countByEmail(student.getEmail()) > 0) {
    			throw new CustomException("Email already exists. Please use a different email address.");
    		}
    		if(studentRepository.countByMobile_no(student.getMobile_no()) > 0) {
    			throw new CustomException("Mobile number already in use. Please use a different mobile number address.");
    		}
    		System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
			return studentRepository.save(student);
    	
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAllNotDeleted();
    }
    
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    
    public void updateStudent(Student student) {
    	if (student.getMobile_no() != null && student.getMobile_no().length() != 10) {
			throw new IllegalArgumentException("Mobile number must be 10 characters long.");
		}
		if(studentRepository.countByEmailAndIdNot(student.getEmail(), student.getId()) > 0) {
			throw new CustomException("Email already exists. Please use a different email address.");
		}
		if(studentRepository.countByMobile_noAndIdNot(student.getMobile_no(), student.getId()) > 0) {
			throw new CustomException("Mobile number already in use. Please use a different mobile number address.");
		}
		System.out.println("serviceeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" + student);
        studentRepository.save(student);
    }
    
    public void softDeleteStudent(Student student) {
        student.setIs_deleted(true); // Set the flag to true
        studentRepository.save(student);
    }
    
//    public Student getStudentDetailById(Long id) {
//        return studentRepository.findByIdAndIsDeleteFalse(id).orElse(null);
//    }
}
