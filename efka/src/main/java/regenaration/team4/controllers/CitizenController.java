package regenaration.team4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import regenaration.team4.entities.Appointment;
import regenaration.team4.service.CitizenService;


@RestController
public class CitizenController {

    @Autowired
    CitizenService citizenService;


    /*ζητάμε απο το api να μας στείλει ένα ραντεβού*/
    @GetMapping("")
    public Appointment getAppointmentById(@PathVariable Integer id) {
        return citizenService.getAppointment_id(id);
    }
    /*
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getById(id);
    }
*/
    /*ζηταμε απο το api να μας δημιουργήσει ραντεβού*/
    @PostMapping("")
    public Appointment createCitizenAppointment() {
        return citizenService.newCitizenAppointment();
    }

    /*
    @PostMapping("/books")
    public Book newBook(@RequestBody Book book) {
        return bookService.newBook(book);
    }
    */


    /*
    public BookController(@Autowired BookService bookService) {
        this.bookService = bookService;
    }
    */

   /* @GetMapping("/books")
    public List<Book> getBooks(@RequestParam(value = "title", required = true) String title) {
        Book book = new Book(1l, "1234", title);
        return Arrays.asList(book);
    }
    */
}
