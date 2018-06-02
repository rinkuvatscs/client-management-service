package com.woocation.auth.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.woocation.auth.dashboard.exception.AuthenticationDashboardException;
import com.woocation.auth.dashboard.model.Client;
import com.woocation.auth.dashboard.service.ClientService;

@RestController
@RequestMapping(value = "/clients/v1")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Client addClient(@RequestBody Client client) {
		return clientService.addClient(client);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public Client updateClient(@RequestBody Client client) {
		return clientService.updateClient(client);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public Object[] getClients() {
		Object[] objectArray = clientService.getAllClients();
		if (objectArray != null && objectArray.length > 0) {
			return objectArray;
		}
		throw new AuthenticationDashboardException("No Client exists");
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Client getClient(@RequestParam String clientId) {
		return clientService.getClient(clientId);
	}
}
