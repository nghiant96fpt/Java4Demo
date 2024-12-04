package com.fpoly.java4.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserBean {
    private int id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String address;
}
