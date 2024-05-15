package co.ucentral.sistema.Proyecto_Estudiantes.repositorios;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Asignatura;
import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Estudiante;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class RepositorioAsignaturaTest {
    @Autowired
    RepositorioEstudiante repositorioEstudiante;

    @Autowired
    TestEntityManager TestEntityManager;
    @DisplayName("Test de estudiantes")
    @Test
    void testGuardarEstudiante(){
        Asignatura asignatura = Asignatura
                .builder()
                .nombre("asignatura1")
                .build();

        Estudiante estudiante = Estudiante
                .builder()
                .nombre("estudiante1")
                .cedula(456)
                .email("estudiante1@gmail.com")
                .build();

        Estudiante estudiante1 = repositorioEstudiante.save(estudiante);
        assertThat(estudiante).isNotNull();
        assertThat(estudiante.getCedula()).isGreaterThan(0);
    }
}