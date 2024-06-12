package com.example.ob_rest_datajpa.service;

import com.example.ob_rest_datajpa.entites.Book;

public class BookPriceCalculator {

    public double calculatorPrice(Book book){
        double price = book.getPrice();

        //por cantidad de paginas si pasa los 300
        if (book.getPages() > 300){
            price += 5;
        }
        //envio
        price +=2.99;
        return price;
    }
}
