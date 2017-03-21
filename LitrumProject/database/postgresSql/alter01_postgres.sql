
    create table company_details (
        id int8 not null,
        company_city varchar(255),
        company_type_id int8,
        end_user_role_id int8,
        end_user_id int8,
        service_offered_id int8,
        primary key (id)
    );

    create table company_type (
        id int8 not null,
        type varchar(255) not null,
        primary key (id)
    );

    create table enduser_role (
        id int8 not null,
        role_name varchar(255) not null,
        primary key (id)
    );

    create table registration (
        id int8 not null,
        email_Id varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        mobile_No varchar(255),
        password varchar(255) not null,
        user_name varchar(255) not null,
        primary key (id)
    );

    create table service_offered (
        id int8 not null,
        name varchar(255) not null,
        primary key (id)
    );

    alter table company_type
        add constraint UK_type  unique (type);

    alter table enduser_role
        add constraint UK_role  unique (role_name);

    alter table company_details
        add constraint FK_company_details_company_type
        foreign key (company_type_id)
        references company_type;

    alter table company_details
        add constraint FK_company_details_enduser_role
        foreign key (end_user_role_id)
        references enduser_role;

    alter table company_details
        add constraint FK_company_details_registration
        foreign key (end_user_id)
        references registration;

    alter table company_details
        add constraint FK_company_details_service_offered
        foreign key (service_offered_id)
        references service_offered;

    create sequence hibernate_sequence;
