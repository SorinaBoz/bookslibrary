package ro.digitalnation.bookslibrary.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.digitalnation.bookslibrary.model.Loan;
import ro.digitalnation.bookslibrary.service.LoanService;

import java.util.List;

@Controller
public class LoanController {
@Autowired
    private LoanService loanService;
    @RequestMapping("/loans")
    public String getAllLoans(Model model) {
        List<Loan> loans = loanService.getAllLoans();
        model.addAttribute("loans", loans);
        return "loans";
    }

    @RequestMapping("/loans/{id}")
    public Loan getLoan(@PathVariable int id) {
        return loanService.getLoan(id);
    }
//    @PostMapping("/addbook")
//    private int createBook(@RequestBody Book book)
//    {
//        bookService.addBook(book);
//        return book.getId();
//    }

    @GetMapping( "/addloan")
    public String addLoan(Model model) {
        model.addAttribute("loan", new Loan());
        return "addloan";
    }
    @PostMapping("/createLoan")
    public String createLoan(@ModelAttribute Loan loan, Model model) {
        model.addAttribute("loan", loan);
        loanService.addLoan(loan);
        return "redirect:loans";
    }
    @RequestMapping(method= RequestMethod.PUT, value="/updateloan/{id}")
    public void updateLoan(@RequestBody Loan loan, @PathVariable ("id") int id) {
        loanService.updateLoan(id, loan);
    }

//    @GetMapping("/showUpdateForm")
//    public ModelAndView showUpdateForm(@RequestParam int loanId) {
//        ModelAndView mav = new ModelAndView("addloan");
//        Loan loan = loanService.getLoan(loanId);
//        loanService.updateLoan(loanId, loan);
//        mav.addObject("loan", loan);
//        return mav;
//    }

    //    @RequestMapping(value = "/deletebutton/{id}")
//    private String deleteBookButton(@PathVariable(name = "book.id") int id){
////        System.out.println("Student_Id : "+id);
//        bookService.deleteBook(id);
//        return "redirect:books";
//    }
    @GetMapping("/deleteLoanButton")
    public String deleteLoanButton(@RequestParam int loanId) {
        loanService.deleteLoan(loanId);
        return "redirect:/loans";
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/deleteloan/{id}")
    public void deleteLoan(@PathVariable int id) {
        loanService.deleteLoan(id);
    }
}
