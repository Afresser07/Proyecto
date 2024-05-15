package co.ucentral.sistema.Proyecto_Estudiantes.entidades;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "Profesores")
@Builder
public class Profesor implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROF_REL")
    @SequenceGenerator(name = "SEQ_PROF_REL", sequenceName = "SEQ_PROF_REL", allocationSize = 1)
    @Column(name="cedulaEstudiante", nullable =false )
    private int cedula;

    @Column(name="nombreProfesor", nullable =false )
    private String nombre;

    @Column(name="emailProfesor", nullable =false, unique=true)
    private String email;

    @OneToMany(mappedBy = "profesor")
    private Collection<Asignatura> asignaturas;

}
