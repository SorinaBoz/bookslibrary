package ro.digitalnation.bookslibrary.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.digitalnation.bookslibrary.model.Book;
import ro.digitalnation.bookslibrary.service.BookService;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/index")
    public String showHomePage(){
        return "index";
    }

    @RequestMapping("/books")
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @RequestMapping("/books/{id}")
    public Book getBook(@PathVariable int id) {
        return bookService.getBook(id);
    }
//    @PostMapping("/addbook")
//    private int createBook(@RequestBody Book book)
//    {
//        bookService.addBook(book);
//        return book.getId();
//    }

    @GetMapping( "/addbook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }
    @PostMapping("/createBook")
    public String createBook(@ModelAttribute Book book, Model model) {
        model.addAttribute("book", book);
        bookService.addBook(book);
        return "redirect:books";
    }
    @RequestMapping(method= RequestMethod.PUT, value="/updatebook/{id}")
    public void updateBook(@RequestBody Book book, @PathVariable ("id") int id) {
        bookService.updateBook(id, book);
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam int bookId) {
        ModelAndView mav = new ModelAndView("addbook");
        Book book = bookService.getBook(bookId);
        bookService.updateBook(bookId, book);
        mav.addObject("book", book);
        return mav;
    }

//    @RequestMapping(value = "/deletebutton/{id}")
//    private String deleteBookButton(@PathVariable(name = "book.id") int id){
////        System.out.println("Student_Id : "+id);
//        bookService.deleteBook(id);
//        return "redirect:books";
//    }
@GetMapping("/deleteBookButton")
public String deleteBookButton(@RequestParam int bookId) {
    bookService.deleteBook(bookId);
    return "redirect:/books";
}
    @RequestMapping(method=RequestMethod.DELETE, value="/deletebook/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }
}
