package com.viezure.programareWeb.controller;

import com.viezure.programareWeb.model.Item;
import com.viezure.programareWeb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping("/create")
    public ResponseEntity <Item> createItem(@RequestBody Item item){

        return new ResponseEntity<>(itemService.createItem(item), HttpStatus.CREATED);

    }

}
