package com.botree.hackathon.util.whatsapp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WASendAPIObject {
    private String messagingProduct;
    private String recipientType;
    private String to;
    private String type;
    private Interactive interactive;

    @JsonProperty("messaging_product")
    public String getMessagingProduct() {
        return messagingProduct;
    }

    @JsonProperty("messaging_product")
    public void setMessagingProduct(String value) {
        this.messagingProduct = value;
    }

    @JsonProperty("recipient_type")
    public String getRecipientType() {
        return recipientType;
    }

    @JsonProperty("recipient_type")
    public void setRecipientType(String value) {
        this.recipientType = value;
    }

    @JsonProperty("to")
    public String getTo() {
        return to;
    }

    @JsonProperty("to")
    public void setTo(String value) {
        this.to = value;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String value) {
        this.type = value;
    }

    @JsonProperty("interactive")
    public Interactive getInteractive() {
        return interactive;
    }

    @JsonProperty("interactive")
    public void setInteractive(Interactive value) {
        this.interactive = value;
    }

    public static class Interactive {
        private String type;
        //private Header header;
        private Body body;
        //private Body footer;
        private Action action;

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String value) {
            this.type = value;
        }

        @JsonProperty("body")
        public Body getBody() {
            return body;
        }

        @JsonProperty("body")
        public void setBody(Body value) {
            this.body = value;
        }

        @JsonProperty("action")
        public Action getAction() {
            return action;
        }

        @JsonProperty("action")
        public void setAction(Action value) {
            this.action = value;
        }
    }

    public static class Action {
        private Button[] buttons;

        @JsonProperty("buttons")
        public Button[] getButtons() { return buttons; }
        @JsonProperty("buttons")
        public void setButtons(Button[] value) { this.buttons = value; }
    }

    public static class Body {
        private String text;

        @JsonProperty("text")
        public String getText() {
            return text;
        }

        @JsonProperty("text")
        public void setText(String value) {
            this.text = value;
        }
    }

    public static class Button {
        private String type;
        private Reply reply;

        @JsonProperty("type")
        public String getType() { return type; }
        @JsonProperty("type")
        public void setType(String value) { this.type = value; }

        @JsonProperty("reply")
        public Reply getReply() { return reply; }
        @JsonProperty("reply")
        public void setReply(Reply value) { this.reply = value; }
    }

    public static class Header {
        private String type;
        private String text;

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String value) {
            this.type = value;
        }

        @JsonProperty("text")
        public String getText() {
            return text;
        }

        @JsonProperty("text")
        public void setText(String value) {
            this.text = value;
        }
    }

    public static class Reply {
        private String id;
        private String title;

        @JsonProperty("id")
        public String getID() { return id; }
        @JsonProperty("id")
        public void setID(String value) { this.id = value; }

        @JsonProperty("title")
        public String getTitle() { return title; }
        @JsonProperty("title")
        public void setTitle(String value) { this.title = value; }
    }

}
