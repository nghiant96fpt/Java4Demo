package com.fpoly.java4.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressBean {
    private String customerName;
    private String phoneNumber;
    private String address;
    private String userId;
}
