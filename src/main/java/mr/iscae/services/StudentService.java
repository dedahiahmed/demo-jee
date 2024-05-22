package mr.iscae.services;

import jakarta.inject.Inject;
import mr.iscae.entities.Student;
import mr.iscae.repositories.StudentRepository;

import java.util.List;

public class StudentService {
    @Inject
    StudentRepository studentRepository;

    public List<Student> getAllStudent() {
        return studentRepository.getAll();
    }

    public Student add(Student user) {
        return studentRepository.add(user);
    }
}
