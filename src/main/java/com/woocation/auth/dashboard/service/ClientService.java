package com.woocation.auth.dashboard.service;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woocation.auth.dashboard.exception.AuthenticationDashboardException;
import com.woocation.auth.dashboard.model.Client;

@Service
public class ClientService {

	private static final String OAUTH_CLIENT_KEY = "oauth_clients:";

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	public Client addClient(Client client)
			throws JsonGenerationException, JsonMappingException, IOException, JSONException {

		String clientTemp = stringRedisTemplate.opsForValue().get(OAUTH_CLIENT_KEY + client.getClient_id());

		String clientStringValue = convertObjectToString(client);
		if (clientTemp == null) {

			stringRedisTemplate.opsForValue().set(OAUTH_CLIENT_KEY + client.getClient_id(), clientStringValue);
		} else {
			throw new AuthenticationDashboardException("Client [" + client.getClient_id() + "] Already exists");
		}

		return convertStringToClient(clientStringValue);
	}

	public Object[] getAllClients() {
		return stringRedisTemplate.keys(OAUTH_CLIENT_KEY + "*").toArray();
	}

	public Client getClient(String clientId)
			throws JsonParseException, com.fasterxml.jackson.databind.JsonMappingException, IOException {
		String client = stringRedisTemplate.opsForValue().get(OAUTH_CLIENT_KEY + clientId);
		if (client == null) {
			throw new AuthenticationDashboardException("No Client [" + clientId + "] exists");
		}
		return convertStringToClient(client);
	}

	public Client updateClient(Client client) throws JsonGenerationException, JsonMappingException, IOException {
		String clientString = stringRedisTemplate.opsForValue().get(OAUTH_CLIENT_KEY + client.getClient_id());

		Client tempClient = convertStringToClient(clientString);
		if (tempClient == null) {
			throw new AuthenticationDashboardException("No Client [" + client.getClient_id() + "] exists for update");
		}

		if (!StringUtils.isEmpty(client.getClient_name())) {
			tempClient.setClient_name(client.getClient_name());
		}
		if (!StringUtils.isEmpty(client.getAccess_token_validity())) {
			tempClient.setAccess_token_validity(client.getAccess_token_validity());
		}
		if (!StringUtils.isEmpty(client.getGrantTypes())) {
			tempClient.setGrantTypes(client.getGrantTypes());
		}
		if (!StringUtils.isEmpty(client.getRedirectUri())) {
			tempClient.setRedirectUri(client.getRedirectUri());
		}
		if (!StringUtils.isEmpty(client.getRefresh_token_validity())) {
			tempClient.setRefresh_token_validity(client.getRefresh_token_validity());
		}
		if (client.getScope() != null && !client.getScope().isEmpty()) {
			tempClient.setScope(client.getScope());
		}
		if (!StringUtils.isEmpty(client.getUserId())) {
			tempClient.setUserId(client.getUserId());
		}

		stringRedisTemplate.opsForValue().set(OAUTH_CLIENT_KEY + tempClient.getClient_id(),
				convertObjectToString(tempClient));

		return tempClient;
	}

	private String convertObjectToString(Client client)
			throws JsonGenerationException, JsonMappingException, IOException {
		org.codehaus.jackson.map.ObjectMapper obejctMapper = new org.codehaus.jackson.map.ObjectMapper();
		return obejctMapper.writeValueAsString(client);
	}

	private Client convertStringToClient(String clientValue)
			throws JsonParseException, com.fasterxml.jackson.databind.JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(clientValue.getBytes(), Client.class);
	}
}
