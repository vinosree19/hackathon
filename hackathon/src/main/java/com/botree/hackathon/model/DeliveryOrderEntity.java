package com.botree.hackathon.model;

public class DeliveryOrderEntity{

	private String order_id;
	private String invoice_id;
	private String shipment_id;
	private String awb_code;
	private String courier_code;
	private String status;


	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(String invoice_id) {
		this.invoice_id = invoice_id;
	}

	public String getShipment_id() {
		return shipment_id;
	}

	public void setShipment_id(String shipment_id) {
		this.shipment_id = shipment_id;
	}

	public String getAwb_code() {
		return awb_code;
	}

	public void setAwb_code(String awb_code) {
		this.awb_code = awb_code;
	}

	public String getCourier_code() {
		return courier_code;
	}

	public void setCourier_code(String courier_code) {
		this.courier_code = courier_code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}