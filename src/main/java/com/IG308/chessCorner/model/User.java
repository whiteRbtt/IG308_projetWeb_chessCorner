package com.IG308.chessCorner.model;

import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.*;
// import java.util.Collection;
import java.util.Date;

public class User{

    @NotNull
    @Size(max=50)
    @Pattern(regexp="\\w+@\\w+\\.\\w+")
    private String username;

    @NotNull
    @Size(min=6, max=40)
    private String password;

    @Size(max=20)
    private String phoneNumber;

    @NotNull
    @Size(max=40)
    @Pattern(regexp="[a-zA-Z]*")
    private String firstName;

    @NotNull
    @Size(max=40)
    @Pattern(regexp="[a-zA-Z]*")
    private String lastName;

    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthDate;

    @NotNull
    @Size(max=100)
    private String address;

    public User() {
    }

    public User(String username, String password, String phoneNumber, String firstName, String lastName, Date birthDate, String address) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }


    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setBirthDate(Date birthDate){
        this.birthDate = birthDate;
    }

    public Date getBirthDate(){
        return birthDate;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }

    // TOREMOVE
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                '}';
    }
}
