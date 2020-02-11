create table beverages
(
    beverageID   int auto_increment
        primary key,
    beverageName varchar(50) not null,
    price        varchar(45) not null
)
    charset = utf8;

create table payement_controle
(
    ID           int auto_increment
        primary key,
    table_number int        not null,
    orderNumber  int        not null,
    payed        tinyint(1) null
);

create table waiters
(
    waiterID  int auto_increment
        primary key,
    lastName  varchar(50) not null,
    firstName varchar(50) not null,
    password  varchar(50) not null
)
    charset = utf8;

create table orders
(
    ID          int auto_increment
        primary key,
    orderNumber int  not null,
    beverageID  int  not null,
    qty         int  not null,
    date        date not null,
    waiterID    int  not null,
    constraint FK_BEVERAGE
        foreign key (beverageID) references beverages (beverageID),
    constraint FK_WAITER
        foreign key (waiterID) references waiters (waiterID)
)
    charset = utf8;

create index FK_BEVERAGE_idx
    on orderLines (beverageID);

create index FK_WAITER_idx
    on orderLines (waiterID);