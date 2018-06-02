package com.woocation.auth.client.repository;

import org.springframework.data.repository.CrudRepository;

import com.woocation.auth.client.model.Client;

public interface ClientRepository extends CrudRepository<Client, String> {

	
}
