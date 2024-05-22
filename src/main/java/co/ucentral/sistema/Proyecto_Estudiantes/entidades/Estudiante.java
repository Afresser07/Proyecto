package co.ucentral.sistema.Proyecto_Estudiantes.entidades;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estudiantes")
@Builder
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
    
    @OneToMany(mappedBy = "estudiante")
    private List<Calificacion> calificaciones;

    @ManyToMany(mappedBy = "estudiantes")
    private List<Asignatura> asignaturas;
}
