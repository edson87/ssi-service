package com.dh.sisteseguridad.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BuyOrder extends ModelBase {
    @ManyToOne(optional = false)
    private Inventary inventory;
    private String quantity;
    private Date buyDate;

    public Inventary getInventory() {
        return inventory;
    }

    public void setInventory(Inventary inventory) {
        this.inventory = inventory;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }
}
