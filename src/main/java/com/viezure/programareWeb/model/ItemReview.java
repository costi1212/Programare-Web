package com.viezure.programareWeb.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_ITEM_REVIEW", allocationSize = 1)
public class ItemReview extends BaseEntity {

    @Column(name = "title")
    @NotBlank
    private String title;

    @Column(name = "rating")
    @Min(value = 1)
    @Max(value = 10)
    private Float rating;

    @Column(name = "content")
    private String content;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
