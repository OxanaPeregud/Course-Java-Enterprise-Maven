drop table if exists pizza;
create table if not exists pizza
(
    pizza_id  int auto_increment
        primary key,
    pizza_name varchar(255) not null,
    pizza_cost        float         not null
);

insert into pizza(pizza_name, pizza_cost)
values ('Four Cheese', 5.5);

drop table if exists ingredient;
create table if not exists ingredient
(
    ingredient_id int auto_increment
        primary key,
    ingredient_name     varchar(255) not null,
    ingredient_cost      float        not null
);

insert into ingredient(ingredient_name, ingredient_cost)
values ('Cheese', 1.0);
