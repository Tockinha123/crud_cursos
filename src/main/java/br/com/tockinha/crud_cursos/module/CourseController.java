package br.com.tockinha.crud_cursos.module;

import br.com.tockinha.crud_cursos.module.dto.CourseInfo;
import br.com.tockinha.crud_cursos.module.dto.CourseRequestDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/")
    public ResponseEntity<CourseEntity> createCourse (@RequestBody @Valid CourseRequestDTO courseRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.create(courseRequestDTO));
    }

    @GetMapping("/")
    public ResponseEntity<List<CourseInfo>> listCourses () {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseInfo> listCourse (@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.list(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseEntity> updateCourse (@PathVariable Long id, CourseRequestDTO courseRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.update(id, courseRequestDTO));
    }

}
