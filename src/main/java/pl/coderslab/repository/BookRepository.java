package pl.coderslab.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    //DZIEŃ 4======================================================== zad1
    @Query("select b from Book b where b.title=?1")
    List<Book> findByTitle2(String title);
//    metodę wyszukującą książki dla zadanego tytułu.


    @Query("select b from Book b left join fetch b.authors where b.category.name=?1")
//    @Query("select b from Book b where b.category.name=?1")
    List<Book> findByCategory(String category);
//    metodę wyszukującą książki dla zadanej kategorii


//===================== zad2 ===================================

    @Query("select b from Book b where b.rating between ?1 and ?2")
    List<Book> findByRatingRange(int min, int max);
//    Listę książek dla których rating jest pomiędzy zadanymi parametrami np. między 3 a 5.

    @Query("select b from Book b where b.publisher.name = ?1")
    List<Book> findByPublisherName(String publisher);
//    Listę książek dla zadanego wydawcy.
//    Pierwszą książkę z zadanej kategorii, z sortowaniem po tytule.


}
