insert into Address (id, line_one, line_two, city, county, country, post_code) values (1, '123 Street', 'Abc Road', 'Leeds', 'Yorkshire', 'England', 'LS26 7BH');
insert into Phone_Number (id, country_code, number) values (1, '+44', '7469210907');
insert into Contact (id, name, email, address_id, phone_numbers_id, contact_type) values (1, 'Grace', 'ghogan@gmail.com', 1 , 1,'PERSONAL');

insert into Address (id, line_one, line_two, city, county, country, post_code) values (2, '456 Street', 'Def Road', 'Newcastle', 'Tyne and Wear', 'England', 'NE2 4DG');
insert into Phone_Number (id, country_code, number) values (2, '+44', '7483927374');
insert into Contact (id, name, email, address_id, phone_numbers_id, contact_type) values (2, 'Shona', 'shona@gmail.com',2, 2,'WORK');
