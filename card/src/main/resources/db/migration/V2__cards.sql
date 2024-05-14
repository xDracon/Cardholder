create table cards (
                       id                    bigserial,
                       number                bigint not null,
                       user_id               bigint not null,
                       primary key (id)
);

create table shops (
                       id                    serial,
                       name                  varchar(50) not null,
                       primary key (id)
);

CREATE TABLE cards_shops (
                             card_id               bigint not null,
                             shop_id               bigint not null,
                             primary key (card_id, shop_id),
                             foreign key (card_id) references cards (id),
                             foreign key (shop_id) references shops (id)
);

insert into shops (name)
values
    ('MAGNIT'), ('FIXPRICE');

insert into cards (number, user_id)
values
    ('2141244134124', '1'), ('212122114214', '2');

insert into cards_shops (card_id, shop_id)
values
    (1, 1),
    (2, 2);