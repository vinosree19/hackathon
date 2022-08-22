package com.botree.hackathon.model;

import java.util.Date;
import java.util.List;

/**
 * Order Header Entity class.
 * @author vinodkumar.a
 */
public class OrderHeaderEntity extends AbstractEntity {

    /** order_id. */
    private String order_id;
    /** order_date. */
    private String order_date;
    /** pickup_location. */
    private String pickup_location;
    /** channel_id. */
    private String channel_id;
    /** comment. */
    private String comment;
    /** billing_customer_name. */
    private String billing_customer_name;
    /** billing_last_name. */
    private String billing_last_name;
    /** billing_address. */
    private String billing_address;
    /** billing_address_2. */
    private String billing_address_2;
    /** billing_city. */
    private String billing_city;
    /** billing_pincode. */
    private String billing_pincode;
    /** billing_state. */
    private String billing_state;
    /** billing_country. */
    private String billing_country;
    /** billing_email. */
    private String billing_email;
    /** billing_phone. */
    private String billing_phone;
    /** shipping_is_billing. */
    private Boolean shipping_is_billing;
    /** shipping_customer_name. */
    private String shipping_customer_name;
    /** shipping_last_name. */
    private String shipping_last_name;
    /** shipping_address. */
    private String shipping_address;
    /** shipping_address_2. */
    private String shipping_address_2;
    /** shipping_city. */
    private String shipping_city;
    /** shipping_pincode. */
    private String shipping_pincode;
    /** shipping_country. */
    private String shipping_country;
    /** shipping_state. */
    private String shipping_state;
    /** shipping_email. */
    private String shipping_email;
    /** shipping_phone. */
    private String shipping_phone;
    /** payment_method. */
    private String payment_method;
    /** shipping_charges. */
    private Double shipping_charges;
    /** giftwrap_charges. */
    private Double giftwrap_charges;
    /** transaction_charges. */
    private Double transaction_charges;
    /** total_discount. */
    private Double total_discount;
    /** sub_total. */
    private Double sub_total;
    /** length. */
    private Double length;
    /** breadth. */
    private Double breadth;
    /** height. */
    private Double height;
    /** weight. */
    private Double weight;
    /** order_items. */
    private List<OrderDetailEntity> order_items;

    private String invoice_id;

    /**
     * @return the order_id
     */
    public final String getOrder_id() {
        return order_id;
    }

    /**
     * @param order_idIn the order_id to set
     */
    public final void setOrder_id(final String order_idIn) {
        order_id = order_idIn;
    }

    /**
     * @return the order_date
     */
    public final String getOrder_date() {
        return order_date;
    }

    /**
     * @param order_dateIn the order_date to set
     */
    public final void setOrder_date(final String order_dateIn) {
        order_date = order_dateIn;
    }

    /**
     * @return the pickup_location
     */
    public final String getPickup_location() {
        return pickup_location;
    }

    /**
     * @param pickup_locationIn the pickup_location to set
     */
    public final void setPickup_location(final String pickup_locationIn) {
        pickup_location = pickup_locationIn;
    }

    /**
     * @return the channel_id
     */
    public final String getChannel_id() {
        return channel_id;
    }

    /**
     * @param channel_idIn the channel_id to set
     */
    public final void setChannel_id(final String channel_idIn) {
        channel_id = channel_idIn;
    }

    /**
     * @return the comment
     */
    public final String getComment() {
        return comment;
    }

    /**
     * @param commentIn the comment to set
     */
    public final void setComment(final String commentIn) {
        comment = commentIn;
    }

    /**
     * @return the billing_customer_name
     */
    public final String getBilling_customer_name() {
        return billing_customer_name;
    }

    /**
     * @param billing_customer_nameIn the billing_customer_name to set
     */
    public final void setBilling_customer_name(final String billing_customer_nameIn) {
        billing_customer_name = billing_customer_nameIn;
    }

    /**
     * @return the billing_last_name
     */
    public final String getBilling_last_name() {
        return billing_last_name;
    }

    /**
     * @param billing_last_nameIn the billing_last_name to set
     */
    public final void setBilling_last_name(final String billing_last_nameIn) {
        billing_last_name = billing_last_nameIn;
    }

    /**
     * @return the billing_address
     */
    public final String getBilling_address() {
        return billing_address;
    }

