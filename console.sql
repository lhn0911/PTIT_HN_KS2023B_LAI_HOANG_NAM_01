create database db;
#drop database db;
use db;
create table Category
(
    category_id   int primary key auto_increment,
    category_name varchar(50) not null unique,
    description   text,
    status        bit default 1
);
create table Product
(
    product_id int primary key auto_increment,
    product_name varchar(100) not null,
    description text,
    price double not null check ( price>0 ),
    image_url varchar(255),
    status bit default 1,
    created_at datetime,
    category_id int not null,
    foreign key (category_id) references Category(category_id)
);

delimiter //
create procedure find_all_Category()
begin
select * from Category;
end;
create procedure find_byId(c_id int)
begin
select * from Category where category_id = c_id;
end;
create procedure save_Category(c_name varchar(50), c_dec text)
begin
insert into Category( category_name, description)
values (c_name,c_dec);
end;
create procedure update_Category(c_id int, c_name varchar(50), c_dec text, c_status bit)
update Category set category_name = c_name, description =c_dec,status = c_status where category_id = c_id;
delimiter //
create procedure delete_Category(c_id int)
begin
delete from Category where category_id = c_id;
end;
-- ===
delimiter //
create procedure find_all_Product()
begin
select * from Product;
end;
create procedure find_by_Id(c_id int)
begin
select * from Product where product_id = c_id;
end;
create procedure save_product(c_name varchar(100), c_dep text, c_price double, c_img varchar(255), c_cate int)
begin
insert into Product(product_name, description, price, image_url,category_id)
values (c_name,c_dep,c_price,c_img,c_cate);

end;
create procedure update_Product(c_id int, c_name varchar(100), c_dep text, c_price double, c_img varchar(255),c_status bit,c_create datetime, c_cate int)
begin
update Product set product_name = c_name,
                   description = c_dep,
                   price = c_price,
                   image_url = c_img,
                   status = c_status,
                   created_at = c_create,
                   category_id = c_cate where category_id = c_id;
end;
create procedure delete_product(c_id int)
begin
delete from Product where category_id = c_id;
end;
delimiter //