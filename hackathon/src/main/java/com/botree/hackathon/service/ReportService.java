package com.botree.hackathon.service;

import com.botree.hackathon.constants.StringConstants;
import com.botree.hackathon.dao.DAORepository;
import com.botree.hackathon.model.*;
import com.botree.hackathon.util.DataInstance;
import com.botree.hackathon.util.Function;
import com.botree.hackathon.util.whatsapp.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.http.util.TextUtils;
import org.json.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class contains the report generation logic.
 * @author vinodkumara
 */
@Service
@Transactional
public class ReportService implements DataInstance {

    /** LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(ReportService.class);
    /** shipmentUrl1. */
    @Value("${shipment.url.1}")
    private String shipmentUrl1;
    /* shipment :: create api*/
    @Value("${shipment.url.2}")
    private String shipmentUrl2;
    /* shipment :: pickup api */
    @Value("${shipment.url.3}")
    private String shipmentUrl3;
    /* shipment :: generate awb */
    @Value("${shipment.url.4}")
    private String shipmentUrl4;
    /* shipment :: servisablity spi */
    @Value("${shipment.url.5}")
    private String shipmentUrl5;
    /* shipment :: generate pickup */
    @Value("${shipment.url.6}")
    private String shipmentUrl6;
    /* Awb Tracking api*/
    @Value("${shipment.url.7}")
    private String shipmentUrl7;
    /* tracking with shipment id */
    @Value("${shipment.url.8}")
    private String shipmentUrl8;
    /* cancel created order */
    @Value("${shipment.url.9}")
    private String shipmentUrl9;

    /** repository. */
    private final DAORepository repository;
    /** queryService. */
    private final IQueryService queryService;
    /** apiWebService. */
    private final ApiWebService apiWebService;

    private final WAWebService waWebService;


    /**
     * Constructor method.
     * @param repositoryIn    repositoryIn
     * @param queryServiceIn  queryServiceIn
     * @param apiWebServiceIn apiWebServiceIn
     */
    public ReportService(final DAORepository repositoryIn, final IQueryService queryServiceIn,
                         final ApiWebService apiWebServiceIn, final WAWebService waWebService) {
        this.repository = repositoryIn;
        this.queryService = queryServiceIn;
        this.apiWebService = apiWebServiceIn;
        this.waWebService = waWebService;
    }

    /**
     * Method to download bills to print by the user.
     * @param user user
     * @return downloadModel
     */
    public DownloadModel downloadPendingDeliveryOrder(final ReportModel user) {
        LOG.info("download pending delivery order :: {}", user.getDistrCode());
        var downloadModel = new DownloadModel();
        var headerList = repository.queryForListWithRowMapper(queryService.get(
                        StringConstants.FETCH_PENDING_ORDER_HEADER_BY_DELIVERY_TABLE), PendingOrderHeaderEntity.class,
                user.getCmpCode(), user.getDistrCode(), user.getStartDate(), user.getEndDate());
        var detailsList = repository.queryForListWithRowMapper(queryService.
                        get(StringConstants.FETCH_PENDING_ORDER_DETAIL_ENTITY_FOR_REPORT),
                PendingOrderDetailEntity.class, user.getCmpCode(), user.getDistrCode(), user.getStartDate(),
                user.getEndDate()).stream().collect(Collectors.groupingBy(data -> data.getCmpCode()
                + data.getDistrCode() + data.getInvoiceNo()));

        headerList.forEach(data -> data.setBillPrintDetailList(detailsList.get(data.getCmpCode()
                + data.getDistrCode() + data.getInvoiceNo())));
        downloadModel.setPendingDeliveryOrder(Function.compress(headerList));
        return downloadModel;
    }

    public DownloadModel downloadPickUpDeliveryOrder(final ReportModel user) {
        LOG.info("download pending delivery order :: {}", user.getDistrCode());
        var downloadModel = new DownloadModel();
        var headerList = repository.queryForListWithRowMapper(queryService.get(
                        StringConstants.FETCH_PICKUP_DATA_DELIVER_PENDING_REPORT), PendingOrderHeaderEntity.class,
                user.getCmpCode(), user.getDistrCode(), user.getStartDate(), user.getEndDate());
        var detailsList = repository.queryForListWithRowMapper(queryService.
                        get(StringConstants.FETCH_PENDING_ORDER_DETAIL_ENTITY_FOR_REPORT),
                PendingOrderDetailEntity.class, user.getCmpCode(), user.getDistrCode(), user.getStartDate(),
                user.getEndDate()).stream().collect(Collectors.groupingBy(data -> data.getCmpCode()
                + data.getDistrCode() + data.getInvoiceNo()));

        headerList.forEach(data -> data.setBillPrintDetailList(detailsList.get(data.getCmpCode()
                + data.getDistrCode() + data.getInvoiceNo())));
        downloadModel.setPendingDeliveryOrder(Function.compress(headerList));
        return downloadModel;
    }

