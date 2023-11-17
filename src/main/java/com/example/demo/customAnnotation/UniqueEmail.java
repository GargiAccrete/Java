//package com.example.demo.customAnnotation;
//
//import javax.validation.Constraint;
//import javax.validation.Payload;
//
//import com.example.demo.customValidator.UniqueEmailValidator;
//
//import java.lang.annotation.*;
//
//@Documented
//@Constraint(validatedBy = UniqueEmailValidator.class) 
//@Target({ElementType.FIELD})
//@Retention(RetentionPolicy.RUNTIME)
//public @interface UniqueEmail {
//    String message() default "Email already exists";
//    Class<?>[] groups() default {};
//    Class<? extends Payload>[] payload() default {};
//}
