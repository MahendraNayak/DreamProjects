alter table registration add column user_login_role varchar(255) not null;
alter table registration add column service_offered_id int8 not null;
alter table registration add column company_type_id int8 not null;
alter table registration add column end_user_id int8 not null;

alter table registration
        add constraint UK_username  unique (user_name);

alter table registration
        add constraint FK_registration_service_offered
        foreign key (service_offered_id)
        references service_offered;

alter table registration
        add constraint FK_registration_company_type
        foreign key (company_type_id)
        references company_type;

alter table registration
        add constraint FK_registration_enduser_role
        foreign key (end_user_id)
        references enduser_role;





