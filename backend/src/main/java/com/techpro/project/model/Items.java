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

//ITEM ENTITY WITH SETTERS AND GETTERS
@Table(name = "items")
public class Items {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ItemID")
    private int itemId;


    @Column(name = "Name")
    private String itemName;


    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
