package com.IG308.chessCorner.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Date;

public class User implements UserDetails{

    @NotNull
    @Size(max=50)
    @Pattern(regexp="\\w+@\\w+\\.\\w+")
    private String username;

    @NotNull
    @Size(min=6, max=40)
    private String password;

    @Size(max=20)
    @Pattern(regexp="[0-9]*")
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

    private String authorities = "ROLE_USER";

    private boolean accountNonExpired = true;

    private boolean accountNonLocked = true;

    private boolean credentialsNonExpired = true;

    private boolean enabled = true;


    public User() {
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            this.phoneNumber = null;
        } else {
            this.phoneNumber = phoneNumber;
        }
    }


    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }


    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }


    public Date getBirthDate(){
        return birthDate;
    }

    public void setBirthDate(Date birthDate){
        this.birthDate = birthDate;
    }


    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return null; }

    public String getRole() { return authorities; }

    public void setAuthorities(String authorities){
        this.authorities = authorities;
    }


    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }


    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }


    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired){
        this.accountNonExpired = accountNonExpired;
    }


    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked){
        this.accountNonLocked = accountNonLocked;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired){ this.credentialsNonExpired = credentialsNonExpired; }


    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }


    @Override
    public boolean equals(Object user) {
        if (user instanceof User) {
            return username.equals(((User) user).getUsername())
                    && password.equals(((User) user).getPassword())
                    && phoneNumber.equals(((User) user).getPhoneNumber())
                    && firstName.equals(((User) user).getFirstName())
                    && lastName.equals(((User) user).getLastName())
                    && birthDate.equals(((User) user).getBirthDate())
                    && address.equals(((User) user).getAddress());
        }
        return false;
    }

}
