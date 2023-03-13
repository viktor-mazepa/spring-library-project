package com.library.solution.dao;

import com.library.solution.common.Constants;
import com.library.solution.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Collection<Book> getBookAssignedToPerson(int personId) {
        return jdbcTemplate.query(Constants.GET_ALL_BOOKS_ASSIGNED_TO_PERSON_SQL, new Object[]{personId}, new BeanPropertyRowMapper<>(Book.class));
    }

    public Collection<Book> getAllBooks() {
        return jdbcTemplate.query(Constants.GET_ALL_BOOKS_SQL, new BeanPropertyRowMapper<>(Book.class));
    }

    public void createBook(Book book) {
        jdbcTemplate.update(Constants.ADD_NEW_BOOK_TO_TABLE_SQL, book.getTitle(), book.getAuthor(), book.getYearOfPublication());
    }

    public Book getBookById(int id) {
        return jdbcTemplate.query(Constants.GET_BOOK_BY_ID_SQL, new Object[]{id}, new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public void updateBookById(int id, Book book) {
        jdbcTemplate.update(Constants.UPDATE_BOOK_BY_ID_SQL, book.getTitle(), book.getAuthor(), book.getYearOfPublication(), id);
    }

    public void deleteBook(int id) {
        jdbcTemplate.update(Constants.DELETE_BOOK_BY_ID_SQL, id);
    }

    public void changeBookAssignment(int bookId, int personId) {
        jdbcTemplate.update(Constants.CHANGE_BOOK_ASSIGNMENT_SQL, personId, bookId);
    }

    public void releaseBook(int id) {
        jdbcTemplate.update(Constants.CHANGE_BOOK_ASSIGNMENT_SQL, null, id);
    }

    public void assignBook(int bookId, int personId) {
        jdbcTemplate.update(Constants.CHANGE_BOOK_ASSIGNMENT_SQL, personId, bookId);
    }

}
