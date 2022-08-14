package com.botree.hackathon.model;

/**
 * Pending Order Detail Entity class.
 * @author vinodkumar.a
 */
public class PendingOrderDetailEntity extends AbstractEntity {

    /** distrCode. */
    private String distrCode;

    /** invoiceNo. */
    private String invoiceNo;

    /** prodCode. */
    private String prodCode;

    /** hsnCode. */
    private String hsnCode;

    /** prodShortName. */
    private String prodShortName;

    /** prodName. */
    private String prodName;

    /** prodBatchCode. */
    private String prodBatchCode;

    /** totalInvoiceQty. */
    private Integer totalInvoiceQty;

    /** invoiceQty1. */
    private Integer invoiceQty1;

    /** uomCode1. */
    private String uomCode1;

    /** inputStr. */
    private String inputStr;

    /** freeQty. */
    private Integer freeQty;

    /** mrp. */
    private Double mrp;

    /** sellRate. */
    private Double sellRate;

    /** actualSellRate. */
    private Double actualSellRate;

    /** cashDiscAmt. */
    private Double cashDiscAmt;

    /** dbDiscAmt. */
    private Double dbDiscAmt;

    /** schDiscAmt. */
    private Double schDiscAmt;

    /** grossAmt. */
    private Double grossAmt;

    /** taxAmt. */
    private Double taxAmt;

    /** cgstPerc. */
    private Double cgstPerc;

    /** cgstAmt. */
    private Double cgstAmt;

    /** sgstPerc. */
    private Double sgstPerc;

    /** sgstAmt. */
    private Double sgstAmt;

    /** utgstPerc. */
    private Double utgstPerc;

    /** utgstAmt. */
    private Double utgstAmt;

    /** igstPerc. */
    private Double igstPerc;

    /** igstAmt. */
    private Double igstAmt;

    /** cessPerc. */
    private Double cessPerc;

    /** cessAmt. */
    private Double cessAmt;

    /** netAmt. */
    private Double netAmt;

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
     * @return the prodCode
     */
    public final String getProdCode() {
        return prodCode;
    }

    /**
     * @param prodCodeIn the prodCode to set
     */
    public final void setProdCode(final String prodCodeIn) {
        prodCode = prodCodeIn;
    }

    /**
     * @return the hsnCode
     */
    public final String getHsnCode() {
        return hsnCode;
    }

    /**
     * @param hsnCodeIn the hsnCode to set
     */
    public final void setHsnCode(final String hsnCodeIn) {
        hsnCode = hsnCodeIn;
    }

    /**
     * @return the prodShortName
     */
    public final String getProdShortName() {
        return prodShortName;
    }

    /**
     * @param prodShortNameIn the prodShortName to set
     */
    public final void setProdShortName(final String prodShortNameIn) {
        prodShortName = prodShortNameIn;
    }

    /**
     * @return the prodName
     */
    public final String getProdName() {
        return prodName;
    }

    /**
     * @param prodNameIn the prodName to set
     */
    public final void setProdName(final String prodNameIn) {
        prodName = prodNameIn;
    }

    /**
     * @return the prodBatchCode
     */
    public final String getProdBatchCode() {
        return prodBatchCode;
    }

    /**
     * @param prodBatchCodeIn the prodBatchCode to set
     */
    public final void setProdBatchCode(final String prodBatchCodeIn) {
        prodBatchCode = prodBatchCodeIn;
    }

    /**
     * @return the totalInvoiceQty
     */
    public final Integer getTotalInvoiceQty() {
        return totalInvoiceQty;
    }

    /**
     * @param totalInvoiceQtyIn the totalInvoiceQty to set
     */
    public final void setTotalInvoiceQty(final Integer totalInvoiceQtyIn) {
        totalInvoiceQty = totalInvoiceQtyIn;
    }

    /**
     * @return the invoiceQty1
     */
    public final Integer getInvoiceQty1() {
        return invoiceQty1;
    }

    /**
     * @param invoiceQty1In the invoiceQty1 to set
     */
    public final void setInvoiceQty1(final Integer invoiceQty1In) {
        invoiceQty1 = invoiceQty1In;
    }

    /**
     * @return the uomCode1
     */
    public final String getUomCode1() {
        return uomCode1;
    }

    /**
     * @param uomCode1In the uomCode1 to set
     */
    public final void setUomCode1(final String uomCode1In) {
        uomCode1 = uomCode1In;
    }

    /**
     * @return the inputStr
     */
    public final String getInputStr() {
        return inputStr;
    }

    /**
     * @param inputStrIn the inputStr to set
     */
    public final void setInputStr(final String inputStrIn) {
        inputStr = inputStrIn;
    }

    /**
     * @return the freeQty
     */
    public final Integer getFreeQty() {
        return freeQty;
    }

    /**
     * @param freeQtyIn the freeQty to set
     */
    public final void setFreeQty(final Integer freeQtyIn) {
        freeQty = freeQtyIn;
    }

    /**
     * @return the mrp
     */
    public final Double getMrp() {
        return mrp;
    }

    /**
     * @param mrpIn the mrp to set
     */
    public final void setMrp(final Double mrpIn) {
        mrp = mrpIn;
    }

    /**
     * @return the sellRate
     */
    public final Double getSellRate() {
        return sellRate;
    }

