create table users(
	id bigserial PRIMARY KEY,     
	firstname VARCHAR(255) NOT NULL,
	lastname VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	role VARCHAR(255) NOT NULL,
	CONSTRAINT unique_email UNIQUE (email)
);

create table permission_group(
	id bigserial PRIMARY KEY, 
	group_name VARCHAR(100) NOT NULL
);

create table permission(
	id bigserial PRIMARY KEY, 
	user_email VARCHAR(100) NOT NULL,
	permission_level VARCHAR(100) NOT NULL,
	group_id INT NOT NULL,
	FOREIGN KEY (group_id) REFERENCES permission_group(id)
);

create table item(
	id bigserial PRIMARY KEY, 
	type VARCHAR(100) NOT NULL,
	name VARCHAR(100) NOT NULL,
	permission_group_id INT NOT NULL,
	parent_item_id INT NULL,
	FOREIGN KEY (permission_group_id) REFERENCES permission_group(id),
	FOREIGN KEY (parent_item_id) REFERENCES item(id)
);

-- create table files(
-- 	id bigserial PRIMARY KEY, 
-- 	binary_file bytea NOT NULL,
-- 	item_id INT NOT NULL,
-- 	FOREIGN KEY (item_id) REFERENCES item(id)
-- );

insert into permission_group(group_name) values('USER_GROUP');
insert into permission_group(group_name) values('ADMIN_GROUP');