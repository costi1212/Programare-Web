package com.viezure.programareWeb.repository;

import com.viezure.programareWeb.model.Item;
import com.viezure.programareWeb.model.ItemReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemReviewRepository extends JpaRepository <ItemReview, Long> {

    List<ItemReview> getAllByItem(Item item);

}
