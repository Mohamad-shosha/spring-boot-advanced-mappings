package com.luv2code.cruddemo;

import com.luv2code.cruddemo.Dao.Appdao;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(Appdao appdao){
		return runner->{
			//CreatInstuctor(appdao);
			//FindInstructorById(appdao);
			deletebyid(appdao);
		};
	}

	private void deletebyid(Appdao appdao) {
		int id = 3 ;
		appdao.removeById(id);
		System.out.println("DONE!");
	}

	private void FindInstructorById(Appdao appdao) {
		int id = 1 ;
		System.out.println("Finding instructor by id :" + id);
		Instructor tempInstructor = appdao.findInstuctorById(id);
		System.out.println("tempInstructor" + tempInstructor);
	}

	private void CreatInstuctor(Appdao appdao) {
	/*	Instructor theInstructor = new Instructor("Mohamed","Ibrahim","moshosha267@gmail.com");
		InstructorDetail theInstructorDetail = new InstructorDetail("http://www.luv2code.com","luv2code");
		theInstructor.setInstructorDetailId(theInstructorDetail);
		System.out.println("Saving Instructor : "+theInstructor);
		appdao.save(theInstructor);
		System.out.println("Done !");*/
		Instructor theInstructor = new Instructor("Rovan","salah","rovansalah157@gmail.com");
		InstructorDetail theInstructorDetail = new InstructorDetail("http://www.artista.com","Artist");
		theInstructor.setInstructorDetailId(theInstructorDetail);
		System.out.println("Saving Instructor : "+theInstructor);
		appdao.save(theInstructor);
		System.out.println("Done !");
	}
}
