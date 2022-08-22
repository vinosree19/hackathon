package com.botree.hackathon.controller;

import com.botree.hackathon.model.DownloadModel;
import com.botree.hackathon.model.OrderHeaderEntity;
import com.botree.hackathon.model.ReportModel;
import com.botree.hackathon.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * API Controller to get all the request for data.
 * @author vinodkumar.a
 */
@RestController
@RequestMapping(value = "/api/v1")
public class ApiController {

    /** LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(ApiController.class);
    /** reportService. */
    private final ReportService reportService;

    /**
     * Constructor method.
     * @param reportServiceIn reportServiceIn
     */
    public ApiController(final ReportService reportServiceIn) {
        this.reportService = reportServiceIn;
    }

    /**
     * Method to check success status.
     * @return test
     */
    @GetMapping("/index")
    public final String index() {
        LOG.info("index :: ");
        return "success";
    }

    /**
     * Method to fetch the pending delivery order.
     * @param user user
     * @return download data
     */
    @PostMapping("/delivery-order/pending")
    public DownloadModel downloadPendingDeliveryOrder(@RequestBody final ReportModel user) {
        LOG.info("pending delivery order info :: {} ", user.getDistrCode());
        return reportService.downloadPendingDeliveryOrder(user);
    }

    /**
     * Method to create the adhoc delivery order.
     * @param order order
     */
    @PostMapping("/delivery-order/create/adhoc")
    public Object createAdhocPendingDeliveryOrder(@RequestBody final OrderHeaderEntity order) {
        LOG.info("create adhoc pending delivery order info :: {} ", order.getOrder_id());
        return reportService.createAdhocPendingDeliveryOrder(order);
    }

    /**
     * Method to create the delivery order.
     * @param order order
     */
    @PostMapping("/delivery-order/create")
    public Object createPendingDeliveryOrder(@RequestBody final OrderHeaderEntity order) {
        LOG.info("create pending delivery order info :: {} ", order.getOrder_id());
        return reportService.createPendingDeliveryOrder(order);
    }

    /**
     * Method to call serviceability api.
     * @param invoice_id orderId
     * @return obj
     */
    @GetMapping("/delivery-order/serviceability")
    public Object getAvailableServices(@RequestParam(value = "invoice_id") String invoice_id) {
        LOG.info("call serviceability service :: {} ", invoice_id);
        return reportService.getAvailableServices(invoice_id);
    }


    /**
     * Method to call selected service
     * @param invoice_id invoiceId
     * @return obj
     */
    @PostMapping("/delivery-order/selectService")
    public Object selectedService(@RequestParam(value = "invoice_id") String invoice_id,
                                  @RequestParam(value = "courier_id") String courierId) {
        LOG.info("invoice id :: {} ", invoice_id);
        return reportService.selectServiceForOrder(invoice_id, courierId);
    }

    /**
     * Method to call serviceability api.
     * @param invoice_id shipmentId
     * @return obj
     */
    @GetMapping("/delivery-order/generate/pickup")
    public Object generatePickUp(@RequestParam(value = "invoice_id") String invoice_id) {
        return reportService.generatePickUp(invoice_id);
    }

    /**
     * Method to track the order with awb code
     * @param invoice_id invoice_id
     * @return obj
     */
    @GetMapping("/delivery-order/tracking/awb")
    public Object getTrackingDetail(@RequestParam(value = "invoice_id") String invoice_id){
        return reportService.getAwbTrackingDetails(invoice_id);
    }

    /**
     * Method to track the order with shipmentId
     * @param invoice_id invoice_id
     * @return obj
     */
    @GetMapping("/delivery-order/tracking/shipmentId")
    public Object getTrackingWithShipmentIdDetail(@RequestParam(value = "invoice_id") String invoice_id){
        return reportService.getAwbTrackingWithShipmentIdDetails(invoice_id);
    }

    @PostMapping("/delivery-order/cancel")
    public Object cancelPendingDeliveryOrder(@RequestParam(value = "invoice_id") String invoice_id){
        return reportService.cancelPendingDeliveryOrder(invoice_id);
    }

}
