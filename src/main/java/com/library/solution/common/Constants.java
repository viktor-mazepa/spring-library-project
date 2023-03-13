package com.library.solution.common;

public interface Constants {

    String GET_ALL_PEOPLE_SQL = "SELECT * FROM PERSON";
    String ADD_PERSON_TO_TABLE_SQL = "INSERT INTO PERSON (fullname, year_birth) VALUES (?,?)";
    String GET_PERSON_BY_FULLNAME_SQL = "SELECT * FROM PERSON WHERE fullname=?";
    String GET_PERSON_BY_ID_SQL = "SELECT * FROM PERSON WHERE id =?";
    String UPDATE_PERSON_BY_ID_SQL = "update person set fullname=?, year_birth=? where id = ?";
    String DELETE_PERSON_BY_ID_SQL = "delete from person where id = ?";


    String GET_ALL_BOOKS_ASSIGNED_TO_PERSON_SQL = "select * from book where person_id = ?";
    String GET_ALL_BOOKS_SQL = "select * from book";
    String ADD_NEW_BOOK_TO_TABLE_SQL = "insert into book (title, author,year_of_publication) values (?,?,?)";
    String GET_BOOK_BY_ID_SQL = "select * from book where id = ?";
    String UPDATE_BOOK_BY_ID_SQL = "update book set title=?, author=?, year_of_publication=? where id = ?";
    String DELETE_BOOK_BY_ID_SQL = "delete from book where id = ?";
    String CHANGE_BOOK_ASSIGNMENT_SQL = "update book set person_id=? where id = ?";

    String BOOK_ATTRIBUTE_NAME="book";
    String BOOKZ_ATTRIBUTE_NAME="books";
    String PEOPLE_ATTRIBUTE_NAME="people";
    String PERSON_ATTRIBUTE_NAME="person";
    String ASSIGNED_PERSON_ATTRIBUTE_NAME="assignedPerson";


    String TITLE_SHOULDNT_BE_EMPTY_ERROR_MSG = "Название не может быть пустым";
    String TITLE_SIZE_ERROR_MSG="Название книги должно быть не меньше 1 симовола и не больше 200";
    String AUTHOR_EMPTY_ERROR_MSG="ФИО атора не может быть пустым";
    String AUTHOR_SIZE_ERROR_MSG="ФИО автора книги должно быть не меньше 1 симовола и не больше 200";
    String YEAR_EMPTY_ERROR_MSG="Год публикации не может быть пустым";
    String YEAR_LESS_ERROR_MSG="Год публикации должен быть больше 0. Это не музей!";

    String NAME_EMPTY_ERROR_MSG="ФИО читателя не может быть пустым";
    String NAME_SIZE_ERROR_MSG="ФИО должно быть не меньше 10 симоволов и не больше 200";
    String YEAR_BIRTH_EMPTY_ERROR_MSG ="Год рождения не может быть пустым";
    String YEAR_BIRTH_LESS_ERROR_MSG="Год рождения должен быть больше чем 1900";

}
