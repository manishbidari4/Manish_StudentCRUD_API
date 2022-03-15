package student.crud.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import student.crud.springboot.model.Gender;
import student.crud.springboot.model.Student;
import student.crud.springboot.repository.StudentRepository;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
public class SpringbootCrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {
		Student student = new Student();
		student.setName("ManishBidari");
		student.setAddress("Thankot");
		student.setContact("9860558459");
		student.setGender(Gender.Male);
		student.setCreated_at(Timestamp.valueOf(LocalDateTime.now()));
		student.setUpdated_at(Timestamp.valueOf(LocalDateTime.now()));
		studentRepository.save(student);


	}
}
