package com.ciklum.trendyol.serivce.db.impl;

import com.ciklum.trendyol.domain.LinkConverterEntity;
import com.ciklum.trendyol.repository.LinkConverterRepository;
import com.ciklum.trendyol.serivce.db.ConverterDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Layer between service and repository with REQUIRED methods
 */

@Service
@RequiredArgsConstructor
public class ConverterDBServiceImpl implements ConverterDBService {

    private final LinkConverterRepository linkConverterRepository;

    /**
     * @param linkConverterEntity
     * @return linkConverterEntity
     */
    @Override
    public LinkConverterEntity save(LinkConverterEntity linkConverterEntity) {
        return this.linkConverterRepository.save(linkConverterEntity);
    }
}
