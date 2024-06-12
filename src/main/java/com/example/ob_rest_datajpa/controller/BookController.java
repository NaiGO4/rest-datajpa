package com.example.ob_rest_datajpa.controller;

import com.example.ob_rest_datajpa.entites.Book;
import com.example.ob_rest_datajpa.repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class);

    //atributo
    private BookRepository bookRepository;

    //constructor
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }



    //CRUD sobre la entidad book
    //GET
    //Buscar todos los libros (lista de libros)
    @GetMapping("/api/books")
    @Operation(description = "Buscar todos los libros")
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    //Buscar un libro en la base de datos
    @GetMapping("/api/books/{id}")
    @Operation(description = "Buscar un libro por id long")
    public ResponseEntity<Object> findOneById(@Parameter(description = "Clave primaria tipo Long") @PathVariable Long id){
        Optional<Book> bookOpt = bookRepository.findById(id);


        //opcion 1
        if (bookOpt.isPresent()){
            return ResponseEntity.ok(bookOpt.get());
        }else {
            return ResponseEntity.notFound().build();
        }

        //opcion 2
       // return bookOpt.orElse(null);
    }

    /*
    POST
    no coliciona ya que nos dos diferente uno es GET y el otro es POST
    crear un libro en base la base de datos

    */
    @PostMapping("/api/books")
    @Operation(description = "Crear un libro ")
    public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        if (book.getId() !=null){
            //manejo de error
            log.warn("trying to create a book with id");
            System.out.println("trying to create a book with id");;
            return ResponseEntity.badRequest().build();
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result); //con save se genera el libro y se muestro con ID
    }


    //Actulizar un libro en la base de datos
    @PutMapping("/api/books")
    @Operation(description = "Actulizar libro")
    public ResponseEntity<Book> update(@RequestBody Book book){
        if(book.getId() ==null){ //si no tiene id quiere decir que si es una creacion
            log.warn("trying to update a non existent book");
            return ResponseEntity.badRequest().build();
        }
        if (!bookRepository.existsById(book.getId())){
            log.warn("trying to update a non existent book");
            return ResponseEntity.notFound().build();
        }

        Book result =  bookRepository.save(book);
        return ResponseEntity.ok(result);
    }


    //Borrar un libro en la base de datos
    @DeleteMapping("/api/books/{id}")
    @Operation(description = "Borra un libro con ID")
    public ResponseEntity<Book> delete(@PathVariable Long id){
        if (!bookRepository.existsById(id)){
            log.warn("trying to delete a non existent book");
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //Borrar todas los libros
    @DeleteMapping("/api/books")
    @Operation(description = "Borra todos los libros")
    public ResponseEntity<Book> deleleAll(){
        log.info("Rest Request for delete all books");
        bookRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
