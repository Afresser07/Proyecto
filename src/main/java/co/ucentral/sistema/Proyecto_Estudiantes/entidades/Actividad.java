package co.ucentral.sistema.Proyecto_Estudiantes.entidades;

import java.time.LocalDate;
import java.util.List;

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
    
    @Column(name="puntos")
    private int puntos;

    @OneToMany(mappedBy = "actividad")
    private List<Calificacion> calificaciones;

    @ManyToOne
    @JoinColumn(name="corte_id")
    private Corte corte;

    @ManyToOne
    @JoinColumn(name = "asignaturaId")
    private Asignatura asignatura;

    private LocalDate fecha;
}