    public DownloadModel downloadTrackingDeliveryOrder(final ReportModel user) {
        LOG.info("download pending delivery order :: {}", user.getDistrCode());
        var downloadModel = new DownloadModel();
        var headerList = repository.queryForListWithRowMapper(queryService.get(
                        StringConstants.FETCH_TRACKING_DATA_DELIVER_PENDING_REPORT), PendingOrderHeaderEntity.class,
                user.getCmpCode(), user.getDistrCode(), user.getStartDate(), user.getEndDate());
        var detailsList = repository.queryForListWithRowMapper(queryService.
                        get(StringConstants.FETCH_PENDING_ORDER_DETAIL_ENTITY_FOR_REPORT),
                PendingOrderDetailEntity.class, user.getCmpCode(), user.getDistrCode(), user.getStartDate(),
                user.getEndDate()).stream().collect(Collectors.groupingBy(data -> data.getCmpCode()
                + data.getDistrCode() + data.getInvoiceNo()));

        headerList.forEach(data -> data.setBillPrintDetailList(detailsList.get(data.getCmpCode()
                + data.getDistrCode() + data.getInvoiceNo())));
        downloadModel.setPendingDeliveryOrder(Function.compress(headerList));
        return downloadModel;
    }

    /**
     * Method to create adhoc pending delivery order.
     * @param order order
     */
    public Object createAdhocPendingDeliveryOrder(final OrderHeaderEntity order) {
        LOG.info("login :: {}", order.getOrder_id());
        var invoiceId = order.getOrder_id();
        var statusCode = 0;
        String status = "";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("invoice_id", invoiceId);
        List<DeliveryOrderEntity> orderExist = repository.fetchData(
                queryService.get(StringConstants.FETCH_ORDER_VALUE_FROM_DELIVERY_ORDER_DETAIL_TABLE),
                mapSqlParameterSource,DeliveryOrderEntity.class);
        if (orderExist.isEmpty() || orderExist.size() <=0 || !orderExist.get(0).getInvoice_id().equals(invoiceId)) {
            Object response = apiWebService.sendAPI(order, shipmentUrl1, HttpMethod.POST);
            LinkedHashMap<String, Object> result = (LinkedHashMap<String, Object>) response;
            var orderId = result.get("order_id");
            var shipmentId = result.get("shipment_id");
            status = (String) result.get("status");
            statusCode = (int)result.get("status_code");

            order.setOrder_id(String.valueOf(orderId));
            order.setInvoice_id(invoiceId);
            repository.insert(queryService.get(StringConstants.INSERT_INTO_DELIVERY_ORDER_TABLE), order);

            DeliveryOrderEntity deliveryOrderEntity = new DeliveryOrderEntity();
            deliveryOrderEntity.setOrder_id(String.valueOf(orderId));
            deliveryOrderEntity.setShipment_id(String.valueOf(shipmentId));
            deliveryOrderEntity.setInvoice_id(invoiceId);
            deliveryOrderEntity.setStatus(String.valueOf(status));
            deliveryOrderEntity.setAwb_code("");
            deliveryOrderEntity.setCourier_code("");
            deliveryOrderEntity.setPickup_status("N");
            repository.insert(queryService.get(StringConstants.INSERT_INTO_DELIVERY_ORDER_DETAIL_TABLE), deliveryOrderEntity);
        }else {
            statusCode = 1;
            status = "Order Already Placed";
        }

        HashMap<String, String > sendResponse =  new HashMap<>();
        if ((int)statusCode == 1) {
            sendResponse.put("status_code", "200");
        }else {
            sendResponse.put("status_code", "201");
        }
        sendResponse.put("status", String.valueOf(status));
        sendResponse.put("invoice_id", invoiceId);

        return sendResponse;
    }

    /**
     * Method to create pending delivery order.
     * @param order order
     */
    public Object createPendingDeliveryOrder(final OrderHeaderEntity order) {
        LOG.info("login :: {}", order.getOrder_id());

        var invoiceId = order.getOrder_id();
        Object response = apiWebService.sendAPI(order, shipmentUrl2, HttpMethod.POST);
        return response;
//        return apiWebService.sendAPI(order, shipmentUrl2, HttpMethod.POST);
    }


