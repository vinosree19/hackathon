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
     * Method to call awb service.
     * @param shipmentId shipmentId
     * @param courierId  shipmentId
     */
    @GetMapping("/delivery-order/awb")
    public Object generateAwb(@RequestParam(value = "shipment_id") String shipmentId,
                              @RequestParam(value = "courier_id") String courierId) {
        LOG.info("call awb service :: {}:: {} ", shipmentId, courierId);
        return reportService.generateAwn(shipmentId, courierId);
    }

    /**
     * Method to call serviceability api.
     * @param orderId orderId
     * @return obj
     */
    @GetMapping("/delivery-order/serviceability")
    public Object getAvailableServices(@RequestParam(value = "order_id") String orderId) {
        LOG.info("call serviceability service :: {} ", orderId);
        return reportService.getAvailableServices(orderId);
    }

    /**
     * Method to call serviceability api.
     * @param shipmentId shipmentId
     * @return obj
     */
    @GetMapping("/delivery-order/generate/pickup")
    public Object generatePickUp(@RequestParam(value = "shipment_id") String shipmentId) {
        return reportService.generatePickUp(shipmentId);
    }

}
