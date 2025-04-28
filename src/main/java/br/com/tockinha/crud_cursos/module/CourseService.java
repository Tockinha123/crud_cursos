package br.com.tockinha.crud_cursos.module;

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

    public List<CourseEntity> listAll () {
        return courseRepository.findAll();
    }


}