    /**
     * Method to get the available services.
     * @param invoiceId orderId
     * @return obj
     */
    public Object getAvailableServices(final String invoiceId) {
        Object response = null;
        if (!TextUtils.isEmpty(invoiceId)) {
            MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
            mapSqlParameterSource.addValue("invoice_id",invoiceId);
            var orderModel = repository.fetchData(queryService.get(StringConstants.GET_ORDER_ID_BY_INVOICE_ID_FROM_DELIVERY_ORDER_DETAIL_TABLE),
                    mapSqlParameterSource,DeliveryOrderEntity.class);
            if (orderModel.isEmpty() || TextUtils.isEmpty(orderModel.get(0).getOrder_id())){
                return errorMessage("201","No Order Created For This invoice");
            }
            var url = shipmentUrl5 + "/?order_id=" + orderModel.get(0).getOrder_id();
            LOG.info("service : available service request :: {}", url);
            response = apiWebService.sendAPI(null, url, HttpMethod.GET);
        }
        return response;
    }

    /**
     * Method to select the service for the order.
     * @param invoiceId invoiceId
     * @param courierId
     * @return obj
     */
    public Object selectServiceForOrder(final String invoiceId, String courierId) {

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("invoice_id",invoiceId);
        var orderModel = repository.fetchData(queryService.get(StringConstants.GET_ORDER_ID_SHIPMENT_ID_BY_INVOICE_ID_FROM_DELIVERY_ORDER_DETAIL_TABLE),
                mapSqlParameterSource,DeliveryOrderEntity.class);
        if (orderModel.isEmpty() || TextUtils.isEmpty(orderModel.get(0).getOrder_id())){
            return errorMessage("201","No Order Created For This invoice");
        }
        MapSqlParameterSource updateCourierId = new MapSqlParameterSource();
        updateCourierId.addValue("courier_code",courierId);
        updateCourierId.addValue("invoice_id",invoiceId);
        var orderDate = repository.updateStatus(queryService.get(StringConstants.UPDATE_COURIER_CODE_IN_DELIVERY_ORDER_DETAIL_TABLE),
                updateCourierId);
        var awbRes = generateAwn(orderModel.get(0).getShipment_id(), orderModel.get(0).getCourier_code());
        LinkedHashMap<String, Object> result = (LinkedHashMap<String, Object>) awbRes;
        if (result.containsValue("status_code") && (int)result.get("status_code") != 200){
            return awbRes;
        }
        if (result.containsValue("response")) {
            LinkedHashMap<String, Object> item = (LinkedHashMap<String, Object>) result.get("response");
            if (result.containsValue("awb_code")) {
                var awb_code = item.get("awb_code");
                MapSqlParameterSource updateAwbCode = new MapSqlParameterSource();
                updateAwbCode.addValue("awb_code",awb_code);
                updateAwbCode.addValue("invoice_id",invoiceId);
                repository.updateStatus(queryService.get(StringConstants.UPDATE_AWB_ORDER_IN_DELIVERY_ORDER_DETAIL_TABLE),
                        updateAwbCode);
            }
        }

        return awbRes;
    }


    /**
     * Method to create awn ( Air way bill number)
     * @param shipmentId Shipment Id
     * @param courierId  Courier Id
     */
    public Object generateAwn(final String shipmentId, final String courierId) {
        var url = shipmentUrl4 + "?shipment_id=" + shipmentId + "&courier_id=" + courierId;
        LOG.info("service : awb request :: {}", url);
        return apiWebService.sendAPI(null, url, HttpMethod.POST);
    }


    /**
     * Method to generate the pick up.
     * @param invoiceId invoiceId
     * @return obj
     */
    public Object generatePickUp(final String invoiceId) {
        var orderModel =getCurrentOrder(invoiceId);
        if (orderModel.isEmpty() || TextUtils.isEmpty(orderModel.get(0).getOrder_id())){
            return errorMessage("201","No Order Created For This invoice");
        }
        if (TextUtils.isEmpty(orderModel.get(0).getShipment_id())){
            return errorMessage("201","No Shipment Id found !!");
        }
        if (orderModel.get(0).getStatus().equals("CANCELED")){
            return errorMessage("201","Order Is Already Cancelled !!");
        }
        var url = shipmentUrl6 + "/?shipment_id=" + orderModel.get(0).getShipment_id();

        LOG.info("report service : generate pickup :: {}", url);
        return apiWebService.sendAPI(null, url, HttpMethod.POST);
    }

    /*
    * Method use to track the orders with awb code
    * @param invoiceId invoiceId
    * */
    public Object getAwbTrackingDetails(String invoiceId){
        var orderModel = getCurrentOrder(invoiceId);
        if (orderModel.isEmpty() || TextUtils.isEmpty(orderModel.get(0).getOrder_id())){
            return errorMessage("201","No Order Created For This invoice");
        }
        if (TextUtils.isEmpty(orderModel.get(0).getAwb_code())){
            return errorMessage("201","Air Way bill Not Found !!");
        }
        var url = shipmentUrl7 + orderModel.get(0).getAwb_code();
        return apiWebService.sendAPI(null,url, HttpMethod.GET);
    }

