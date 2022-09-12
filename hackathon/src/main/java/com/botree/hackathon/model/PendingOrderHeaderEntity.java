package com.botree.hackathon.model;

import java.util.Date;
import java.util.List;


public class PendingOrderHeaderEntity extends AbstractEntity {

    /** distrCode. */
    private String distrCode;

    /** invoiceNo. */
    private String invoiceNo;

    /** invoiceDt. */
    private Date invoiceDt;

    /** salesmanCode. */
    private String salesmanCode;

    /** salesmanName. */
    private String salesmanName;

    /** routeCode. */
    private String routeCode;

    /** routeName. */
    private String routeName;

    /** customerCode. */
    private String customerCode;

    /** customerName. */
    private String customerName;

    /** mobileNo. */
    private String mobileNo;

    /** fssaiNo. */
    private String fssaiNo;

    /** gstTinNo. */
    private String gstTinNo;

    /** customerShipAddr. */
    private String customerShipAddr;

    /** totGrossAmt. */
    private Double totGrossAmt;

    /** totCashDiscAmt. */
    private Double totCashDiscAmt;

    /** totDBDiscAmt. */
    private Double totDBDiscAmt;

    /** totSchDiscAmt. */
    private Double totSchDiscAmt;

    /** totTaxAmt. */
    private Double totTaxAmt;

    /** totNetAmt. */
    private Double totNetAmt;

    /** roundOffAmt. */
    private Double roundOffAmt;

    /** totCrNoteAmt. */
    private Double totCrNoteAmt;

    /** remarks. */
    private String remarks;

    /** liquidation. */
    private String liquidation;

    /** billDetailsEntityList. */
    private List<PendingOrderDetailEntity> billPrintDetailList;

    /**
     * @return the distrCode
     */
    public final String getDistrCode() {
        return distrCode;
    }

    /**
     * @param distrCodeIn the distrCode to set
     */
    public final void setDistrCode(final String distrCodeIn) {
        distrCode = distrCodeIn;
    }

    /**
     * @return the invoiceNo
     */
    public final String getInvoiceNo() {
        return invoiceNo;
    }

    /**
     * @param invoiceNoIn the invoiceNo to set
     */
    public final void setInvoiceNo(final String invoiceNoIn) {
        invoiceNo = invoiceNoIn;
    }

    /**
     * @return the invoiceDt
     */
    public final Date getInvoiceDt() {
        return invoiceDt;
    }

    /**
     * @param invoiceDtIn the invoiceDt to set
     */
    public final void setInvoiceDt(final Date invoiceDtIn) {
        invoiceDt = invoiceDtIn;
    }

    /**
     * @return the salesmanCode
     */
    public final String getSalesmanCode() {
        return salesmanCode;
    }

    /**
     * @param salesmanCodeIn the salesmanCode to set
     */
    public final void setSalesmanCode(final String salesmanCodeIn) {
        salesmanCode = salesmanCodeIn;
    }

    /**
     * @return the salesmanName
     */
    public final String getSalesmanName() {
        return salesmanName;
    }

    /**
     * @param salesmanNameIn the salesmanName to set
     */
    public final void setSalesmanName(final String salesmanNameIn) {
        salesmanName = salesmanNameIn;
    }

    /**
     * @return the routeCode
     */
    public final String getRouteCode() {
        return routeCode;
    }

    /**
     * @param routeCodeIn the routeCode to set
     */
    public final void setRouteCode(final String routeCodeIn) {
        routeCode = routeCodeIn;
    }

    /**
     * @return the routeName
     */
    public final String getRouteName() {
        return routeName;
    }

    /**
     * @param routeNameIn the routeName to set
     */
    public final void setRouteName(final String routeNameIn) {
        routeName = routeNameIn;
    }

    /**
     * @return the customerCode
     */
    public final String getCustomerCode() {
        return customerCode;
    }

    /**
     * @param customerCodeIn the customerCode to set
     */
    public final void setCustomerCode(final String customerCodeIn) {
        customerCode = customerCodeIn;
    }

    /**
     * @return the customerName
     */
    public final String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerNameIn the customerName to set
     */
    public final void setCustomerName(final String customerNameIn) {
        customerName = customerNameIn;
    }

    /**
     * @return the mobileNo
     */
    public final String getMobileNo() {
        return mobileNo;
    }

    /**
     * @param mobileNoIn the mobileNo to set
     */
    public final void setMobileNo(final String mobileNoIn) {
        mobileNo = mobileNoIn;
    }

    /**
     * @return the fssaiNo
     */
    public final String getFssaiNo() {
        return fssaiNo;
    }

