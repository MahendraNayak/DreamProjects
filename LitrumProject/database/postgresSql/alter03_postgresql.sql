create table admin_user_registration (
        id int8 not null,
        email_id varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        mobile varchar(255),
        password varchar(255) not null,
        user_login_role varchar(255) not null,
        user_name varchar(255) not null,
        admin_user_role_id int8 not null,
        main_category_id int8 not null,
        primary key (id)
    );

alter table admin_user_registration
        add constraint UK_username  unique (user_name);

alter table admin_user_registration
        add constraint FK_admin_user_role
        foreign key (admin_user_role_id)
        references admin_user_role;

alter table admin_user_registration
        add constraint FK_main_category
        foreign key (main_category_id)
        references main_category;
