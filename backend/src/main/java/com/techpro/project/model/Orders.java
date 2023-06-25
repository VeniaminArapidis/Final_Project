package com.techpro.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


//Orders ENTITY WITH SETTERS AND GETTERS


@JsonIgnoreProperties({"orderDetails"})
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "OrderID")
    private int orderId;

    @CreationTimestamp
    @Column (name = "OrderDate")
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "PersonID")
    private People email;
    @OneToMany(mappedBy = "orderId", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails;



    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public People getEmail() {
        return email;
    }


    public void setEmail(People email) {
        this.email = email;
    }

    public void setOrderDate(String date) {
    }
}
