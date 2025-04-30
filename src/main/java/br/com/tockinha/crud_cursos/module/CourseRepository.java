package br.com.tockinha.crud_cursos.module;

import br.com.tockinha.crud_cursos.module.dto.CourseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface CourseRepository extends JpaRepository<CourseEntity, Long> {

    List<CourseInfo> findAllByOrderByCreatedAtDesc();

    Optional<CourseInfo> findCourseEntityById(Long id);

}
