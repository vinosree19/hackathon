package com.botree.hackathon.service;

import com.botree.hackathon.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * This class is used to send post message.
 * @author vinodkumar.a
 */
@Service
public class ApiWebService {

    /** LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(ApiWebService.class);
    /** shipmentUsername. */
    @Value("${shipment.username}")
    private String shipmentUsername;
    /** shipmentPassword. */
    @Value("${shipment.password}")
    private String shipmentPassword;
    /** shipmentLoginUrl. */
    @Value("${shipment.login.url}")
    private String shipmentLoginUrl;

    /**
     * Method to call post api.
     * @param obj obj
     * @throws URISyntaxException URISyntaxException
     */
    public void sendPostAPI(final Object obj, final String url) throws URISyntaxException {
        var restTemplate = new RestTemplate(getClientHttpRequestFactory());
        var uri = new URI(url);
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        var token = login();
        LOG.info("token :: {}", token);
        headers.set("Authorization", "Bearer " + token);
        var request = new HttpEntity<>(obj, headers);
        ResponseEntity<?> response = restTemplate.exchange(uri, HttpMethod.POST, request, Object.class);
        if (response.getBody() != null) {
            var entity = response.getBody();
            LOG.info("post api response :: {} ", entity);
        }
    }

    public Object sendPostAPIReturnResponse(final Object obj, final String url) throws URISyntaxException {
        var restTemplate = new RestTemplate(getClientHttpRequestFactory());
        var uri = new URI(url);
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        var token = login();
        LOG.info("token :: {}", token);
        headers.set("Authorization", "Bearer " + token);
        var request = new HttpEntity<>(obj, headers);
        ResponseEntity<?> response = restTemplate.exchange(uri, HttpMethod.POST, request, Object.class);
        if (response.getBody() != null) {
            var entity = response.getBody();
            LOG.info("post api response :: {} ", entity);
            return entity;
        }
        return null;
    }

    public Object getGetAPI(final String url) throws URISyntaxException {
        var restTemplate = new RestTemplate(getClientHttpRequestFactory());
        var uri = new URI(url);
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        var token = login();
        LOG.info("token :: {}", token);
        headers.set("Authorization", "Bearer " + token);
        var request = new HttpEntity<>(headers);
        ResponseEntity<?> response = restTemplate.exchange(uri, HttpMethod.GET, request, Object.class);
        if (response.getBody() != null) {
            var entity = response.getBody();
            LOG.info("post api response :: {} ", entity);
            return entity;
        }
        return null;
    }

    /**
     * This method is used to configure the http timeout.
     * @return ClientHttpRequestFactory
     */
    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        var smsTimeout = 0;
        var smsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        smsClientHttpRequestFactory.setConnectTimeout(smsTimeout);
        return smsClientHttpRequestFactory;
    }

    /**
     * Method to login the shipment api.
     * @return token
     * @throws URISyntaxException URISyntaxException
     */
    private String login() throws URISyntaxException {
        var restTemplate = new RestTemplate(getClientHttpRequestFactory());
        var uri = new URI(shipmentLoginUrl);
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        var user = new UserModel();
        user.setEmail(shipmentUsername);
        user.setPassword(shipmentPassword);
        var request = new HttpEntity<>(user, headers);
        ResponseEntity<?> response = restTemplate.exchange(uri, HttpMethod.POST, request, UserModel.class);
        if (response.getBody() != null) {
            var model = (UserModel) response.getBody();
            return model.getToken();
        }
        return null;
    }
}
