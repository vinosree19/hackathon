package com.botree.hackathon.model;

/**
 * Class contain the download details.
 * @author vinodkumar.a
 */
public class DownloadModel {

    /** pendingDeliveryOrder. */
    private String pendingDeliveryOrder;

    /**
     * @return the pendingDeliveryOrder
     */
    public final String getPendingDeliveryOrder() {
        return pendingDeliveryOrder;
    }

    /**
     * @param pendingDeliveryOrderIn the pendingDeliveryOrder to set
     */
    public final void setPendingDeliveryOrder(final String pendingDeliveryOrderIn) {
        pendingDeliveryOrder = pendingDeliveryOrderIn;
    }
}
