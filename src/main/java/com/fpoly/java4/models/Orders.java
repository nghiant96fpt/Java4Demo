package com.fpoly.java4.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int orderId;

    @Column
    private int status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User users;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
}

//CREATE TABLE [dbo].[Orders] (
//	    [order_id]   INT NOT NULL,
//	    [user_id]    INT NOT NULL,
//	    [address_id] INT NOT NULL,
//	    [status]     INT NOT NULL,
//	    CONSTRAINT [PK_Orders] PRIMARY KEY CLUSTERED ([order_id] ASC),
//	    CONSTRAINT [FK_Orders_address] FOREIGN KEY ([address_id]) REFERENCES [dbo].[address] ([address_id]),
//	    CONSTRAINT [FK_Orders_users] FOREIGN KEY ([user_id]) REFERENCES [dbo].[users] ([user_id])
//	);
//
