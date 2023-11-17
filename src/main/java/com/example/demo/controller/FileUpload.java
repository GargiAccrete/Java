package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class FileUpload {

    private static final Logger logger = LoggerFactory.getLogger(FileUpload.class);

    @Autowired
    private StudentService studentService;
    // Define the base directory for storing uploaded files
//    @Value("${upload.directory}")
    private String uploadDirectory = "src/main/resources/static/Images/";

    @PostMapping("/addStudent")
    public @ResponseBody String uploadFileHandler(@Valid @RequestParam("file") MultipartFile file, 
    		@RequestBody Student student
//    		@RequestParam("f_name") String f_name,
//            @RequestParam("m_name") String m_name,
//            @RequestParam("l_name") String l_name,
//            @RequestParam("is_male") boolean is_male,
//            @RequestParam("email") @NotBlank @Email String email,
//            @RequestParam("mobile_no") String mobile_no,
//            @RequestParam("institute_type_id") Long institute_type_id,
//            @RequestParam("institute_id") Long institute_id,
//            @RequestParam("department_id") Long department_id,
//            @RequestParam("designation_id") Long designation_id,
//            @RequestParam("hobbies") String hobbies
            ) throws IOException {
            
//        	Student student = new Student();
//			student.setF_name(f_name.trim());
//			student.setM_name(m_name.trim());
//			student.setL_name(l_name.trim());
//			student.setIs_male(is_male);
//			student.setEmail(email.trim());
//			student.setMobile_no(mobile_no); 
//			student.setInstitute_type_id(institute_type_id);
//			student.setInstitute_id(institute_id);
//			student.setDepartment_id(department_id);
//			student.setDesignation_id(designation_id);
//			student.setHobbies(hobbies);
//			student.setCreated_at(System.currentTimeMillis());
//			student.setUpdated_at(System.currentTimeMillis());
//			student.setIs_deleted(false);
			
			System.out.println("ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss" + student);
			
			if (!file.isEmpty()) {
         
				try {
			        // Get the original file name
			        String originalFileName = "product_" + System.currentTimeMillis() + "_" + file.getOriginalFilename();

			        // Create the directory to store file if it doesn't exist
			        Path uploadPath = Paths.get(uploadDirectory);
			        if (!uploadPath.toFile().exists()) {
			            uploadPath.toFile().mkdirs();
			        }

			        // Save the file to the server with its original name
			        Path serverFilePath = Paths.get(uploadDirectory, originalFileName);
			        file.transferTo(serverFilePath);

			        System.out.println("ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg"+ originalFileName);
			        logger.info("Server File Location=" + serverFilePath);
			        student.setImageUrl(originalFileName);
			        Student savedStudent = studentService.addStudent(student, file);
			        return "Congratulations!!! " + student.getF_name() + " "+student.getL_name() + ".Registration successfull.";
			    } catch (IOException e) {
			        return "Registration Failed. Please try again later" ;
			    }
//			}else {
//				Student saveStudent = studentService.addStudent(student, file);
			}
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			return "redirect:/Students";
    }    

    @GetMapping("/listStudents")
    public @ResponseBody List<Student> listStudents() {
        List<Student> students = studentService.getAllStudents();
        return students;
    }

    @GetMapping("/getStudentDetail")
    public ResponseEntity<Student> getStudentDetail(@RequestParam(name = "studentId", required = false) long studentId) {
        Student student = studentService.getStudentById(studentId);

        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

  
    @PostMapping("/updateStudent/{id}")
    public @ResponseBody ResponseEntity<String> updateStudent(
        @PathVariable("id") Long id,
        @Valid @RequestParam("file") MultipartFile file,
        @RequestParam("f_name") String f_name,
        @RequestParam("m_name") String m_name,
        @RequestParam("l_name") String l_name,
        @RequestParam("is_male") boolean is_male,
        @RequestParam("email") @Email String email,
        @RequestParam("mobile_no") String mobile_no,
        @RequestParam("institute_type_id") Long institute_type_id,
        @RequestParam("institute_id") Long institute_id,
        @RequestParam("department_id") Long department_id,
        @RequestParam("designation_id") Long designation_id,
        @RequestParam("hobbies") String hobbies
    ) {
        Student existingStudent = studentService.getStudentById(id);

        if (existingStudent == null) {
            return ResponseEntity.notFound().build();
        }

        existingStudent.setF_name(f_name.trim());
        existingStudent.setM_name(m_name.trim());
        existingStudent.setL_name(l_name.trim());
        existingStudent.setIs_male(is_male);
        existingStudent.setEmail(email.trim());
        existingStudent.setMobile_no(mobile_no);
        existingStudent.setInstitute_type_id(institute_type_id);
        existingStudent.setInstitute_id(institute_id);
        existingStudent.setDepartment_id(department_id);
        existingStudent.setDesignation_id(designation_id);
        existingStudent.setHobbies(hobbies);
        existingStudent.setUpdated_at(System.currentTimeMillis());
        existingStudent.setIs_deleted(false);

        if (!file.isEmpty()) {
            try {
                String originalFileName = file.getOriginalFilename();
                String newFileName = "product_" + System.currentTimeMillis() + "_" + file.getOriginalFilename();
                Path serverFilePath = Paths.get(uploadDirectory, newFileName);
                file.transferTo(serverFilePath);

                existingStudent.setImageUrl(newFileName);
            } catch (IOException e) {
                return ResponseEntity.badRequest().body("File update failed. Please try again later.");
            }
        }

        studentService.updateStudent(existingStudent);
        return ResponseEntity.ok("Student updated successfully.");
    }

    @GetMapping("/deleteStudent/{id}")
    public @ResponseBody ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {
        Student student = studentService.getStudentById(id);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + id);

        if (student == null) {
            return ResponseEntity.notFound().build();
        }

        studentService.softDeleteStudent(student);
        return ResponseEntity.ok("Student with ID " + id + " marked as deleted.");
    }

}
