package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.books.Author;
import pl.coderslab.books.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String title);

    List<Book> findByCategoryName(String name);

    //    metodę wyszukującą książki dla zadanego id kategorii
    List<Book> findByCategoryId(Long categoryId);

//======================ZAD2=====================================

//    Listę książek dla zadanego autora.
    List<Book> findByAuthorsContaining(Author authors);

//    Listę książek dla zadanego wydawcy
//    Listę książek dla określonego ratingu
//    Pierwszą książkę z zadanej kategorii, z sortowaniem po tytule.

}
