package com.viezure.programareWeb.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order_item")
@SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_Order_Item", allocationSize = 1)
public class OrderItem extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    public Order order;

    @Column(name = "quantity")
    @Min(value = 1)
    private Long quantity;

    @Column(name = "price")
    private Float price;


    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

}
