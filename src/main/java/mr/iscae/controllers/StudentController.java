package mr.iscae.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import mr.iscae.entities.Student;
import mr.iscae.services.StudentService;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/students")
public class StudentController {

    private static final long serialVersionUID = 1L;

    public StudentController() {
        super();
    }

    @Inject
    StudentService studentService;

    @GET
    public List<Student> getallUsers() {
        return studentService.getAllStudent();
    }

    @POST
    public Student add(Student student) {
        return studentService.add(student);
    }
}
