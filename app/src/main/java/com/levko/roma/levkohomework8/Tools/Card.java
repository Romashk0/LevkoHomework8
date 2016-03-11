package com.levko.roma.levkohomework8.Tools;

import java.io.Serializable;

/**
 * Created by User on 09.03.2016.
 */
public class Card implements Serializable {

    private String firstName;
    private String lastName;
    private String gender;
    private String age;
    private String phoneNumber;

    public Card(String firstName, String lastName, String gender, String age, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getGender() {
        return gender;
    }


    public String getAge() {
        return age;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public boolean isAllFieldsNotEmpty() {
        return
                        firstName.isEmpty() ||
                        lastName.isEmpty() ||
                        gender.isEmpty() ||
                        age.isEmpty() ||
                        phoneNumber.isEmpty();
    }
}

