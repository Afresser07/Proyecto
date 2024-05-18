package co.ucentral.sistema.Proyecto_Estudiantes.entidades;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "calificaciones")
@Builder
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo", nullable =false)
    private int codigo;

    @Column(name="nota", nullable =false)
    private int nota;

    @Column(name="fecha", nullable =false)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name="actividad_id")
    private Actividad actividad;

    @OneToOne
    private Estudiante estudiante;
}
