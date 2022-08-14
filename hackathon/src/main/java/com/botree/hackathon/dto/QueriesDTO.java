package com.botree.hackathon.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * This service class is used to fetch query from xml.
 * @author Ashok Saravanan M.(Emp Id : 522)
 * Copyright © 2017 to present Botree Software. All rights reserved.
 */

@XmlRootElement(name = "queries")
public class QueriesDTO {
    /**
     * queries.
     */
    private List<QueryDTO> queries;

    /**
     * @return the queries
     */
    @XmlElement(name = "query", type = QueryDTO.class)
    public final List<QueryDTO> getQueries() {
        return queries;
    }

    /**
     * @param queriesIn the queries to set
     */
    public final void setQueries(final List<QueryDTO> queriesIn) {
        queries = queriesIn;
    }
}
