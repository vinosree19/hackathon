// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.botree.hackathon.model.Converter;
//
// Then you can deserialize a JSON string with
//
//     WASendAPIObject data = Converter.fromJsonString(jsonString);

package com.botree.hackathon.util.whatsapp;

import java.io.IOException;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class WASendAPIObjectConverter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(WASendAPIObjectConverter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(WASendAPIObjectConverter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static WASendAPIObject fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(WASendAPIObject obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    public static WASendAPIObject getWAData(WASendRequest waSendRequest) throws JsonProcessingException {
        WASendAPIObject waSendAPIObject = new WASendAPIObject();
        waSendAPIObject.setMessagingProduct("whatsapp");
        waSendAPIObject.setRecipientType("individual");
        waSendAPIObject.setTo(waSendRequest.getMobileNumber());
        waSendAPIObject.setType("interactive");
        WASendAPIObject.Interactive interactive = new WASendAPIObject.Interactive();
        interactive.setType("button");
        WASendAPIObject.Body body = new WASendAPIObject.Body();
        body.setText(waSendRequest.getMessageContent());
        WASendAPIObject.Action action = new WASendAPIObject.Action();

        WASendAPIObject.Button buttonYes = new WASendAPIObject.Button();
        WASendAPIObject.Reply buttonYesReply = new WASendAPIObject.Reply();
        buttonYesReply.setID("actionyesreply");
        buttonYesReply.setTitle("Accept");
        buttonYes.setReply(buttonYesReply);
        buttonYes.setType("reply");

        WASendAPIObject.Button buttonNo = new WASendAPIObject.Button();
        WASendAPIObject.Reply buttonNoReply = new WASendAPIObject.Reply();
        buttonNoReply.setID("actionnoreply");
        buttonNoReply.setTitle("Reject");
        buttonNo.setReply(buttonNoReply);
        buttonNo.setType("reply");

        WASendAPIObject.Button[] buttons = new WASendAPIObject.Button[2];
        buttons[0] = buttonYes;
        buttons[1] = buttonNo;

        action.setButtons(buttons);

        interactive.setBody(body);
        interactive.setAction(action);
        waSendAPIObject.setInteractive(interactive);
        return waSendAPIObject;
    }
    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return WASendAPIObjectConverter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(WASendAPIObject.class);
        writer = mapper.writerFor(WASendAPIObject.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}
