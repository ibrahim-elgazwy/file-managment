package com.files.rest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.files.rest.request.ItemRequest;
import com.files.rest.response.ItemResponse;
import com.files.service.ItemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

	private final ItemService itemService;
	
	@PostMapping()
	public ResponseEntity<ItemResponse> createItem(@RequestBody ItemRequest itemRequest) throws Exception {
		
		return ResponseEntity.ok(itemService.create(itemRequest));
	}
	
	@GetMapping("/{itemId}")
	public ResponseEntity<List<ItemResponse>> findItemStructure(@PathVariable Long itemId) throws Exception {
		
		return ResponseEntity.ok(itemService.findItemStructure(itemId));
	}
}
