//package com.example.demo.customValidator;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.example.demo.customAnnotation.UniqueEmail;
//import com.example.demo.service.StudentService;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
//
//    @Autowired
//    private StudentService studentService; // You may need to inject your service here
//
//    @Override
//    public void initialize(UniqueEmail constraintAnnotation) {
//    }
//
//    @Override
//    public boolean isValid(String email, ConstraintValidatorContext context) {
//        if (email == null) {
//            return true; // Allow null values, handle required field validation separately
//        }
//        
//        System.out.println(studentService.emailExists(email) + "  hsdgfdhgfhghgfhghdgfdhgfdhgfdfhfdjfj");
////        return false;
//        return !studentService.emailExists(email);
//    }
//}
