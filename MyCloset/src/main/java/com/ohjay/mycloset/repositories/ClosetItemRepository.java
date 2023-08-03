package com.ohjay.mycloset.repositories;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.ohjay.mycloset.models.ClosetItem;

@Repository

public interface ClosetItemRepository extends CrudRepository<ClosetItem, Long>{ 
//we inherited a bunch of CRUD methods that translate to sql queries under the hood from the CrudRepository<> Interface
}


