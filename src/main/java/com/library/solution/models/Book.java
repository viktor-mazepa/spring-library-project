package com.library.solution.models;

import com.library.solution.common.Constants;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Book {

    private int id;

    @NotEmpty(message = Constants.TITLE_SHOULDNT_BE_EMPTY_ERROR_MSG)
    @Size(min = 1, max = 200, message = Constants.TITLE_SIZE_ERROR_MSG)
    private String title;

    @NotEmpty(message = Constants.AUTHOR_EMPTY_ERROR_MSG)
    @Size(min = 1, max = 200, message = Constants.AUTHOR_SIZE_ERROR_MSG)
    private String author;

    @NotNull(message = Constants.YEAR_EMPTY_ERROR_MSG)
    @Min(value = 1, message = Constants.YEAR_LESS_ERROR_MSG)
    private int yearOfPublication;

    private Integer personId;

    private Person person;

    public Book() {
    }

    public Book(int id, String title, String author, int yearOfPublication, int personId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.personId = personId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
}