    /**
     * @param sellRateIn the sellRate to set
     */
    public final void setSellRate(final Double sellRateIn) {
        sellRate = sellRateIn;
    }

    /**
     * @return the actualSellRate
     */
    public final Double getActualSellRate() {
        return actualSellRate;
    }

    /**
     * @param actualSellRateIn the actualSellRate to set
     */
    public final void setActualSellRate(final Double actualSellRateIn) {
        actualSellRate = actualSellRateIn;
    }

    /**
     * @return the cashDiscAmt
     */
    public final Double getCashDiscAmt() {
        return cashDiscAmt;
    }

    /**
     * @param cashDiscAmtIn the cashDiscAmt to set
     */
    public final void setCashDiscAmt(final Double cashDiscAmtIn) {
        cashDiscAmt = cashDiscAmtIn;
    }

    /**
     * @return the dbDiscAmt
     */
    public final Double getDbDiscAmt() {
        return dbDiscAmt;
    }

    /**
     * @param dbDiscAmtIn the dbDiscAmt to set
     */
    public final void setDbDiscAmt(final Double dbDiscAmtIn) {
        dbDiscAmt = dbDiscAmtIn;
    }

    /**
     * @return the schDiscAmt
     */
    public final Double getSchDiscAmt() {
        return schDiscAmt;
    }

    /**
     * @param schDiscAmtIn the schDiscAmt to set
     */
    public final void setSchDiscAmt(final Double schDiscAmtIn) {
        schDiscAmt = schDiscAmtIn;
    }

    /**
     * @return the grossAmt
     */
    public final Double getGrossAmt() {
        return grossAmt;
    }

    /**
     * @param grossAmtIn the grossAmt to set
     */
    public final void setGrossAmt(final Double grossAmtIn) {
        grossAmt = grossAmtIn;
    }

    /**
     * @return the taxAmt
     */
    public final Double getTaxAmt() {
        return taxAmt;
    }

    /**
     * @param taxAmtIn the taxAmt to set
     */
    public final void setTaxAmt(final Double taxAmtIn) {
        taxAmt = taxAmtIn;
    }

    /**
     * @return the cgstPerc
     */
    public final Double getCgstPerc() {
        return cgstPerc;
    }

    /**
     * @param cgstPercIn the cgstPerc to set
     */
    public final void setCgstPerc(final Double cgstPercIn) {
        cgstPerc = cgstPercIn;
    }

    /**
     * @return the cgstAmt
     */
    public final Double getCgstAmt() {
        return cgstAmt;
    }

    /**
     * @param cgstAmtIn the cgstAmt to set
     */
    public final void setCgstAmt(final Double cgstAmtIn) {
        cgstAmt = cgstAmtIn;
    }

    /**
     * @return the sgstPerc
     */
    public final Double getSgstPerc() {
        return sgstPerc;
    }

    /**
     * @param sgstPercIn the sgstPerc to set
     */
    public final void setSgstPerc(final Double sgstPercIn) {
        sgstPerc = sgstPercIn;
    }

    /**
     * @return the sgstAmt
     */
    public final Double getSgstAmt() {
        return sgstAmt;
    }

    /**
     * @param sgstAmtIn the sgstAmt to set
     */
    public final void setSgstAmt(final Double sgstAmtIn) {
        sgstAmt = sgstAmtIn;
    }

    /**
     * @return the utgstPerc
     */
    public final Double getUtgstPerc() {
        return utgstPerc;
    }

    /**
     * @param utgstPercIn the utgstPerc to set
     */
    public final void setUtgstPerc(final Double utgstPercIn) {
        utgstPerc = utgstPercIn;
    }

    /**
     * @return the utgstAmt
     */
    public final Double getUtgstAmt() {
        return utgstAmt;
    }

    /**
     * @param utgstAmtIn the utgstAmt to set
     */
    public final void setUtgstAmt(final Double utgstAmtIn) {
        utgstAmt = utgstAmtIn;
    }

    /**
     * @return the igstPerc
     */
    public final Double getIgstPerc() {
        return igstPerc;
    }

    /**
     * @param igstPercIn the igstPerc to set
     */
    public final void setIgstPerc(final Double igstPercIn) {
        igstPerc = igstPercIn;
    }

    /**
     * @return the igstAmt
     */
    public final Double getIgstAmt() {
        return igstAmt;
    }

    /**
     * @param igstAmtIn the igstAmt to set
     */
    public final void setIgstAmt(final Double igstAmtIn) {
        igstAmt = igstAmtIn;
    }

    /**
     * @return the cessPerc
     */
    public final Double getCessPerc() {
        return cessPerc;
    }

    /**
     * @param cessPercIn the cessPerc to set
     */
    public final void setCessPerc(final Double cessPercIn) {
        cessPerc = cessPercIn;
    }

    /**
     * @return the cessAmt
     */
    public final Double getCessAmt() {
        return cessAmt;
    }

    /**
     * @param cessAmtIn the cessAmt to set
     */
    public final void setCessAmt(final Double cessAmtIn) {
        cessAmt = cessAmtIn;
    }

    /**
     * @return the netAmt
     */
    public final Double getNetAmt() {
        return netAmt;
    }

    /**
     * @param netAmtIn the netAmt to set
     */
    public final void setNetAmt(final Double netAmtIn) {
        netAmt = netAmtIn;
    }
}
