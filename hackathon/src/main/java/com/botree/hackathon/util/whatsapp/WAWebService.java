package com.botree.hackathon.util.whatsapp;

import com.botree.hackathon.exception.BadRequestException;
import com.botree.hackathon.exception.ServiceException;
import com.botree.hackathon.exception.UnAuthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * This class is used to send post message.
 * @author Godlin Josheela Rani S
 */
@Service
public class WAWebService {

    /** LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(WAWebService.class);
    /** Whatsapp token. */
    @Value("${wa.token}")
    private String token;

    /** shipmentLoginUrl. */
    @Value("${wa.login.url}")
    private String waAPIUrl;

    /**
     * Method to call post api.
     * @param waSendAPIObject  waSendAPIObject
     */
    public WAResponse sendAPI(final WASendAPIObject waSendAPIObject) {
        ResponseEntity<?> response = null;
        try {
            var restTemplate = new RestTemplate(getClientHttpRequestFactory());
            var uri = new URI(waAPIUrl);
            var headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            var token = getToken();
            LOG.info("token :: {}", token);
            headers.set("Authorization", "Bearer " + token);
            String value = WASendAPIObjectConverter.toJsonString(waSendAPIObject);
            var request = new HttpEntity<>(value, headers);
            response = restTemplate.exchange(uri, HttpMethod.POST, request, WAResponse.class);
            if (response.getBody() != null) {
                var entity = (WAResponse) response.getBody();
                LOG.info("api response :: {} ", entity);
                return entity;
            }
        } catch (Exception e) {
            LOG.error("uri exception :: {}", e.getMessage());
            if (response != null && HttpStatus.BAD_REQUEST.equals(response.getStatusCode())) {
                throw new BadRequestException(e.getMessage());
            } else if (response != null && HttpStatus.UNAUTHORIZED.equals(response.getStatusCode())) {
                throw new UnAuthorizedException(e.getMessage());
            } else if (response != null && HttpStatus.UNPROCESSABLE_ENTITY.equals(response.getStatusCode())) {
                throw new UnAuthorizedException(e.getMessage());
            } else {
                throw new ServiceException(e.getMessage());
            }
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
    private String getToken() throws URISyntaxException {
        return token;
    }
}
