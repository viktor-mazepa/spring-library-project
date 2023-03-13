package com.library.solution.models;

import com.library.solution.common.Constants;

import javax.validation.constraints.*;

public class Person {

    private int id;

    @NotEmpty(message = Constants.NAME_EMPTY_ERROR_MSG)
    @Size(min = 2, max = 200, message = Constants.NAME_SIZE_ERROR_MSG)
    private String fullName;

    @NotNull(message = Constants.YEAR_BIRTH_EMPTY_ERROR_MSG)
    @Min(value = 1901, message = Constants.YEAR_BIRTH_LESS_ERROR_MSG)
    private int yearBirth;

    public Person() {
    }

    public Person(int id, String fullName, int yearBirth) {
        this.id = id;
        this.fullName = fullName;
        this.yearBirth = yearBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }
}
