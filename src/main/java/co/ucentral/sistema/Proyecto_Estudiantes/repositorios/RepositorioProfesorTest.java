package co.ucentral.sistema.Proyecto_Estudiantes.repositorios;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Asignatura;
import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Profesor;

@DataJpaTest
public class RepositorioProfesorTest {
    
    @Autowired
    RepositorioAsignatura repositorioAsignatura;

    @Autowired
    TestEntityManager TestEntityManager;
    @DisplayName("Test de asignaturas")
    @Test
    void testGuardarAsignatura(){
        Profesor profesor = Profesor
            .builder()
            .nombre("Profesor1")
            .cedula(1234)
            .email("profesor1@gmail.com")
            .build();

        Asignatura asignatura = Asignatura
            .builder()
            .nombre("asignatura1")
            .periodoApertura("02/02/2024")
            .periodoCierre("02/02/2024")
            .profesor(profesor);

        Asignatura asignatura1 = repositorioAsignatura.save(asignatura);
        assertThat(asignatura1).isNotNull();
        assertThat(asignatura1.getCodigo()).isGreaterThan(0);
    }
}
