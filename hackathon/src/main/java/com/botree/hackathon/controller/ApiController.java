package com.botree.hackathon.controller;

import com.botree.hackathon.model.DownloadModel;
import com.botree.hackathon.model.OrderHeaderEntity;
import com.botree.hackathon.model.ReportModel;
import com.botree.hackathon.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public void createAdhocPendingDeliveryOrder(@RequestBody final OrderHeaderEntity order) {
        LOG.info("create adhoc pending delivery order info :: {} ", order.getOrder_id());
        reportService.createAdhocPendingDeliveryOrder(order);
    }
}
