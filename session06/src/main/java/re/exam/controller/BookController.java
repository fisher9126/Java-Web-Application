package re.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import re.exam.model.Book;
import re.exam.service.BookService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("books")
    public String getBooks(Model model) {
        List<Book> books = new ArrayList<>();
        books = bookService.getBooks();
        System.out.println("books size: " + books.size());
        model.addAttribute("books", books);
        return "books";
    }
    @GetMapping("/books/{id}")
    public String getBooks(
            @PathVariable("id") int id,
            Model model
    ) {

        Book book=bookService.findById(id);
        model.addAttribute("book", book);
                return "book-detail";

    }

}
