package co.ucentral.sistema.Proyecto_Estudiantes.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profesores")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROFESOR")
    @SequenceGenerator(name="SEQ_PROFESOR",sequenceName = "SEQ_PROFESOR",allocationSize = 1)
    @Column(name="CEDULA_PROFESOR",nullable = false)
    private long cedula;

    @Column(name="NOMBRE_PROFESOR",nullable = false)
    private String nombre;

    @Column(name="EMAIL_PROFESOR",nullable = false)
    private String email;
}
