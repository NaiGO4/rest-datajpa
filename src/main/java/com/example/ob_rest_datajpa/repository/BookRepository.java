package com.example.ob_rest_datajpa.repository;

import com.example.ob_rest_datajpa.entites.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
