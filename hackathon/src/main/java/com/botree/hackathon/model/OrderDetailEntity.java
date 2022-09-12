package com.botree.hackathon.model;


public class OrderDetailEntity extends AbstractEntity {

    /** name. */
    private String name;
    /** sku. */
    private String sku;
    /** units. */
    private Integer units;
    /** selling_price. */
    private Double selling_price;
    /** discount. */
    private Double discount;
    /** tax. */
    private Double tax;
    /** hsn. */
    private String hsn;

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @param nameIn the name to set
     */
    public final void setName(final String nameIn) {
        name = nameIn;
    }

    /**
     * @return the sku
     */
    public final String getSku() {
        return sku;
    }

    /**
     * @param skuIn the sku to set
     */
    public final void setSku(final String skuIn) {
        sku = skuIn;
    }

    /**
     * @return the units
     */
    public final Integer getUnits() {
        return units;
    }

    /**
     * @param unitsIn the units to set
     */
    public final void setUnits(final Integer unitsIn) {
        units = unitsIn;
    }

    /**
     * @return the selling_price
     */
    public final Double getSelling_price() {
        return selling_price;
    }

    /**
     * @param selling_priceIn the selling_price to set
     */
    public final void setSelling_price(final Double selling_priceIn) {
        selling_price = selling_priceIn;
    }

    /**
     * @return the discount
     */
    public final Double getDiscount() {
        return discount;
    }

    /**
     * @param discountIn the discount to set
     */
    public final void setDiscount(final Double discountIn) {
        discount = discountIn;
    }

    /**
     * @return the tax
     */
    public final Double getTax() {
        return tax;
    }

    /**
     * @param taxIn the tax to set
     */
    public final void setTax(final Double taxIn) {
        tax = taxIn;
    }

    /**
     * @return the hsn
     */
    public final String getHsn() {
        return hsn;
    }

    /**
     * @param hsnIn the hsn to set
     */
    public final void setHsn(final String hsnIn) {
        hsn = hsnIn;
    }
}
