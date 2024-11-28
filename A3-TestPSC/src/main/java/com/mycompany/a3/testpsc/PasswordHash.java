/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.a3.testpsc;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author layon
 */
public class PasswordHash {

    public String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encoding = digest.digest(password.getBytes());
            return bytesToHex(encoding);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao criar hash" + e.getMessage());
        }
    }

    public static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }

            hexString.append(hex);
        }
        return hexString.toString();
    }
}
