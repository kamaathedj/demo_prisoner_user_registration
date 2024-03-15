
create table if not exists warden(id int primary key generated always as identity(increment 1 ),
                    name varchar(255) not null,
                    password varchar(255) not null, number_of_prisoner bigint, is_admin bool);