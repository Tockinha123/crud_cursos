package br.com.tockinha.crud_cursos.module.dto;

import br.com.tockinha.crud_cursos.module.CourseStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Category is required")
    private String category;

    private CourseStatus active;
}
