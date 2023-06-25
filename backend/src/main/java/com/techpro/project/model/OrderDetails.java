package com.techpro.project.model;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


//OrderDetails ENTITY WITH SETTERS AND GETTERS
@Table(name = "order_details")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "OrderDetailsID")
    private int orderDetailsId;

    @Column(name = "Quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "OrderID")
    private Orders orderId;

    @ManyToOne
    @JoinColumn(name = "ItemID")
    private Items itemId;

    public int getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(int orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Orders getOrderId() {
        return orderId;
    }

    public void setOrderId(Orders orderId) {
        this.orderId = orderId;
    }

    public Items getItemId() {
        return itemId;
    }

    public void setItemId(Items itemId) {
        this.itemId = itemId;
    }
}
