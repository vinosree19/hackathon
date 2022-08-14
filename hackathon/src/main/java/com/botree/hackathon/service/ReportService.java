package com.botree.hackathon.service;

import com.botree.hackathon.constants.StringConstants;
import com.botree.hackathon.dao.DAORepository;
import com.botree.hackathon.model.DownloadModel;
import com.botree.hackathon.model.PendingOrderDetailEntity;
import com.botree.hackathon.model.PendingOrderHeaderEntity;
import com.botree.hackathon.model.ReportModel;
import com.botree.hackathon.util.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /** repository. */
    private final DAORepository repository;

    /** queryService. */
    private final IQueryService queryService;

    /**
     * Constructor method.
     * @param repositoryIn   repositoryIn
     * @param queryServiceIn queryServiceIn
     */
    public ReportService(final DAORepository repositoryIn, final IQueryService queryServiceIn) {
        this.repository = repositoryIn;
        this.queryService = queryServiceIn;
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
}
