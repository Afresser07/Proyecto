package co.ucentral.sistema.Proyecto_Estudiantes.entidades;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estudiantes")

public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESTU_REL")
    @SequenceGenerator(name = "SEQ_ESTU_REL", sequenceName = "SEQ_ESTU_REL", allocationSize = 1)
    @Column(name="cedulaEstudiante", nullable =false )
    private int cedula;

    @Column(name="nombreEstudiante", nullable =false )
    private String nombre;

    @Column(name="emailEstudiante", nullable =false, unique=true)
    private String email;
}
