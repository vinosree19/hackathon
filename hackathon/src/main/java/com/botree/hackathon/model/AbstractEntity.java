package com.botree.hackathon.model;

import java.util.Date;

/**
 * Abstract Entity class.
 * @author vinodkumar.a
 */
public class AbstractEntity {

    /** cmpCode. */
    private String cmpCode;

    /** uploadFlag. */
    private String uploadFlag;

    /** modDt. */
    private Date modDt;

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
     * @return the uploadFlag
     */
    public final String getUploadFlag() {
        return uploadFlag;
    }

    /**
     * @param uploadFlagIn the uploadFlag to set
     */
    public final void setUploadFlag(final String uploadFlagIn) {
        uploadFlag = uploadFlagIn;
    }

    /**
     * @return the modDt
     */
    public final Date getModDt() {
        return modDt;
    }

    /**
     * @param modDtIn the modDt to set
     */
    public final void setModDt(final Date modDtIn) {
        modDt = modDtIn;
    }
}
