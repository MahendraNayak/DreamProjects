    create table main_category (
        id int8 not null,
        active_flag int4,
        category_name varchar(255) not null,
        primary key (id)
    );

    create table sub_main_category (
        id int8 not null,
        active_flag int4,
        sub_main_category_name varchar(255) not null,
        main_category_id int8,
        primary key (id)
    );

    create table sub_sub_main_category (
        id int8 not null,
        active_flag int4,
        sub_sub_main_category_name varchar(255) not null,
        sub_main_category_id int8,
        primary key (id)
    );

    create table registration (
        id int8 not null,
        company_name varchar(255),
        email_Id varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        mobile_No varchar(255),
        password varchar(255) not null,
        user_name varchar(255) not null,
        company_city_id int8 not null,
        primary key (id)
    );

    create table service_offered (
        id int8 not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table company_type (
        id int8 not null,
        type varchar(255) not null,
        service_offered_id int8 not null,
        primary key (id)
    );

    create table enduser_role (
        id int8 not null,
        role_name varchar(255) not null,
        company_type_id int8 not null,
        primary key (id)
    );

    create table company_city (
        id int8 not null,
        city_name varchar(255) not null,
        primary key (id)
    );

    alter table sub_main_category
        add constraint FK_sub_main_category
        foreign key (main_category_id)
        references main_category;

    alter table sub_sub_main_category
        add constraint FK_sub_main_category
        foreign key (sub_main_category_id)
        references sub_main_category;

    alter table company_city
        add constraint UK_city_name  unique (city_name);

    alter table service_offered
        add constraint UK_name  unique (name);

    alter table company_type
        add constraint FK_company_type_service_offered
        foreign key (service_offered_id)
        references service_offered;

    alter table enduser_role
        add constraint FK_enduser_role_company_type
        foreign key (company_type_id)
        references company_type;


    create sequence hibernate_sequence;
