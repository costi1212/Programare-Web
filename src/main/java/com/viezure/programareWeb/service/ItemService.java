package com.viezure.programareWeb.service;

import com.viezure.programareWeb.model.Item;
import com.viezure.programareWeb.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Item createItem(Item item){

        itemRepository.save(item);
        return item;

    }

}
