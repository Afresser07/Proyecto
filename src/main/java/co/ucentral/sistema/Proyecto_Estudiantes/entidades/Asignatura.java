package co.ucentral.sistema.Proyecto_Estudiantes.entidades;

import java.util.Collection;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "asignaturas")
@Builder
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo", nullable =false)
    private int codigo;

    @Column(name="nombre", nullable =false)
    private String nombre;

    @Column(name="periodoApertura", nullable =false)
    private Date periodoApertura;

    @Column(name="periodoCierre", nullable =false)
    private Date periodoCierre;

    @ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
        name="estudiantes_asignaturas",
        joinColumns = @JoinColumn(name="asignatura_id",referencedColumnName="codigo"),
        inverseJoinColumns = @JoinColumn(name = "estudiante_id",referencedColumnName = "cedulaEstudiante"))
    private Collection<Estudiante> estudiantes;

    @ManyToOne
    @JoinColumn(name="profesor_id")
    private Profesor profesor;

    @OneToMany(mappedBy = "asignatura")
    private Collection<Actividad> actividades;
}
