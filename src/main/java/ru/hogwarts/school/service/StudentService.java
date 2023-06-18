package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;

@Service
public class StudentService {
    private final HashMap<Long, Student> students = new HashMap<>();
    private long lastId = 0;

    // Добавление студента
    public Student addStudent(Student student) {
        student.setId(lastId++);
        students.put(student.getId(), student);
        return student;
    }

    // Поиск студента по идентифиактору
    public Student findStudent(long id) {
        return students.get(id);
    }

    // Редактирование студента по идентификатору
    public Student editStudent(long id, Student student) {
        if (students.containsKey(id)) {
            students.put(id, student);
            return student;
        }
        return null;
    }

    // Удаление студента по идентификатору
    public Student deleteStudent(long id) {
        return students.remove(id);
    }

    // Отображение всех студентов
    public Collection<Student> getAllStudents() {
        return students.values();
    }

}
