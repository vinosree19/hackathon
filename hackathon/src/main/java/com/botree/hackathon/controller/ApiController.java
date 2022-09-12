package com.botree.hackathon.controller;

import com.botree.hackathon.model.DownloadModel;
import com.botree.hackathon.model.OrderHeaderEntity;
import com.botree.hackathon.model.ReportModel;
import com.botree.hackathon.service.ReportService;
import com.botree.hackathon.util.whatsapp.WASendRequest;
import com.botree.hackathon.util.whatsapp.WASendResponse;
import com.botree.hackathon.util.whatsapp.WAWebHooksObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
     * Used to get pickup order list
     * @param user user
     * @return DownloadModel
     */
    @PostMapping("/delivery-order/pick-up")
    public DownloadModel downloadPickUpDeliveryOrder(@RequestBody final ReportModel user) {
        LOG.info("pending delivery order info :: {} ", user.getDistrCode());
        return reportService.downloadPickUpDeliveryOrder(user);
    }

    /**
     * Used to get tracking order list
     * @param user user
     * @return DownloadModel
     */
    @PostMapping("/delivery-order/tracking")
    public DownloadModel downloadTrackingDeliveryOrder(@RequestBody final ReportModel user) {
        LOG.info("pending delivery order info :: {} ", user.getDistrCode());
        return reportService.downloadPickUpDeliveryOrder(user);
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

    /**
     * To cancel the Order
     * @param invoice_id invoice_id
     * @return invoice status
     */
    @PostMapping("/delivery-order/cancel")
    public Object cancelPendingDeliveryOrder(@RequestParam(value = "invoice_id") String invoice_id){
        return reportService.cancelPendingDeliveryOrder(invoice_id);
    }



    /**
     * Method to send whatsapp message to the user;
     * @param waSendRequest waSendRequest
     * @return download data
     */
    @PostMapping("/wa-messaging/send")
    public WASendResponse sendWAUpdate(@RequestBody final WASendRequest waSendRequest)  {
        return reportService.processMessage(waSendRequest);
    }

    /**
     * get Whatsapp status
     * @param waSendRequest waSendRequest
     * @return status
     */
    @PostMapping("/wa-messaging/status")
    public Object getWAStatus(@RequestBody final WASendRequest waSendRequest) {
        return reportService.processGetWAStatus(waSendRequest);
    }

    /**
     * Webhok response from whats app
     * @param hubMode hubMode
     * @param verifyToken verifyToken
     * @param challenge challenge
     * @return status
     */
    @GetMapping("/wa-messaging/webhooks")
    public String getWebHooks(@RequestParam(value = "hub_mode") String hubMode,
                              @RequestParam(value = "hub_verify_token") String verifyToken,
                              @RequestParam(value = "hub_challenge") String challenge) {
        LOG.info("getWebHooks :: {} ", hubMode+verifyToken+challenge);
        // Convert hooksValue into webHooksObject
        WAWebHooksObject webHooksObject = new WAWebHooksObject();
        webHooksObject.setHub_mode(hubMode);
        webHooksObject.setHub_verify_token(verifyToken);
        webHooksObject.setHub_challenge(challenge);
        return reportService.processWAWebHooks(webHooksObject);
    }

    /**
     * Method to fetch the pending delivery order.
     * @param user user
     * @return download data
     */
    @PostMapping("/wa-messaging/orders")
    public DownloadModel downloadOrderWithMessageStatus(@RequestBody final ReportModel user) {
        LOG.info("pending delivery order info :: {} ", user.getDistrCode());
        return reportService.downloadOrderWithMessageStatus(user);
    }

}
