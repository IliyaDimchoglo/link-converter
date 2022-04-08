create table link_converter
(
    id                 uuid         not null
        constraint link_converter_pkey
            primary key,
    created_time       timestamp,
    updated_time       timestamp,
    request_link       varchar(255) not null,
    response_link      varchar(255) not null,
    response_link_type varchar(255) not null
);