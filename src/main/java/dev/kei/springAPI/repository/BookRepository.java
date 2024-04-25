package dev.kei.springAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.kei.springAPI.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
