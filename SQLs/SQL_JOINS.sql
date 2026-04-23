-- Inner Join

select users.name, users.email, addresses.city, addresses.pincode, addresses.id as address_id, users.id as user_id
from users
inner join addresses on users.id = addresses.user_id;

-- Left Join
select users.name, users.email, addresses.city, addresses.pincode, addresses.id as address_id
from users
left join addresses on users.id = addresses.user_id;

-- Right Join
select users.name, users.email, addresses.city, addresses.pincode, addresses.id as address_id
from users
right join addresses on users.id = addresses.user_id;

-- Self Join
select a.id, a.name as user_name,
b.name as reffered_by_name
from users a
inner join users b on a.reffered_by_id = b.id;