package com.botree.hackathon.util;

import com.botree.hackathon.exception.ServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPOutputStream;


public final class Function {

    /** LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(Function.class);

    /**
     * Default constructor.
     */
    private Function() {

    }

    /**
     * Method to compress data.
     * @param data data
     * @return compressed data
     */
    public static String compress(final Object data) {
        LOG.info("compress :: ");
        var mapper = new ObjectMapper();
        try (var out = new ByteArrayOutputStream();
             var gzip = new GZIPOutputStream(out)) {
            var osw = new OutputStreamWriter(gzip, StandardCharsets.UTF_8);
            osw.write(mapper.writeValueAsString(data));
            osw.close();
            return Base64.getEncoder().encodeToString(out.toByteArray());
        } catch (IOException e) {
            throw new ServiceException("compress exception ::", e);
        }
    }

    /**
     * This method is used to convert XML to POJO.
     * @param xml  XML string
     * @param type Object type
     * @param <T>  Class Type
     * @return POJO
     */
    public static <T> Object fromXML(final String xml, final Class<T> type) {
        LOG.info("from xml :: ");
        try {
            var reader = new StringReader(xml);
            var jaxbContext = JAXBContext.newInstance(type);
            var unmarshaller = jaxbContext.createUnmarshaller();
            return unmarshaller.unmarshal(reader);
        } catch (Exception e) {
            throw new ServiceException(e);
        }

    }
}
