package com.example.ob_rest_datajpa;

import com.example.ob_rest_datajpa.entites.Book;
import com.example.ob_rest_datajpa.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestDatajpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);
		BookRepository repository = context.getBean(BookRepository.class);

		//CRUD
		// crear libro
		Book libro1 = new Book(null,"El Capitán Fush", " Alex Landauro y Rosa María Bedoy\n", 96,
				21.00, LocalDate.of(2014, 12, 20), true);


		Book libro2 = new Book(null,"Dune ", "  Frank Herbert", 704,
				21.00, LocalDate.of(1965, 10, 1), true);
		//almacenar un libro
		System.out.println("El numero de libros en la base de datos son: " + repository.findAll().size());

		repository.save(libro1);
		repository.save(libro2);


		//recuperar todos los libros
		System.out.println("El numero de libros en la base de datos son: " + repository.findAll().size());

		//borrar un libro

		//repository.deleteById(1L);

		System.out.println("El numero de libros en la base de datos son: " + repository.findAll().size());
	}

}
