package re.exam.service;

import org.springframework.stereotype.Service;
import re.exam.dao.BookDao;
import re.exam.model.Book;

import java.util.List;
@Service
public class BookService {
    private BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    public List<Book> getBooks() {
        return bookDao.getBooks();
    }
    public Book findById(int id) {
        return bookDao.findById(id);
    }
}
