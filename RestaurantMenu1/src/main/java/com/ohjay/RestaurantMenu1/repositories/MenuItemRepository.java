package com.ohjay.RestaurantMenu1.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ohjay.RestaurantMenu1.models.MenuItem;


@Repository
public interface MenuItemRepository extends CrudRepository<MenuItem, Long> {

}
