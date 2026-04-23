DROP TABLE IF EXISTS addresses;

CREATE TABLE addresses(
id INT auto_increment primary key,
user_id int,
street varchar(255),
city varchar(200),
state varchar(100),
pincode varchar(10),
constraint fk_user foreign key (user_id) references users(id) on delete cascade
);

INSERT INTO addresses(user_id, street, city, state, pincode)
VALUES
(12, '221B MG Road', 'Mumbai', 'Maharashtra', '400001'),
(27, '14 Brigade Road', 'Bengaluru', 'Karnataka', '560001'),
(4, '45 Anna Salai', 'Chennai', 'Tamil Nadu', '600002'),
(19, '12 Jubilee Hills', 'Hyderabad', 'Telangana', '500033'),
(8, '89 Park Street', 'Kolkata', 'West Bengal', '700016'),
(22, '77 Koregaon Park', 'Pune', 'Maharashtra', '411001'),
(15, '101 SG Highway', 'Ahmedabad', 'Gujarat', '380015'),
(3, '12 Malviya Nagar', 'Jaipur', 'Rajasthan', '302017'),
(29, '54 Hazratganj', 'Lucknow', 'Uttar Pradesh', '226001'),
(10, '33 Connaught Place', 'New Delhi', 'Delhi', '110001'),
(1, '88 VIP Road', 'Surat', 'Gujarat', '395007'),
(25, '19 Civil Lines', 'Kanpur', 'Uttar Pradesh', '208001'),
(17, '22 Dharampeth', 'Nagpur', 'Maharashtra', '440010'),
(6, '5 AB Road', 'Indore', 'Madhya Pradesh', '452001'),
(14, '44 Gokhale Marg', 'Bhopal', 'Madhya Pradesh', '462001'),
(30, '99 MVP Colony', 'Visakhapatnam', 'Andhra Pradesh', '530017'),
(9, '121 Frazer Road', 'Patna', 'Bihar', '800001'),
(21, '76 Alkapuri', 'Vadodara', 'Gujarat', '390007'),
(2, '34 Raj Nagar', 'Ghaziabad', 'Uttar Pradesh', '201002'),
(11, '11 Ferozepur Road', 'Ludhiana', 'Punjab', '141001'),
(24, '67 Taj Road', 'Agra', 'Uttar Pradesh', '282001'),
(7, '89 College Road', 'Nashik', 'Maharashtra', '422005'),
(18, '45 Sector 15', 'Faridabad', 'Haryana', '121007'),
(5, '23 Abu Lane', 'Meerut', 'Uttar Pradesh', '250001'),
(28, '12 Kalawad Road', 'Rajkot', 'Gujarat', '360005'),
(13, '90 Lanka Road', 'Varanasi', 'Uttar Pradesh', '221005'),
(26, '65 Sector 17', 'Chandigarh', 'Chandigarh', '160017'),
(20, '44 Mall Road', 'Mysuru', 'Karnataka', '570001'),
(16, '88 Station Road', 'Thane', 'Maharashtra', '400601'),
(23, '14 Residency Road', 'Srinagar', 'Jammu & Kashmir', '190001');