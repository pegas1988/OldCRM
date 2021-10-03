select myuser.first_name, myuser.last_name, type
from myuser
left join
material on myuser.user_id = material_id
where material_id = null;

select sex, last_name, product_name
from client
right join product
on client_id = product_id
where client_id is null;

select user_role , avg(user_id)
from myuser
group by (user_role);
