package co.ucentral.sistema.Proyecto_Estudiantes.entidades;

import java.time.LocalDate;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name= "actividades")
@Builder
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo")
    private int codigo;

    @Column(name="nombre")
    private String nombre;

    @Column(name="fecha")
    private LocalDate fecha;
    
    @Column(name="puntos")
    private int puntos;

    @ManyToOne
    @JoinColumn(name="actividad_id")
    private Asignatura asignatura;

    @OneToMany(mappedBy = "actividad")
    private Collection<Calificacion> calificaciones;

    @ManyToOne
    @JoinColumn(name="corte_id", nullable = false)
    private Corte corte;
}