    /**
     * @param fssaiNoIn the fssaiNo to set
     */
    public final void setFssaiNo(final String fssaiNoIn) {
        fssaiNo = fssaiNoIn;
    }

    /**
     * @return the gstTinNo
     */
    public final String getGstTinNo() {
        return gstTinNo;
    }

    /**
     * @param gstTinNoIn the gstTinNo to set
     */
    public final void setGstTinNo(final String gstTinNoIn) {
        gstTinNo = gstTinNoIn;
    }

    /**
     * @return the customerShipAddr
     */
    public final String getCustomerShipAddr() {
        return customerShipAddr;
    }

    /**
     * @param customerShipAddrIn the customerShipAddr to set
     */
    public final void setCustomerShipAddr(final String customerShipAddrIn) {
        customerShipAddr = customerShipAddrIn;
    }

    /**
     * @return the totGrossAmt
     */
    public final Double getTotGrossAmt() {
        return totGrossAmt;
    }

    /**
     * @param totGrossAmtIn the totGrossAmt to set
     */
    public final void setTotGrossAmt(final Double totGrossAmtIn) {
        totGrossAmt = totGrossAmtIn;
    }

    /**
     * @return the totCashDiscAmt
     */
    public final Double getTotCashDiscAmt() {
        return totCashDiscAmt;
    }

    /**
     * @param totCashDiscAmtIn the totCashDiscAmt to set
     */
    public final void setTotCashDiscAmt(final Double totCashDiscAmtIn) {
        totCashDiscAmt = totCashDiscAmtIn;
    }

    /**
     * @return the totDBDiscAmt
     */
    public final Double getTotDBDiscAmt() {
        return totDBDiscAmt;
    }

    /**
     * @param totDBDiscAmtIn the totDBDiscAmt to set
     */
    public final void setTotDBDiscAmt(final Double totDBDiscAmtIn) {
        totDBDiscAmt = totDBDiscAmtIn;
    }

    /**
     * @return the totSchDiscAmt
     */
    public final Double getTotSchDiscAmt() {
        return totSchDiscAmt;
    }

    /**
     * @param totSchDiscAmtIn the totSchDiscAmt to set
     */
    public final void setTotSchDiscAmt(final Double totSchDiscAmtIn) {
        totSchDiscAmt = totSchDiscAmtIn;
    }

    /**
     * @return the totTaxAmt
     */
    public final Double getTotTaxAmt() {
        return totTaxAmt;
    }

    /**
     * @param totTaxAmtIn the totTaxAmt to set
     */
    public final void setTotTaxAmt(final Double totTaxAmtIn) {
        totTaxAmt = totTaxAmtIn;
    }

    /**
     * @return the totNetAmt
     */
    public final Double getTotNetAmt() {
        return totNetAmt;
    }

    /**
     * @param totNetAmtIn the totNetAmt to set
     */
    public final void setTotNetAmt(final Double totNetAmtIn) {
        totNetAmt = totNetAmtIn;
    }

    /**
     * @return the roundOffAmt
     */
    public final Double getRoundOffAmt() {
        return roundOffAmt;
    }

    /**
     * @param roundOffAmtIn the roundOffAmt to set
     */
    public final void setRoundOffAmt(final Double roundOffAmtIn) {
        roundOffAmt = roundOffAmtIn;
    }

    /**
     * @return the totCrNoteAmt
     */
    public final Double getTotCrNoteAmt() {
        return totCrNoteAmt;
    }

    /**
     * @param totCrNoteAmtIn the totCrNoteAmt to set
     */
    public final void setTotCrNoteAmt(final Double totCrNoteAmtIn) {
        totCrNoteAmt = totCrNoteAmtIn;
    }

    /**
     * @return the remarks
     */
    public final String getRemarks() {
        return remarks;
    }

    /**
     * @param remarksIn the remarks to set
     */
    public final void setRemarks(final String remarksIn) {
        remarks = remarksIn;
    }

    /**
     * @return the billPrintDetailList
     */
    public final List<PendingOrderDetailEntity> getBillPrintDetailList() {
        return billPrintDetailList;
    }

    /**
     * @param billPrintDetailListIn the billPrintDetailList to set
     */
    public final void setBillPrintDetailList(
            final List<PendingOrderDetailEntity> billPrintDetailListIn) {
        billPrintDetailList = billPrintDetailListIn;
    }

    /**
     * @return the liquidation
     */
    public final String getLiquidation() {
        return liquidation;
    }

    /**
     * @param liquidationIn the liquidation to set
     */
    public final void setLiquidation(final String liquidationIn) {
        liquidation = liquidationIn;
    }
}

