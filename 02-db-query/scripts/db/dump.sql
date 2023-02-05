

create table Users(
	user_id bigserial PRIMARY KEY, 
	username VARCHAR(100) NOT NULL
);


create table Training_details(
	user_training_id bigserial PRIMARY KEY, 
	user_id INT NOT NULL,
	training_id INT NOT NULL,
	training_date date,
	FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

insert into Users(user_id, username) values(1, 'John Doe');
insert into Users(user_id, username) values(2, 'Jane Don');
insert into Users(user_id, username) values(3, 'Alice Jones');
insert into Users(user_id, username) values(4, 'Lisa Romero');


insert into Training_details(user_training_id, user_id, training_id, training_date)  values(1, 1, 1, '2015-8-02');
insert into Training_details(user_training_id, user_id, training_id, training_date)  values(2, 2, 1, '2015-8-03');
insert into Training_details(user_training_id, user_id, training_id, training_date)  values(3, 3, 2, '2015-8-02');
insert into Training_details(user_training_id, user_id, training_id, training_date)  values(4, 4, 2, '2015-8-04');
insert into Training_details(user_training_id, user_id, training_id, training_date)  values(5, 2, 2, '2015-8-03');
insert into Training_details(user_training_id, user_id, training_id, training_date)  values(6, 1, 1, '2015-8-02');
insert into Training_details(user_training_id, user_id, training_id, training_date)  values(7, 3, 2, '2015-8-04');
insert into Training_details(user_training_id, user_id, training_id, training_date)  values(8, 4, 3, '2015-8-03');
insert into Training_details(user_training_id, user_id, training_id, training_date)  values(9, 1, 4, '2015-8-03');
insert into Training_details(user_training_id, user_id, training_id, training_date)  values(10, 3, 1, '2015-8-02');
insert into Training_details(user_training_id, user_id, training_id, training_date)  values(11, 4, 2, '2015-8-04');
insert into Training_details(user_training_id, user_id, training_id, training_date)  values(12, 3, 2, '2015-8-02');
insert into Training_details(user_training_id, user_id, training_id, training_date)  values(13, 1, 1, '2015-8-02');
insert into Training_details(user_training_id, user_id, training_id, training_date)  values(14, 4, 3, '2015-8-03');



SELECT t.user_id, u.username, t.training_id, t.training_date, COUNT(t.training_id) 
FROM training_details t JOIN users u 
ON (u.user_id = t.user_id)
GROUP BY u.username,t.user_id, t.training_id, t.training_date
HAVING COUNT(t.training_id) > 1
ORDER BY t.training_date DESC;

