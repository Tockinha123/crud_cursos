package br.com.tockinha.crud_cursos.module;

import br.com.tockinha.crud_cursos.exceptions.CourseNotFoundException;
import br.com.tockinha.crud_cursos.module.dto.CourseInfo;
import br.com.tockinha.crud_cursos.module.dto.CourseRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity create(CourseRequestDTO courseRequestDTO) {
        CourseEntity course = CourseEntity.builder()
                .name(courseRequestDTO.getName())
                .category(courseRequestDTO.getCategory())
                .active(courseRequestDTO.getActive())
                .build();

        return courseRepository.save(course);
    }

    public List<CourseInfo> listAll () {
        return courseRepository.findAllByOrderByCreatedAtDesc();
    }

    public CourseInfo list (Long id) {
        var course = courseRepository.findCourseEntityById(id).orElseThrow(
                () -> new CourseNotFoundException("Course not found.")
        );

        return course;
    }

    public CourseEntity update (Long id, CourseRequestDTO courseRequestDTO) {
        var course = courseRepository.findById(id).orElseThrow(
                () -> new CourseNotFoundException("Course not Found")
        );

        course.setActive(courseRequestDTO.getActive());
        course.setName(courseRequestDTO.getName());
        course.setCategory(courseRequestDTO.getCategory());

        return course;
    }


}
