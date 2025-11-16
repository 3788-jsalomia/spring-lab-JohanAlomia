package edu.espe.springlab.repository;

//Nombre: Johan Alomia

import edu.espe.springlab.domain.Student;
import edu.espe.springlab.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

@DataJpaTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository respository;

    @Test
    void shouldSaveAndFineStudentByEmail(){
        Student s = new Student();
        s.setFullName("Test User");
        s.setEmail("test@example.com");
        s.setBirthDate(LocalDate.of(2000,10,10));
        s.setActive(true);

        respository.save(s);

        var result = respository.findByEmail("test@example.com");

        assertThat(result).isPresent();
        assertThat((result).get().getFullName()).isEqualTo("Test User")

    }
}
