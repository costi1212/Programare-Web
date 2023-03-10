package com.viezure.programareWeb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Max;
import java.util.Set;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_ITEM", allocationSize = 1)
public class Item extends BaseEntity{

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "available_units")
    private Long availableUnits;

    @Column(name = "price")
    private Float price;

    @Column(name = "discount")
    @Max(100)
    private Float discount;

    @OneToMany(mappedBy = "item")
    @JsonIgnore
    private Set <OrderItem> orderItemSet;

    @OneToMany(mappedBy = "item")
    @JsonIgnore
    private Set <ItemReview> itemReviewSet;

    @OneToMany(mappedBy = "item")
    @JsonIgnore
    private Set <ItemCategory> itemCategorySet;

}
