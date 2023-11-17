package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	long countByEmail(String email);
	
	@Query("SELECT COUNT(s) FROM Student s WHERE s.mobile_no = :mobileNo")
    Long countByMobile_no(@Param("mobileNo") String mobileNo);
	
	@Modifying
    @Query("UPDATE Student s SET s.is_deleted = true WHERE s.id = :id")
    void softDeleteById(@Param("id") Long id);
	
	@Query("SELECT s FROM Student s WHERE s.is_deleted = false")
    List<Student> findAllNotDeleted();

	long countByEmailAndIdNot(String email, Long id);
	
	@Query("SELECT COUNT(s) FROM Student s WHERE s.mobile_no = :mobileNo and s.id != :id")
    Long countByMobile_noAndIdNot(@Param("mobileNo") String mobileNo, @Param("id") long id);
//	 Optional<Student> findByIdAndIsDeleteFalse(Long id);
}
