package com.dilankag.spring.sbw.modules.user;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import com.dilankag.spring.sbw.utils.AccessToken;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * UserService
 * 
 * curl \
  -d "client_id=spring-boot-api" \
  -d "username=dilanka" \
  -d "password=abc123" \
  -d "grant_type=password" \
  "http://localhost:8080/auth/realms/dilankag_reactive_program/protocol/openid-connect/token"
 * 
 */
@Slf4j
@Service
public class UserService {

    @PostConstruct
    public AccessToken getUserAccessToken() throws Exception {
        RestTemplate template = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Accept", "application/json");
        headers.set("Accept-Encoding", "gzip, deflate, br");

        MultiValueMap<String, String> objectMap = new LinkedMultiValueMap<String, String>();
        objectMap.put("username", Arrays.asList("dilanka"));
        objectMap.put("password", Arrays.asList("abc123"));
        objectMap.put("grant_type", Arrays.asList("password"));
        objectMap.put("client_id", Arrays.asList("spring-boot-api"));

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(objectMap,
                headers);

        ResponseEntity<AccessToken> token = null;

        try {
            token = template.postForEntity(
                    "http://localhost:8080/auth/realms/dilankag_reactive_program/protocol/openid-connect/token", request,
                    AccessToken.class);
           // log.info("Access token issued for user : {}", token.getBody().getAccess_token());
        } catch (Exception e) {
            e.printStackTrace();
            // throw new TokenNotFoundException();
        }

        return token == null ? new AccessToken() : token.getBody();
    }// getUserAccessToken()
}