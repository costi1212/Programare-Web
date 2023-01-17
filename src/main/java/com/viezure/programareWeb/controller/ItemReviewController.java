package com.viezure.programareWeb.controller;

import com.viezure.programareWeb.model.Item;
import com.viezure.programareWeb.model.ItemReview;
import com.viezure.programareWeb.model.Order;
import com.viezure.programareWeb.service.ItemReviewService;
import com.viezure.programareWeb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/order")
public class ItemReviewController {

    @Autowired
    ItemReviewService itemReviewService;

    @Autowired
    ItemService itemService;

    @PostMapping("/uploadReview/{id}")
    public ResponseEntity<ItemReview> uploadReview(@RequestBody ItemReview itemReview, @PathVariable Long id){
        ItemReview createdItemReview = itemReviewService.uploadReview(itemReview, id);
        return new ResponseEntity<>(createdItemReview, HttpStatus.CREATED);
    }

    @GetMapping("/getByItem/{id}")
    public ResponseEntity<List<ItemReview>> getByItem(@PathVariable Long id){

        Item item = itemService.getItem(id);
        List<ItemReview> itemReviewList = itemReviewService.getAllByItem(item);
        return new ResponseEntity<>(itemReviewList, HttpStatus.FOUND);

    }

}
