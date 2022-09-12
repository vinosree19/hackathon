package com.botree.hackathon.service;


public interface IQueryService {
    /**
     * This method is used to get the query.
     * @param queryName queryName
     * @return string
     */
    String get(String queryName);
}
