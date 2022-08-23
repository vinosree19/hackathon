package com.botree.hackathon.util.whatsapp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WAResponse {
    private String messagingProduct;
    private Contact[] contacts;
    private Message[] messages;

    @JsonProperty("messaging_product")
    public String getMessagingProduct() { return messagingProduct; }
    @JsonProperty("messaging_product")
    public void setMessagingProduct(String value) { this.messagingProduct = value; }

    @JsonProperty("contacts")
    public Contact[] getContacts() { return contacts; }
    @JsonProperty("contacts")
    public void setContacts(Contact[] value) { this.contacts = value; }

    @JsonProperty("messages")
    public Message[] getMessages() { return messages; }
    @JsonProperty("messages")
    public void setMessages(Message[] value) { this.messages = value; }

    public static class Contact {
        private String input;
        private String waID;

        @JsonProperty("input")
        public String getInput() { return input; }
        @JsonProperty("input")
        public void setInput(String value) { this.input = value; }

        @JsonProperty("wa_id")
        public String getWaID() { return waID; }
        @JsonProperty("wa_id")
        public void setWaID(String value) { this.waID = value; }
    }

    public static class Message {
        private String id;

        @JsonProperty("id")
        public String getID() { return id; }
        @JsonProperty("id")
        public void setID(String value) { this.id = value; }
    }
}
