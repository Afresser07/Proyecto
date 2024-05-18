package co.ucentral.sistema.Proyecto_Estudiantes.repositorios;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Actividad;
import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Calificacion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class RepositorioActividadTest {
    @Autowired
    RepositorioCalificacion repositorioCalificacion;

    @Autowired
    TestEntityManager TestEntityManager;
    @DisplayName("Test de calificacion")
    @Test
    void testGuardarCalificacion(){
        Actividad actividad = Actividad
                .builder()
                .corte(1)
                .puntos(2)
                .build();

        Calificacion calificacion = Calificacion
                .builder()
                .nota(30)
                .actividad(actividad)
                .build();

        Calificacion calificacion1 = repositorioCalificacion.save(calificacion);
        assertThat(calificacion).isNotNull();
        assertThat(calificacion.getCodigo()).isGreaterThan(0);
    }
}