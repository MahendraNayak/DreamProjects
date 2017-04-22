alter table main_item alter load_unit_id drop not null;
alter table main_item alter sub_sub_main_categoryid drop not null;

alter table main_item_contractor alter main_item_id drop not null;
alter table main_item_contractor alter rate_city_id drop not null;

alter table main_item_maker alter main_item_id drop not null;
alter table main_item_maker alter rate_city_id drop not null;

alter table sub_main_item alter load_unit_id drop not null;
alter table sub_main_item alter main_item_id drop not null;


alter table sub_main_item_contractor alter sub_main_item_id drop not null;

alter table sub_main_item_maker alter sub_main_item_id drop not null;


alter table main_item drop constraint fk_load_unit;

alter table main_item drop constraint fk_sub_sub_maincategory;

alter table main_item_contractor drop constraint fk_main_item;

alter table main_item_contractor drop constraint fk_rate_city;

alter table main_item_maker drop constraint fk_main_item;

alter table main_item_maker drop constraint fk_rate_city;

alter table sub_main_item drop constraint fk_sub_main_item_load_unit;

alter table sub_main_item drop constraint fk_sub_main_item_main_item;

alter table sub_main_item_contractor drop constraint fk_sub_main_item_contractor_sub_main_item;

alter table sub_main_item_maker drop constraint fk_sub_main_item_maker_sub_main_item;


alter table main_item
        add constraint fk_load_unit
        foreign key (load_unit_id)
        references load_unit
        on delete cascade;

alter table main_item
        add constraint fk_sub_sub_maincategory
        foreign key (sub_sub_main_categoryId)
        references sub_sub_main_category
        on delete cascade;

alter table main_item_contractor
        add constraint fk_main_item
        foreign key (main_item_id)
        references main_item
        on delete cascade;

alter table main_item_contractor
        add constraint fk_rate_city
        foreign key (rate_city_id)
        references rate_city
        on delete cascade;

alter table main_item_maker
        add constraint fk_main_item
        foreign key (main_item_id)
        references main_item
        on delete cascade;

alter table main_item_maker
        add constraint FK_rate_city
        foreign key (rate_city_id)
        references rate_city
        on delete cascade;

alter table sub_main_item
        add constraint fk_sub_main_item_load_unit
        foreign key (load_unit_id)
        references load_unit
        on delete cascade;

alter table sub_main_item
        add constraint fk_sub_main_item_main_item
        foreign key (main_item_id)
        references main_item
        on delete cascade;

alter table sub_main_item_contractor
        add constraint fk_sub_main_item_contractor_sub_main_item
        foreign key (sub_main_item_id)
        references sub_main_item
        on delete cascade;

alter table sub_main_item_maker
        add constraint fk_sub_main_item_maker_sub_main_item
        foreign key (sub_main_item_id)
        references sub_main_item
        on delete cascade;

