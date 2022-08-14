package com.botree.hackathon.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * This service class is used to fetch name and query.
 * @author Ashok Saravanan M.(Emp Id : 522)
 * Copyright © 2017 to present Botree Software. All rights reserved.
 */

@XmlRootElement(name = "query")
@XmlAccessorType(XmlAccessType.FIELD)
public class QueryDTO {
    /**
     * name.
     */
    @XmlAttribute
    private String name;
    /**
     * query.
     */
    @XmlValue
    private String query;

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
     * @return the query
     */
    public final String getQuery() {
        return query;
    }

    /**
     * @param queryIn the query to set
     */
    public final void setQuery(final String queryIn) {
        query = queryIn;
    }
}
