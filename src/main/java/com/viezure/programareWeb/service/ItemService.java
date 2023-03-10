package com.viezure.programareWeb.service;

import com.viezure.programareWeb.exception.item.ItemNotFoundException;
import com.viezure.programareWeb.model.Item;
import com.viezure.programareWeb.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Value("${item.not.found.exception}")
    String itemNotFoundMessage;

    public Item createItem(Item item){

        itemRepository.save(item);
        return item;

    }

    public Item getItem(Long id){
        Optional<Item> item = itemRepository.findById(id);
        if(item.isPresent()){
            return item.get();
        }
        else
            throw new ItemNotFoundException(itemNotFoundMessage);

    }

}
