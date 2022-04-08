package com.ciklum.trendyol.serivce.mapper;

import com.ciklum.trendyol.domain.LinkConverterEntity;
import com.ciklum.trendyol.domain.enums.LinkType;
import org.mapstruct.Mapper;

/**
 * LinkConverterEntity mapper
 */
@Mapper(componentModel = "spring")
public interface  LinkMapper {
    /**
     *
     * @param requestLink as String
     * @param responseLink as String
     * @param responseLinkType as String
     * @return LinkConverterEntity
     */
    LinkConverterEntity toEntity(String requestLink, String responseLink, LinkType responseLinkType);
}
