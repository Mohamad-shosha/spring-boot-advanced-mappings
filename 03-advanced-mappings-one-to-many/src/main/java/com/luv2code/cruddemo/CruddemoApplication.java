package com.luv2code.cruddemo;
import com.luv2code.cruddemo.Dao.Appdao;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
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
			//deletebyid(appdao);
			//FindInstructorDetailById(appdao);
			//removeInstuctorDetailById(appdao);
			//creatInstructorWithCourses(appdao);
			//FindInstructorWithCourses(appdao);
			//FindInstructorWithCoursesByJoinFetsh(appdao);
			//UpdateInstructor(appdao);
			//updateCourse(appdao);
			deleteCourseById(appdao);
		};
	}

	private void deleteCourseById(Appdao appdao) {
		int id = 13;
		System.out.println("Searching for the id : "+id);
		 appdao.deleteCourseById(id);
		 System.out.println("Done");
	}

	private void updateCourse(Appdao appdao) {
		int id = 10;
		System.out.println("Searching for the id : "+id);
		Course course = appdao.findCourseById(id);
		System.out.println("The course "+course+" will be apdate");
		course.setTitle("Luv2code");
		appdao.updateCourse(course);
	}

	private void UpdateInstructor(Appdao appdao) {
		int id = 1 ;
		System.out.println("Searching for the id : "+ id);
		Instructor instructor = appdao.findInstuctorById(id);
		System.out.println("Updating the id : "+id);
		instructor.setLastName("shosha");
		appdao.Update(instructor);
		System.out.println("Done!");
	}

	private void FindInstructorWithCoursesByJoinFetsh(Appdao appdao) {
		int id = 1 ;
		System.out.println("Search the id : " + id);
		Instructor instructor = appdao.FindInstructorByIdJoinFetch(id);
		System.out.println("The Instructor is : "+instructor);
		System.out.println("The associated courses is : "+instructor.getCourses());
	}


	private void FindInstructorWithCourses(Appdao appdao) {
		int id = 1 ;
		System.out.println("Search the id : " + id);
		Instructor tempInstructor = appdao.findInstuctorById(id);
		List<Course> theList = appdao.FindCoursesByInstructorId(id);
		tempInstructor.setCourses(theList);
		System.out.println("The associated courses : "+ tempInstructor.getCourses());
	}

	private void creatInstructorWithCourses(Appdao appdao) {
		Instructor theInstructor = new Instructor("Mohamed","Ibrahim","moshosha267@gmail.com");
		InstructorDetail theInstructorDetail = new InstructorDetail("http://www.luv2code.com","luv2code");
		theInstructor.setInstructorDetailId(theInstructorDetail);
		Course course1 = new Course("Object Oriented Programming");
		Course course2 = new Course("Data Structure and algorithm");
		theInstructor.add(course1);
		theInstructor.add(course2);
		System.out.println("Saving Instructor : " + theInstructor);
		System.out.println("The detail of the constructor : " + theInstructor.getInstructorDetailId());
		System.out.println("The courses is : " + theInstructor.getCourses());
		appdao.save(theInstructor);
	}

	private void removeInstuctorDetailById(Appdao appdao) {
		int id = 2 ;
		System.out.println("The id : "+id +" will be removed");
		appdao.removeInstructorDetail(id);
		System.out.println("Done");
	}


	private void FindInstructorDetailById(Appdao appdao) {
		int id = 3 ;
		InstructorDetail tempinstructorDetail = appdao.findInsttructorById(id);
		System.out.println("The Instructor detail is : "+tempinstructorDetail);
		System.out.println("The associated detail is : "+tempinstructorDetail.getInstructor());
	}

	private void deletebyid(Appdao appdao) {
		int id = 2;
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
		/*Instructor theInstructor = new Instructor("Mohamed","Ibrahim","moshosha267@gmail.com");
		InstructorDetail theInstructorDetail = new InstructorDetail("http://www.luv2code.com","luv2code");
		theInstructor.setInstructorDetailId(theInstructorDetail);
		System.out.println("Saving Instructor : "+theInstructor);
		appdao.save(theInstructor);
		System.out.println("Done !");
		/*Instructor theInstructor2 = new Instructor("Rovan","salah","rovansalah157@gmail.com");
		InstructorDetail theInstructorDetail2 = new InstructorDetail("http://www.artista.com","Artist");
		theInstructor.setInstructorDetailId(theInstructorDetail);
		System.out.println("Saving Instructor : "+theInstructor);
		appdao.save(theInstructor);
		System.out.println("Done !");*/
	}
}
