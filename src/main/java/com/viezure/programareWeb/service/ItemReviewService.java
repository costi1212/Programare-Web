package com.viezure.programareWeb.service;

import com.viezure.programareWeb.exception.item.ItemNotFoundException;
import com.viezure.programareWeb.model.Item;
import com.viezure.programareWeb.model.ItemReview;
import com.viezure.programareWeb.repository.ItemRepository;
import com.viezure.programareWeb.repository.ItemReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ItemReviewService {

    @Autowired
    ItemReviewRepository itemReviewRepository;

    @Autowired
    ItemRepository itemRepository;

    @Value("${item.not.found.exception}")
    String itemNotFoundMessage;

    public ItemReview uploadReview(ItemReview itemReview, Long id){

        Optional<Item> item = itemRepository.findById(id);
        if(item.isPresent()){
            itemReview.setCreatedAt(new Date());
            itemReview.setItem(item.get());
            itemReviewRepository.save(itemReview);
            return itemReview;
        }
        else
            throw new ItemNotFoundException(itemNotFoundMessage);
    }

    public List<ItemReview> getAllByItem(Item item){

        return itemReviewRepository.getAllByItem(item);

    }

}
