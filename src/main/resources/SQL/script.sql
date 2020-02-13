DROP TABLE IF EXISTS orderlines;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS beverages;
DROP TABLE IF EXISTS waiters;

create table beverages
(
    beverageID   int auto_increment
        primary key,
    beverageName varchar(50) not null,
    price        varchar(45) not null
);

create table waiters
(
    waiterID  int auto_increment
        primary key,
    lastName  varchar(50) not null,
    firstName varchar(50) not null,
    password  varchar(50) not null
);
create table orders
(
    ID           int auto_increment
        primary key,
    table_number int        not null,
    payed        tinyint(1) null,
    waiterID     int        null,
    date         date       null,
    constraint WAITER_FK
        foreign key (waiterID) references waiters (waiterID)
);

create table orderlines
(
    ID          int auto_increment
        primary key,
    orderNumber int not null,
    beverageID  int not null,
    qty         int not null,
    constraint FK_BEVERAGE
        foreign key (beverageID) references beverages (beverageID),
    constraint FK_ORDERS
        foreign key (orderNumber) references orders (ID)
);
create index FK_BEVERAGE_idx
    on orderlines (beverageID);


