package br.com.tockinha.crud_cursos.module.dto;

import br.com.tockinha.crud_cursos.module.CourseStatus;

import java.time.LocalDateTime;

public interface CourseInfo {
    Long getId();

    String getName();

    String getCategory();

    CourseStatus getActive();

    LocalDateTime getCreatedAt();
}