    /**
     * @param billing_addressIn the billing_address to set
     */
    public final void setBilling_address(final String billing_addressIn) {
        billing_address = billing_addressIn;
    }

    /**
     * @return the billing_address_2
     */
    public final String getBilling_address_2() {
        return billing_address_2;
    }

    /**
     * @param billing_address_2In the billing_address_2 to set
     */
    public final void setBilling_address_2(final String billing_address_2In) {
        billing_address_2 = billing_address_2In;
    }

    /**
     * @return the billing_city
     */
    public final String getBilling_city() {
        return billing_city;
    }

    /**
     * @param billing_cityIn the billing_city to set
     */
    public final void setBilling_city(final String billing_cityIn) {
        billing_city = billing_cityIn;
    }

    /**
     * @return the billing_pincode
     */
    public final String getBilling_pincode() {
        return billing_pincode;
    }

    /**
     * @param billing_pincodeIn the billing_pincode to set
     */
    public final void setBilling_pincode(final String billing_pincodeIn) {
        billing_pincode = billing_pincodeIn;
    }

    /**
     * @return the billing_state
     */
    public final String getBilling_state() {
        return billing_state;
    }

    /**
     * @param billing_stateIn the billing_state to set
     */
    public final void setBilling_state(final String billing_stateIn) {
        billing_state = billing_stateIn;
    }

    /**
     * @return the billing_country
     */
    public final String getBilling_country() {
        return billing_country;
    }

    /**
     * @param billing_countryIn the billing_country to set
     */
    public final void setBilling_country(final String billing_countryIn) {
        billing_country = billing_countryIn;
    }

    /**
     * @return the billing_email
     */
    public final String getBilling_email() {
        return billing_email;
    }

    /**
     * @param billing_emailIn the billing_email to set
     */
    public final void setBilling_email(final String billing_emailIn) {
        billing_email = billing_emailIn;
    }

    /**
     * @return the billing_phone
     */
    public final String getBilling_phone() {
        return billing_phone;
    }

    /**
     * @param billing_phoneIn the billing_phone to set
     */
    public final void setBilling_phone(final String billing_phoneIn) {
        billing_phone = billing_phoneIn;
    }

    /**
     * @return the shipping_is_billing
     */
    public final Boolean getShipping_is_billing() {
        return shipping_is_billing;
    }

    /**
     * @param shipping_is_billingIn the shipping_is_billing to set
     */
    public final void setShipping_is_billing(final Boolean shipping_is_billingIn) {
        shipping_is_billing = shipping_is_billingIn;
    }

    /**
     * @return the shipping_customer_name
     */
    public final String getShipping_customer_name() {
        return shipping_customer_name;
    }

    /**
     * @param shipping_customer_nameIn the shipping_customer_name to set
     */
    public final void setShipping_customer_name(final String shipping_customer_nameIn) {
        shipping_customer_name = shipping_customer_nameIn;
    }

    /**
     * @return the shipping_last_name
     */
    public final String getShipping_last_name() {
        return shipping_last_name;
    }

    /**
     * @param shipping_last_nameIn the shipping_last_name to set
     */
    public final void setShipping_last_name(final String shipping_last_nameIn) {
        shipping_last_name = shipping_last_nameIn;
    }

    /**
     * @return the shipping_address
     */
    public final String getShipping_address() {
        return shipping_address;
    }

    /**
     * @param shipping_addressIn the shipping_address to set
     */
    public final void setShipping_address(final String shipping_addressIn) {
        shipping_address = shipping_addressIn;
    }

    /**
     * @return the shipping_address_2
     */
    public final String getShipping_address_2() {
        return shipping_address_2;
    }

    /**
     * @param shipping_address_2In the shipping_address_2 to set
     */
    public final void setShipping_address_2(final String shipping_address_2In) {
        shipping_address_2 = shipping_address_2In;
    }

    /**
     * @return the shipping_city
     */
    public final String getShipping_city() {
        return shipping_city;
    }

    /**
     * @param shipping_cityIn the shipping_city to set
     */
    public final void setShipping_city(final String shipping_cityIn) {
        shipping_city = shipping_cityIn;
    }

    /**
     * @return the shipping_pincode
     */
    public final String getShipping_pincode() {
        return shipping_pincode;
    }

    /**
     * @param shipping_pincodeIn the shipping_pincode to set
     */
    public final void setShipping_pincode(final String shipping_pincodeIn) {
        shipping_pincode = shipping_pincodeIn;
    }

