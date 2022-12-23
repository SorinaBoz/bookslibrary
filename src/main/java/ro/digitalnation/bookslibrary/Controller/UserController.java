package ro.digitalnation.bookslibrary.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.digitalnation.bookslibrary.model.Book;
import ro.digitalnation.bookslibrary.model.User;
import ro.digitalnation.bookslibrary.service.BookService;
import ro.digitalnation.bookslibrary.service.UserService;

import java.util.List;

public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/users")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @GetMapping( "/adduser")
    public String addUser(Model model) {
        model.addAttribute("user", new Book());
        return "adduser";
    }
    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        userService.addUser(user);
        return "redirect:users";
    }
    @RequestMapping(method= RequestMethod.PUT, value="/updateuser/{id}")
    public void updateUser(@RequestBody User user, @PathVariable ("id") int id) {
        userService.updateUser(id, user);
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam int userId) {
        ModelAndView mav = new ModelAndView("adduser");
        User user = userService.getUser(userId);
        userService.updateUser(userId, user);
        mav.addObject("user", user);
        return mav;
    }

    //    @RequestMapping(value = "/deletebutton/{id}")
//    private String deleteBookButton(@PathVariable(name = "book.id") int id){
////        System.out.println("Student_Id : "+id);
//        bookService.deleteBook(id);
//        return "redirect:books";
//    }
    @GetMapping("/deleteUserButton")
    public String deleteUserButton(@RequestParam int userId) {
        userService.deleteUser(userId);
        return "redirect:users";
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/deleteuser/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
