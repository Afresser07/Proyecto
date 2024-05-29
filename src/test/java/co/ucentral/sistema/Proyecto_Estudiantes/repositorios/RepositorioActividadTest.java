package co.ucentral.sistema.Proyecto_Estudiantes.repositorios;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Actividad;
import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Calificacion;
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