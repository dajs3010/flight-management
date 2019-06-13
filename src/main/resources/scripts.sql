create table flight_request
(
    id            serial                                        not null
        constraint flight_request_pk
            primary key,
    name          varchar(255)                                  not null,
    travel_date   timestamp                                     not null,
    destination   varchar(255)                                  not null,
    status        varchar(100) default 'NEW'::character varying,
    request_date  timestamp    default now()                    ,
    reserved_date timestamp
);