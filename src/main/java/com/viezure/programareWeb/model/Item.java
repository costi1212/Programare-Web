package com.viezure.programareWeb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.Set;

@Entity
@SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_ITEM", allocationSize = 1)
public class Item extends BaseEntity{

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "available_units")
    private String availableUnits;

    @Column(name = "price")
    private Float price;

    @OneToMany(mappedBy = "item")
    private Set <OrderItem> orderItemSet;

    @OneToMany(mappedBy = "item")
    private Set <ItemReview> itemReviewSet;

    @OneToMany(mappedBy = "item")
    private Set <ItemCategory> itemCategorySet;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvailableUnits() {
        return availableUnits;
    }

    public void setAvailableUnits(String availableUnits) {
        this.availableUnits = availableUnits;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Set<OrderItem> getOrderItemSet() {
        return orderItemSet;
    }

    public void setOrderItemSet(Set<OrderItem> orderItemSet) {
        this.orderItemSet = orderItemSet;
    }

    public Set<ItemReview> getItemReviewSet() {
        return itemReviewSet;
    }

    public void setItemReviewSet(Set<ItemReview> itemReviewSet) {
        this.itemReviewSet = itemReviewSet;
    }
}
