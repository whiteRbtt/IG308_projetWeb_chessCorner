package com.IG308.chessCorner.dataAccess.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="user")
public class UserEntity {

    // we had to drop camel case for the column names because of the way Hibenate works
    // see https://github.com/spring-projects/spring-boot/issues/2129
    // and https://stackoverflow.com/questions/38948289/java-sql-sqlsyntaxerrorexception-unknown-column-in-field-list

    @Id
    @Column(name="mailaddress")
    private String mailAddress;

    @Column(name="hashedpwd")
    private String hashedPwd;

    @Column(name="phonenumber")
    private String phoneNumber;

    @Column(name="firstname")
    private String firstName;

    @Column(name="lastname")
    private String lastName;

    @Column(name="birthdate")
    private Date birthDate;

    @Column(name="address")
    private String address;

    public UserEntity(){

    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHashedPwd() {
        return hashedPwd;
    }

    public void setHashedPwd(String hashedPwd) {
        this.hashedPwd = hashedPwd;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
