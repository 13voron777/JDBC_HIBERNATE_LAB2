package ex_004_relations;


import ex_004_relations.entity.Author;
import ex_004_relations.entity.Book;
import org.jboss.logging.Logger;

import java.util.List;

/**
 * Created by Asus on 01.11.2017.
 */
public class Main {


    public static void main(String[] args) {

        BookHelper bh = new BookHelper();
        List<Book> authorBooks = bh.getBookList();

//        Author author = new AuthorHelper().getAuthorById(1);
//        List<Book> authorBooks = author.getBooks();

        for (Book book : authorBooks) {
            System.out.println(book.getName() + " " + book.getAuthor().getName()
                    + " " + book.getAuthor().getLastName());
        }

    }

}
