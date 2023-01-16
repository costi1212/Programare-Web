package com.viezure.programareWeb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.Set;

@Entity
@SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_ITEM_REVIEW", allocationSize = 1)
public class Category extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

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

    public Set<ItemCategory> getItemCategorySet() {
        return itemCategorySet;
    }

    public void setItemCategorySet(Set<ItemCategory> itemCategorySet) {
        this.itemCategorySet = itemCategorySet;
    }

    @OneToMany(mappedBy = "category")
    private Set <ItemCategory> itemCategorySet;

}
