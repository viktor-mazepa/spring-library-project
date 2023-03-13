package com.library.solution.controllers;

import com.library.solution.common.Constants;
import com.library.solution.dao.BookDAO;
import com.library.solution.dao.PersonDAO;
import com.library.solution.models.Book;
import com.library.solution.models.Person;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final Logger LOGGER = Logger.getLogger(BooksController.class);

    private PersonDAO personDao;
    private BookDAO bookDAO;

    @Autowired
    public BooksController(PersonDAO personDao, BookDAO bookDAO) {
        this.personDao = personDao;
        this.bookDAO = bookDAO;
    }

    @GetMapping
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookDAO.getAllBooks());
        return "books/books";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "books/new";
    }

    @PostMapping()
    public String createBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/new";
        }
        bookDAO.createBook(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String getBookInfo(@PathVariable("id") int id, Model model, @ModelAttribute("person") Person person) {
        Book book = bookDAO.getBookById(id);
        model.addAttribute(Constants.BOOK_ATTRIBUTE_NAME, book);
        if (book.getPersonId() != null) {
            model.addAttribute(Constants.ASSIGNED_PERSON_ATTRIBUTE_NAME, personDao.getPersonById(book.getPersonId()));
        } else {
            model.addAttribute(Constants.PEOPLE_ATTRIBUTE_NAME, personDao.getAllPeople());
        }
        return "books/info";
    }

    @PatchMapping("/{id}/release")
    public String releaseBook(@PathVariable("id") int id) {
        bookDAO.releaseBook(id);
        return "redirect:/books/" + id;
    }

    @PatchMapping("/{id}/assign")
    public String releaseBook(@PathVariable("id") int id, @ModelAttribute("person") Person selectedPerson) {
        bookDAO.assignBook(id, selectedPerson.getId());
        return "redirect:/books/" + id;
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute(Constants.BOOK_ATTRIBUTE_NAME, bookDAO.getBookById(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult, @PathVariable int id) {
        if (bindingResult.hasErrors()) {
            return "books/edit";
        }
        bookDAO.updateBookById(id, book);
        return "redirect:/books/" + id;
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        bookDAO.deleteBook(id);
        return "redirect:/books";
    }


}