    /*
     * Method use to track the orders with shipment id
     * @param invoiceId invoiceId
     * */
    public Object getAwbTrackingWithShipmentIdDetails(String invoiceId){
        var orderModel = getCurrentOrder(invoiceId);
        if (orderModel.isEmpty() || TextUtils.isEmpty(orderModel.get(0).getOrder_id())){
            return errorMessage("201","No Order Created For This invoice");
        }
        if (TextUtils.isEmpty(orderModel.get(0).getShipment_id())){
            return errorMessage("201","Shipment id Not Found !!");
        }
        var url = shipmentUrl8 + orderModel.get(0).getShipment_id();
        return apiWebService.sendAPI(null,url, HttpMethod.GET);
    }
    /*
    * Method to cancel the order
    * @param invoiceId invoiceId
    * */
    public Object cancelPendingDeliveryOrder(final String invoiceId){
        var orderModel = getCurrentOrder(invoiceId);
        if (orderModel.isEmpty() || TextUtils.isEmpty(orderModel.get(0).getOrder_id())){
            return errorMessage("201","No Order Found !!");
        }
        if (orderModel.get(0).getStatus().equals("CANCELED")){
            return errorMessage("201","This Order Is Already Cancelled !!");
        }
        HashMap<String , int[]> cancelRequest = new HashMap<>();
        int[] orderIds = new int[] {Integer.parseInt(orderModel.get(0).getOrder_id())};
        cancelRequest.put("ids",orderIds);
        Object response = apiWebService.sendAPI(cancelRequest,shipmentUrl9, HttpMethod.POST);

        LinkedHashMap<String, Object> result = (LinkedHashMap<String, Object>) response;
        if ((int)result.get("status_code") == 200) {
            MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
            mapSqlParameterSource.addValue("status", "CANCELED");
            mapSqlParameterSource.addValue("invoice_id", invoiceId);
            repository.updateStatus(queryService.get(StringConstants.UPDATE_STATUS_IN_DELIVERY_ORDER_DETAIL_TABLE),
                    mapSqlParameterSource);
        }
        return response;
    }

    /*
    * Method use to generate error message
    * */
    public Object errorMessage(String status, String message){
        HashMap<String,String> errorResponse =  new HashMap<>();
        errorResponse.put("status",status);
        errorResponse.put("message",message);
        return errorResponse;
    }
    public List<DeliveryOrderEntity> getCurrentOrder(String invoiceId){
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("invoice_id",invoiceId);
        return repository.fetchData(queryService.get(StringConstants.FETCH_ORDER_VALUE_FROM_DELIVERY_ORDER_DETAIL_TABLE),
                mapSqlParameterSource,DeliveryOrderEntity.class);
    }






    /**
     * Method to process message from mobile
     *
     * @param webHooksObject waSendRequest
     */
    public String processWAWebHooks(final WAWebHooksObject webHooksObject) {
        System.out.println(webHooksObject.getHub_verify_token());
        // Update Code
        return "OK";
    }

    /**
     * Method to process message from mobile
     *
     * @param waSendRequest waSendRequest
     */
    public String processGetWAStatus(final WASendRequest waSendRequest)  {
        // waSendRequest.getMessageId();
        // get load values and send it back.
        // Update Code
        return "OK";
    }

    /**
     * Method to process message from mobile
     *
     * @param waSendRequest waSendRequest
     */
    public WASendResponse processMessage(final WASendRequest waSendRequest)  {
        LOG.info("login :: {}", waSendRequest.getMessageId());

        try {

        WASendAPIObject waSendAPIObject = WASendAPIObjectConverter.getWAData(waSendRequest);
        String value = null;

            value = WASendAPIObjectConverter.toJsonString(waSendAPIObject);


        System.out.println("Data :" + value);
        var waResponse = waWebService.sendAPI(waSendAPIObject);

        WASendResponse waSendResponse = new WASendResponse();
        waSendResponse.setMessageId(waSendRequest.getMessageId());
        waSendResponse.setCustomerCode(waSendRequest.getCustomerCode());
        waSendResponse.setDbStatus("P");
        waSendResponse.setWaStatus("SEND");
        waSendResponse.setMessageContent(waSendRequest.getMessageContent());
        waSendResponse.setInvoiceNo(waSendRequest.getInvoiceNo());
        if (waResponse.getMessages().length > 0)
            waSendResponse.setWaMessageId(waResponse.getMessages()[0].getID());

        repository.insert(queryService.get(StringConstants.INSERT_WHATSAPP_MESSAGE), waSendResponse);
            return waSendResponse;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }




}
