package com.botree.hackathon.util;

import com.botree.hackathon.service.ApiWebService;
import org.apache.commons.logging.Log;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;
import java.util.HashMap;

public interface DataInstance {
    Logger LOG = LoggerFactory.getLogger(ApiWebService.class);
    HashMap<String, String> applicationData =  new HashMap<>();


    default void setApplicationData(String key, String value){
        applicationData.put(key, value);
    }

    default String getApplicationData(String key){
        if (validateToken(key)) {
            return applicationData.get(key);
        }
        return "";
    }

    default boolean validateToken(String key){
        if (applicationData.containsKey(key)) {
            String[] chunks = applicationData.get(key).split("\\.");
            Base64.Decoder decoder = Base64.getUrlDecoder();
            String header = new String(decoder.decode(chunks[0]));
            String payload = new String(decoder.decode(chunks[1]));
            JSONObject jsonObject = new JSONObject(payload);
            var exp = (long)jsonObject.getLong("exp");
            if (exp > System.currentTimeMillis()){
                return false;
            }
            LOG.debug("Token Header " + header);
            LOG.debug("Token payload " + payload);
            return true;
        }
        return false;
    }

}
