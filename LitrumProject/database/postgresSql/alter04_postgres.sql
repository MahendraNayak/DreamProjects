    create table load_unit (
        id int8 not null,
        unit_name varchar(255) not null,
        primary key (id)
    );

    create table main_item (
        id int8 not null,
        image_name varchar(255),
        long_description varchar(2000),
        main_item_name varchar(255),
        short_description varchar(500),
        tech_spec_name varchar(255),
        load_unit_id int8 not null,
        sub_sub_main_categoryId int8 not null,
        primary key (id)
    );

    create table main_item_contractor (
        id int8 not null,
        contractor_name varchar(255),
        contractor_priority varchar(255),
        contractor_rate varchar(255),
        main_item_id int8 not null,
        rate_city_id int8 not null,
        primary key (id)
    );

    create table main_item_maker (
        id int8 not null,
        maker_name varchar(255),
        maker_priority varchar(255),
        maker_rate float8,
        main_item_id int8 not null,
        rate_city_id int8 not null,
        primary key (id)
    );

    create table rate_city (
        id int8 not null,
        city varchar(255),
        country varchar(255),
        state varchar(255),
        street varchar(255),
        primary key (id)
    );

    create table sub_main_item (
        id int8 not null,
        short_description varchar(500),
        load_unit_id int8 not null,
        main_item_id int8 not null,
        primary key (id)
    );

    create table sub_main_item_maker (
        id int8 not null,
        sub_main_item_maker_name varchar(255),
        sub_main_item_maker_rate float8,
        rate_city_id int8 not null,
        sub_main_item_id int8 not null,
        primary key (id)
    );

        create table sub_main_item_contractor (
        id int8 not null,
        sub_main_item_contractor_name varchar(255),
        sub_main_item_contractor_rate float8,
        rate_city_id int8 not null,
        sub_main_item_id int8 not null,
        primary key (id)
    );

    alter table sub_main_item
        add constraint FK_load_unit
        foreign key (load_unit_id)
        references load_unit;

    alter table sub_main_item
        add constraint FK_main_item
        foreign key (main_item_id)
        references main_item;

    alter table load_unit
        add constraint UK_unit_name  unique (unit_name);

    alter table main_item
        add constraint FK_load_unit
        foreign key (load_unit_id)
        references load_unit;

    alter table main_item
        add constraint FK_sub_sub_maincategory
        foreign key (sub_sub_main_categoryId)
        references sub_sub_main_category;

       alter table main_item_contractor
        add constraint FK_main_item
        foreign key (main_item_id)
        references main_item;

    alter table main_item_contractor
        add constraint FK_rate_city
        foreign key (rate_city_id)
        references rate_city;

        alter table main_item_maker
        add constraint FK_main_item
        foreign key (main_item_id)
        references main_item;

    alter table main_item_maker
        add constraint FK_rate_city
        foreign key (rate_city_id)
        references rate_city;


    alter table sub_main_item_maker
        add constraint FK_rate_city
        foreign key (rate_city_id)
        references rate_city;

    alter table sub_main_item_maker
        add constraint FK_sub_main_item
        foreign key (sub_main_item_id)
        references sub_main_item;

    alter table sub_main_item_contractor
        add constraint FK_rate_city
        foreign key (rate_city_id)
        references rate_city;

    alter table sub_main_item_contractor
        add constraint FK_sub_main_item
        foreign key (sub_main_item_id)
        references sub_main_item;
