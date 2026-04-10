package re.exam.dao;

import org.springframework.stereotype.Repository;
import re.exam.model.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDao {
    private List<Book> books;

    public BookDao() {
        books = new ArrayList<>();
        books.add(new Book(1,"sách học lập trình","Huy",300000));
        books.add(new Book(2,"sách học nhảy","Kiên",500000));
        books.add(new Book(3,"sách học vẽ","Ninh",700000));
        books.add(new Book(4,"sách học hát","Hiếu",1000000));
    }
    public List<Book> getBooks() {
        return books;
    }
    public Book findById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

}
