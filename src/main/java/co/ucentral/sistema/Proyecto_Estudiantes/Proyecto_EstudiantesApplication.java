package co.ucentral.sistema.Proyecto_Estudiantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.ucentral.sistema.Proyecto_Estudiantes.repositorios.RepositorioProfesor;

@SpringBootApplication
public class Proyecto_EstudiantesApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Proyecto_EstudiantesApplication.class, args);
	}


	@Autowired
	private RepositorioProfesor repositorioProfesor;

	@Override
	public void run(String... args) throws Exception {
		/*Profesor prof1 = new Profesor(123L, "pepe", "pepe@gmail.com");
		repositorioProfesor.save(prof1);

		Profesor prof2 = new Profesor(456L, "luis", "luis@gmail.com");
		repositorioProfesor.save(prof2);*/
	}

	
}
