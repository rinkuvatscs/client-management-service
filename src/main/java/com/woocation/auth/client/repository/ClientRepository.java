package com.woocation.auth.dashboard.repository;

import org.springframework.data.repository.CrudRepository;

import com.woocation.auth.dashboard.model.Client;

public interface ClientRepository extends CrudRepository<Client, String> {

	
}