    /**
     * @return the shipping_country
     */
    public final String getShipping_country() {
        return shipping_country;
    }

    /**
     * @param shipping_countryIn the shipping_country to set
     */
    public final void setShipping_country(final String shipping_countryIn) {
        shipping_country = shipping_countryIn;
    }

    /**
     * @return the shipping_state
     */
    public final String getShipping_state() {
        return shipping_state;
    }

    /**
     * @param shipping_stateIn the shipping_state to set
     */
    public final void setShipping_state(final String shipping_stateIn) {
        shipping_state = shipping_stateIn;
    }

    /**
     * @return the shipping_email
     */
    public final String getShipping_email() {
        return shipping_email;
    }

    /**
     * @param shipping_emailIn the shipping_email to set
     */
    public final void setShipping_email(final String shipping_emailIn) {
        shipping_email = shipping_emailIn;
    }

    /**
     * @return the shipping_phone
     */
    public final String getShipping_phone() {
        return shipping_phone;
    }

    /**
     * @param shipping_phoneIn the shipping_phone to set
     */
    public final void setShipping_phone(final String shipping_phoneIn) {
        shipping_phone = shipping_phoneIn;
    }

    /**
     * @return the payment_method
     */
    public final String getPayment_method() {
        return payment_method;
    }

    /**
     * @param payment_methodIn the payment_method to set
     */
    public final void setPayment_method(final String payment_methodIn) {
        payment_method = payment_methodIn;
    }

    /**
     * @return the shipping_charges
     */
    public final Double getShipping_charges() {
        return shipping_charges;
    }

    /**
     * @param shipping_chargesIn the shipping_charges to set
     */
    public final void setShipping_charges(final Double shipping_chargesIn) {
        shipping_charges = shipping_chargesIn;
    }

    /**
     * @return the giftwrap_charges
     */
    public final Double getGiftwrap_charges() {
        return giftwrap_charges;
    }

    /**
     * @param giftwrap_chargesIn the giftwrap_charges to set
     */
    public final void setGiftwrap_charges(final Double giftwrap_chargesIn) {
        giftwrap_charges = giftwrap_chargesIn;
    }

    /**
     * @return the transaction_charges
     */
    public final Double getTransaction_charges() {
        return transaction_charges;
    }

    /**
     * @param transaction_chargesIn the transaction_charges to set
     */
    public final void setTransaction_charges(final Double transaction_chargesIn) {
        transaction_charges = transaction_chargesIn;
    }

    /**
     * @return the total_discount
     */
    public final Double getTotal_discount() {
        return total_discount;
    }

    /**
     * @param total_discountIn the total_discount to set
     */
    public final void setTotal_discount(final Double total_discountIn) {
        total_discount = total_discountIn;
    }

    /**
     * @return the sub_total
     */
    public final Double getSub_total() {
        return sub_total;
    }

    /**
     * @param sub_totalIn the sub_total to set
     */
    public final void setSub_total(final Double sub_totalIn) {
        sub_total = sub_totalIn;
    }

    /**
     * @return the length
     */
    public final Double getLength() {
        return length;
    }

    /**
     * @param lengthIn the length to set
     */
    public final void setLength(final Double lengthIn) {
        length = lengthIn;
    }

    /**
     * @return the breadth
     */
    public final Double getBreadth() {
        return breadth;
    }

    /**
     * @param breadthIn the breadth to set
     */
    public final void setBreadth(final Double breadthIn) {
        breadth = breadthIn;
    }

    /**
     * @return the height
     */
    public final Double getHeight() {
        return height;
    }

    /**
     * @param heightIn the height to set
     */
    public final void setHeight(final Double heightIn) {
        height = heightIn;
    }

    /**
     * @return the weight
     */
    public final Double getWeight() {
        return weight;
    }

    /**
     * @param weightIn the weight to set
     */
    public final void setWeight(final Double weightIn) {
        weight = weightIn;
    }

    /**
     * @return the order_items
     */
    public final List<OrderDetailEntity> getOrder_items() {
        return order_items;
    }

    /**
     * @param order_itemsIn the order_items to set
     */
    public final void setOrder_items(final List<OrderDetailEntity> order_itemsIn) {
        order_items = order_itemsIn;
    }

    public String getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(String invoice_id) {
        this.invoice_id = invoice_id;
    }
}
