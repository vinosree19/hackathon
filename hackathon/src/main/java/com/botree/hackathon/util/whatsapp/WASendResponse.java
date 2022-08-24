package com.botree.hackathon.util.whatsapp;

/*
Author: Godlin Josheela Rani S
*/
public class WASendResponse {
    private String customerCode;
    private String dbStatus;
    private String messageId;
    private String waMessageId;
    private String waStatus;
    private String invoiceNo;
    private String messageContent;


    public WASendResponse() {
    }

    public String getWaMessageId() {
        return waMessageId;
    }

    public void setWaMessageId(String waMessageId) {
        this.waMessageId = waMessageId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getDbStatus() {
        return dbStatus;
    }

    public void setDbStatus(String dbStatus) {
        this.dbStatus = dbStatus;
    }

    public String getWaStatus() {
        return waStatus;
    }

    public void setWaStatus(String waStatus) {
        this.waStatus = waStatus;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
