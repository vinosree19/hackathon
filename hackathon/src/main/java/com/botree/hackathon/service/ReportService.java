package com.botree.hackathon.service;

import com.botree.hackathon.constants.StringConstants;
import com.botree.hackathon.dao.DAORepository;
import com.botree.hackathon.exception.ServiceException;
import com.botree.hackathon.model.DownloadModel;
import com.botree.hackathon.model.OrderHeaderEntity;
import com.botree.hackathon.model.PendingOrderDetailEntity;
import com.botree.hackathon.model.PendingOrderHeaderEntity;
import com.botree.hackathon.model.ReportModel;
import com.botree.hackathon.util.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URISyntaxException;
import java.util.stream.Collectors;

/**
 * Class contains the report generation logic.
 * @author vinodkumara
 */
@Service
@Transactional
public class ReportService {

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

    /** repository. */
    private final DAORepository repository;
    /** queryService. */
    private final IQueryService queryService;
    /** apiWebService. */
    private final ApiWebService apiWebService;

    /**
     * Constructor method.
     * @param repositoryIn    repositoryIn
     * @param queryServiceIn  queryServiceIn
     * @param apiWebServiceIn apiWebServiceIn
     */
    public ReportService(final DAORepository repositoryIn, final IQueryService queryServiceIn,
                         final ApiWebService apiWebServiceIn) {
        this.repository = repositoryIn;
        this.queryService = queryServiceIn;
        this.apiWebService = apiWebServiceIn;
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
                        StringConstants.FETCH_PENDING_ORDER_HEADER_ENTITY_FOR_REPORT), PendingOrderHeaderEntity.class,
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
    public void createAdhocPendingDeliveryOrder(final OrderHeaderEntity order) {
        try {
            LOG.info("login :: {}", order.getOrder_id());
            apiWebService.sendPostAPI(order, shipmentUrl1);
        } catch (URISyntaxException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Method to create pending delivery order.
     * @param order order
     */
    public void createPendingDeliveryOrder(final OrderHeaderEntity order) {
        try {
            LOG.info("login :: {}", order.getOrder_id());
            apiWebService.sendPostAPI(order, shipmentUrl2);
        } catch (URISyntaxException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Method to create awn ( Air way bill number)
     * @param shipmentId Shipment Id
     * @param courierId Courier Id
     */
    public void generateAwn(String shipmentId, String courierId){
        try {
            String object = "{ shipmentId : "+ shipmentId +", courierId : "+ courierId +" }";
            LOG.info("report service : awb request :: {}", object);
            apiWebService.sendPostAPI(object, shipmentUrl4);
        } catch (URISyntaxException e) {
            throw new ServiceException(e);
        }
    }
    public void getAvailableServices(){
        try {
            apiWebService.getGetAPI(shipmentUrl5);
        } catch (URISyntaxException e) {
            throw new ServiceException(e);
        }
    }

    public void generatePickUp(final String shipmentId){
        try {
            LOG.info("report service : generate pickup :: {}", shipmentId);
            apiWebService.sendPostAPI(shipmentId,shipmentUrl6);
        } catch (URISyntaxException e) {
            throw new ServiceException(e);
        }
    }

}
