package com.maciejmaksymiuk.springbootlibrary.repository;

import com.maciejmaksymiuk.springbootlibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
