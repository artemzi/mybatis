create table mobile
(
  mobile_id    bigint  not null
    constraint mobile_pkey
    primary key,
  cost         integer not null,
  model        varchar(255),
  recense      varchar(255),
  manufacturer varchar
);