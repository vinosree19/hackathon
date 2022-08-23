package com.botree.hackathon.util.whatsapp;

/*
Author: Godlin Josheela Rani S
*/
public class WAWebHooksObject {
    private String hub_mode;
    private String hub_challenge;
    private String hub_verify_token;

    public WAWebHooksObject() {
    }

    public String getHub_mode() {
        return hub_mode;
    }

    public void setHub_mode(String hub_mode) {
        this.hub_mode = hub_mode;
    }

    public String getHub_challenge() {
        return hub_challenge;
    }

    public void setHub_challenge(String hub_challenge) {
        this.hub_challenge = hub_challenge;
    }

    public String getHub_verify_token() {
        return hub_verify_token;
    }

    public void setHub_verify_token(String hub_verify_token) {
        this.hub_verify_token = hub_verify_token;
    }
}
