package com.botree.hackathon.constants;

/**
 * Class contains the constant value.
 * @author vinodkumar.a
 */
public final class StringConstants {

    /** FETCH_PENDING_ORDER_HEADER_ENTITY_FOR_REPORT. */
    public static final String FETCH_PENDING_ORDER_HEADER_ENTITY_FOR_REPORT =
            "FETCH_PENDING_ORDER_HEADER_ENTITY_FOR_REPORT";
    /** FETCH_BILLPRINTDETAILENTITY_FOR_REPORT. */
    public static final String FETCH_PENDING_ORDER_DETAIL_ENTITY_FOR_REPORT =
            "FETCH_PENDING_ORDER_DETAIL_ENTITY_FOR_REPORT";

    public static final String INSERT_INTO_DELIVERY_ORDER_TABLE = "INSERT_INTO_DELIVERY_ORDER_TABLE";

    public static final String GET_ORDER_ID_BY_INVOICE_ID_FROM_DELIVERY_ORDER_DETAIL_TABLE = "GET_ORDER_ID_BY_INVOICE_ID_FROM_DELIVERY_ORDER_DETAIL_TABLE";
    public static final String GET_ORDER_ID_SHIPMENT_ID_BY_INVOICE_ID_FROM_DELIVERY_ORDER_DETAIL_TABLE =
            "GET_ORDER_ID_SHIPMENT_ID_BY_INVOICE_ID_FROM_DELIVERY_ORDER_DETAIL_TABLE";

    public static final String INSERT_INTO_DELIVERY_ORDER_DETAIL_TABLE = "INSERT_INTO_DELIVERY_ORDER_DETAIL_TABLE";
    public static final String FETCH_ORDER_VALUE_FROM_DELIVERY_ORDER_DETAIL_TABLE = "FETCH_ORDER_VALUE_FROM_DELIVERY_ORDER_DETAIL_TABLE";
    public static final String UPDATE_COURIER_CODE_IN_DELIVERY_ORDER_DETAIL_TABLE = "UPDATE_COURIER_CODE_IN_DELIVERY_ORDER_DETAIL_TABLE";
    public static final String UPDATE_STATUS_IN_DELIVERY_ORDER_DETAIL_TABLE = "UPDATE_STATUS_IN_DELIVERY_ORDER_DETAIL_TABLE";
    public static final String FETCH_STATUS_FROM_DELIVERY_ORDER_TABLE = "FETCH_STATUS_FROM_DELIVERY_ORDER_TABLE";
    public static final String UPDATE_AWB_ORDER_IN_DELIVERY_ORDER_DETAIL_TABLE = "UPDATE_AWB_ORDER_IN_DELIVERY_ORDER_DETAIL_TABLE";

//    public static final String INSERT_INTO_DELIVERY_ORDER_TABLE = "INSERT INTO deliveryordertable" +
//        " (shipping_charges,billing_last_name,billing_phone,giftwrap_charges,total_discount,shipping_state,breadth," +
//        " shipping_city,shipping_phone,billing_customer_name,billing_address,shipping_address_2,shipping_is_billing,billing_state,billing_address_2,billing_email,shipping_address," +
//        " payment_method,height,pickup_location,shipping_customer_name,billing_country,length,weight,order_date,billing_city,shipping_pincode,shipping_email,billing_pincode,sub_total,shipping_last_name," +
//        " comment,order_id,channel_id,shipping_country,transaction_charges,invoice_id)" +
//        " values  (:shipping_charges,:billing_last_name,:billing_phone,:giftwrap_charges,:total_discount,:shipping_state,:breadth," +
//        " :shipping_city,:shipping_phone,:billing_customer_name,:billing_address,:shipping_address_2,:shipping_is_billing,:billing_state,:billing_address_2,:billing_email,:shipping_address," +
//        " :payment_method,:height,:pickup_location,:shipping_customer_name,:billing_country,:length,weight,:order_date,:billing_city,:shipping_pincode,:shipping_email,:billing_pincode,:sub_total,:shipping_last_name," +
//        " :comment,:order_id,:channel_id,:shipping_country,:transaction_charges,:invoice_id)";

    /**
     * Empty constructor.
     */
    private StringConstants() {

    }

}
