package br.com.tockinha.crud_cursos;

import org.springframework.data.jpa.repository.JpaRepository;

interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}
