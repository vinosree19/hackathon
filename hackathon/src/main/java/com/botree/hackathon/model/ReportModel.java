package com.botree.hackathon.model;

import java.util.Date;


public class ReportModel {

    /** cmpCode. */
    private String cmpCode;

    /** distrCode. */
    private String distrCode;

    /** startDate. */
    private Date startDate;

    /** endDate. */
    private Date endDate;

    /**
     * @return the cmpCode
     */
    public final String getCmpCode() {
        return cmpCode;
    }

    /**
     * @param cmpCodeIn the cmpCode to set
     */
    public final void setCmpCode(final String cmpCodeIn) {
        cmpCode = cmpCodeIn;
    }

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
     * @return the startDate
     */
    public final Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDateIn the startDate to set
     */
    public final void setStartDate(final Date startDateIn) {
        startDate = startDateIn;
    }

    /**
     * @return the endDate
     */
    public final Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDateIn the endDate to set
     */
    public final void setEndDate(final Date endDateIn) {
        endDate = endDateIn;
    }
}
