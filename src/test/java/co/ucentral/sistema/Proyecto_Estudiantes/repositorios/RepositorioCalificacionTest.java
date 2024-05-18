package co.ucentral.sistema.Proyecto_Estudiantes.repositorios;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Calificacion;
import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Estudiante;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RepositorioCalificacionTest {
    @Autowired
    RepositorioEstudiante repositorioEstudiante;

    @Autowired
    RepositorioCalificacion repositorioCalificacion;

    @Autowired
    TestEntityManager testEntityManager;
    @DisplayName("Test de estudiantes")
    @Test
    void testGuardarEstudiante() {

        Estudiante estudiante = Estudiante
                .builder()
                .nombre("estudiante1")
                .email("estudiante1@gmail.com")
                .build();

        Calificacion calificacion = Calificacion
                .builder()
                .nota(30)
                .estudiante(estudiante)
                .build();

        Calificacion calificacion2 = repositorioCalificacion.save(calificacion);

        assertThat(calificacion2).isNotNull();
        assertThat(calificacion2.getCodigo()).isGreaterThan(0);
    }
}