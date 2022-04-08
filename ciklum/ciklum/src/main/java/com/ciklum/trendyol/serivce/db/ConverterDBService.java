package com.ciklum.trendyol.serivce.db;

import com.ciklum.trendyol.domain.LinkConverterEntity;

/**
 * Interface Layer between service and repository with REQUIRED methods
 */
public interface ConverterDBService {

    LinkConverterEntity save(LinkConverterEntity linkConverterEntity);
}