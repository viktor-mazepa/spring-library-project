package com.library.solution.dao;

import com.library.solution.common.Constants;
import com.library.solution.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Collection<Person> getAllPeople() {
        return jdbcTemplate.query(Constants.GET_ALL_PEOPLE_SQL, new BeanPropertyRowMapper<>(Person.class));
    }

    public void createPerson(Person person) {
        jdbcTemplate.update(Constants.ADD_PERSON_TO_TABLE_SQL, person.getFullName(), person.getYearBirth());
    }

    public Optional<Person> getAnyPersonByName(String fullName) {
        return jdbcTemplate.query(Constants.GET_PERSON_BY_FULLNAME_SQL, new Object[]{fullName}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public Person getPersonById(int id) {
        return jdbcTemplate.query(Constants.GET_PERSON_BY_ID_SQL, new Object[]{id}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void updatePerson(int id, Person person) {
        jdbcTemplate.update(Constants.UPDATE_PERSON_BY_ID_SQL, person.getFullName(), person.getYearBirth(), id);
    }

    public void deletePerson(int id) {
        jdbcTemplate.update(Constants.DELETE_PERSON_BY_ID_SQL, id);
    }
}
