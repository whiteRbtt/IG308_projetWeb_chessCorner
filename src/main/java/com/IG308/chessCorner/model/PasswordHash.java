package com.IG308.chessCorner.model;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHash {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("mustprotectchilds55"));
    }
}
