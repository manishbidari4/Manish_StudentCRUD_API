package student.crud.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student.crud.springboot.model.Student;

public interface StudentRepository extends JpaRepository <Student, Long> {

}
