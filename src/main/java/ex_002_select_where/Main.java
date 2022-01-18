package ex_002_select_where;




import ex_002_select_where.entity.Author;

import java.util.List;

/**
 * Created by Asus on 01.11.2017.
 */
public class Main {



    public static void main(String[] args) {
        AuthorHelper ah = new AuthorHelper();

//        Author author1 = new Author();
//        author1.setLastName("Lermontov");
//
//        Author author2 = new Author();
//        author2.setLastName("Pushkin");
//
//        Author author3 = new Author();
//        author3.setLastName("Brushkin");
//
//        ah.addAuthor(author1);
//        ah.addAuthor(author2);
//        ah.addAuthor(author3);

        List<Author> authorList = ah.getAuthorList();

        for (Author author : authorList) {
            System.out.println(author.getId() + " " + author.getName());
        }


    }

}
