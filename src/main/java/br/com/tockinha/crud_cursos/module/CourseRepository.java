package br.com.tockinha.crud_cursos.module;

import org.springframework.data.jpa.repository.JpaRepository;

interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}
