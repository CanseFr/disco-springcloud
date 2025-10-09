package com.canse.teacher;

import com.canse.teacher.entities.Teacher;
import com.canse.teacher.repos.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class TeacherApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeacherApplication.class, args);
	}

    @Bean
    CommandLineRunner commandLineRunner(TeacherRepository teacherRepository) {
        return args -> {
            teacherRepository.save(
                    Teacher.builder()
                            .firstName("Canse")
                            .lastName("LaFamille")
                            .depCode("IT")
                            .build()
            );
        };
    }

}
