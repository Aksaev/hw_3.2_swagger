package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;

@Service
public class FacultyService {
    private final HashMap<Long, Faculty> faculties = new HashMap<>();
    private long lastId = 0;

    // Добавление факультета
    public Faculty addFaculty(Faculty faculty) {
        faculty.setId(lastId++);
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    // Поиск факультета по идентифиактору
    public Faculty findFaculty(long id) {
        return faculties.get(id);
    }

    // Редактирование факультета по идентификатору
    public Faculty editFaculty(long id, Faculty faculty) {
        if (faculties.containsKey(id)) {
            faculties.put(id, faculty);
            return faculty;
        }
        return null;
    }

    // Удаление факультета по идентификатору
    public Faculty deleteFaculty(long id) {
        return faculties.remove(id);
    }

    // Отображение всех факультета
    public Collection<Faculty> getAllFaculties() {
        return faculties.values();
    }

}
