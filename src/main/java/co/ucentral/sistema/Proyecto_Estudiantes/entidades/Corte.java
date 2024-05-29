package co.ucentral.sistema.Proyecto_Estudiantes.entidades;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cortes")
public class Corte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo", nullable =false)
    private int codigo;

    @Column(name="fechaApertura", nullable =false)
    private LocalDate fechaApertura;

    @Column(name="fechaCierre", nullable =false)
    private LocalDate fechaCierre;


    @OneToMany(mappedBy="corte")
    private List<Actividad> actividades;
    

    @OneToMany(mappedBy = "corte")
    private List<Actividad> actividades2;


    public void addActividad(Actividad actividad) {
        actividades.add(actividad);
        actividad.setCorte(this);
    }
}
