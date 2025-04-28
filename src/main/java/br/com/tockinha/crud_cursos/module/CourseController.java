package br.com.tockinha.crud_cursos.module;

import br.com.tockinha.crud_cursos.module.dto.CourseRequestDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/")
    public ResponseEntity<Object> createCourse (@RequestBody @Valid CourseRequestDTO courseRequestDTO) {
        return new ResponseEntity<>(courseService.create(courseRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<Object> listCourses () {
        return new ResponseEntity<>(courseService.listAll(), HttpStatus.OK);
    }
}
