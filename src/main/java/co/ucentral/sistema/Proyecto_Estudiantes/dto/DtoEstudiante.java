package co.ucentral.sistema.Proyecto_Estudiantes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class DtoEstudiante {
    private Long cedula;
    private String nombre;
    private String email;
}
