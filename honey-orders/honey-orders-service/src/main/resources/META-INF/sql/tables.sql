create table manager_odr_Honey (
	id_ LONG not null primary key,
	type_ VARCHAR(75) null,
	price INTEGER,
	stock BOOLEAN
);

create table manager_odr_Order (
	id_ LONG not null primary key,
	dateOrder DATE null,
	customer VARCHAR(75) null,
	status INTEGER,
	address VARCHAR(75) null
);

create table manager_odr_OrderInfo (
	id_ LONG not null primary key,
	orderid LONG,
	type_ LONG,
	amount INTEGER
);