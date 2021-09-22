create table my_orders_Honey (
	id_ LONG not null primary key,
	type_ VARCHAR(75) null,
	price INTEGER,
	stock BOOLEAN
);

create table my_orders_OrderInfo (
	id_ LONG not null primary key,
	type_ VARCHAR(75) null,
	amount INTEGER
);

create table my_orders_Orders (
	id_ LONG not null primary key,
	dateOrder DATE null,
	customer VARCHAR(75) null,
	orderinfo LONG,
	status INTEGER
);