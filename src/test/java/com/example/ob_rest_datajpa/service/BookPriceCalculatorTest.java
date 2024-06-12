package com.example.ob_rest_datajpa.service;

import com.example.ob_rest_datajpa.entites.Book;
import org.junit.jupiter.api.Test;

//sirve para realizar validaciones
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    @Test
    void calculatorPriceTest() {
        //configuracion del test
        Book book = new Book(1L, "El señor de los anillos", "Author", 1000, 30.00, LocalDate.now(), true);
        BookPriceCalculator calculator = new BookPriceCalculator();

        //se ejecuta  el comportamiento a testiar
        double  price = calculator.calculatorPrice(book);
        System.out.println(price);

        //se realiza las comprobaciones

        assertTrue(price>0);
    }
}