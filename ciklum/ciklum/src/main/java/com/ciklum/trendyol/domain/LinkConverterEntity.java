package com.ciklum.trendyol.domain;


import com.ciklum.trendyol.domain.enums.LinkType;
import lombok.*;

import javax.persistence.*;

/**
 * Entity of links (request link as String, responseLink as String, response Link Type as Enum)
 */
@Entity
@Getter
@Setter
@Builder
@Table(name = "link_converter")
@NoArgsConstructor
@AllArgsConstructor
public class LinkConverterEntity extends BaseEntity {

    @Column(nullable = false)
    private String requestLink;

    @Column(nullable = false)
    private String responseLink;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LinkType responseLinkType;
}
