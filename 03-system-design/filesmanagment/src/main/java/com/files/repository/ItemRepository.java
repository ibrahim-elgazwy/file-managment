package com.files.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.files.domain.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	@Query(value="""
				WITH RECURSIVE items AS (
				  SELECT * 
				    FROM item 
				   WHERE id = ?1 
				UNION ALL 
				  SELECT t.* 
				    FROM item t 
				    JOIN items
				      ON t.parent_item_id = items.id
				) SELECT * FROM items;
			""", nativeQuery=true)
	Optional<List<Item>> findItemStructure(Long itemId);
}
