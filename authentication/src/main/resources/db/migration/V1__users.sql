create table users (
                       id                    bigserial,
                       username              varchar(50) not null unique,
                       password              varchar(80) not null,
                       firstname             varchar(30) not null,
                       surname               varchar(80) not null,
                       patronymic            varchar(80) not null,
                       phonenumber           varchar(80) not null,
                       primary key (id)
);

create table roles (
                       id                    serial,
                       name                  varchar(50) not null,
                       primary key (id)
);

CREATE TABLE users_roles (
                             user_id               bigint not null,
                             role_id               int not null,
                             primary key (user_id, role_id),
                             foreign key (user_id) references users (id),
                             foreign key (role_id) references roles (id)
);

insert into roles (name)
values
    ('ROLE_USER'), ('ROLE_ADMIN');

insert into users (username, password, firstname,  surname,  patronymic, phonenumber)
values
    ('user@gmail.com', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user',  'ivanov', 'ivanivich', '88005553535'),
    ('admin@gmail.com', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'admin', 'petrov', 'petrovich', '77777777777');

insert into users_roles (user_id, role_id)
values
    (1, 1),
    (2, 2);