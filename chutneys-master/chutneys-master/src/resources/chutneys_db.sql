/**
 * Creates required tables for the first the application is started on a system
 * 
 */

--DROP TABLE menu;
--DROP TABLE menu_item;

CREATE TABLE IF NOT EXISTS menu (id INT PRIMARY KEY, 
	 						menu_name VARCHAR(255));
	 						

CREATE TABLE IF NOT EXISTS menu_item (id INT PRIMARY KEY,
                            menu_id INT,
	 						item_name VARCHAR(255),
	 						description VARCHAR(255),
	 						image_url VARCHAR(255),
	 						veg_type VARCHAR(255),
	 						cost INT(255),
	 					    FOREIGN KEY (menu_id) REFERENCES public.menu(id));

DELETE FROM menu_item; 	 					    
DELETE FROM menu; 

INSERT INTO menu (id, menu_name) values (1, 'STARTERS');
INSERT INTO menu (id, menu_name) values (2, 'TIFFINS');
INSERT INTO menu (id, menu_name) values (3, 'MAIN_COURSE');
INSERT INTO menu (id, menu_name) values (4, 'THALI');
INSERT INTO menu (id, menu_name) values (5, 'DESERTS');


INSERT INTO menu_item (id, menu_id, item_name, description, image_url, veg_type, cost) values (101, 1, 'Veg Noodle Soup', 'Veg Creme Soupe with hakka noodles', null,'true',120);
INSERT INTO menu_item (id, menu_id, item_name, description, image_url, veg_type, cost) values (102, 1, 'Tomata Soup', 'Tomata Hot Soupe served with pickle and ginger', null,'true',100);
INSERT INTO menu_item (id, menu_id, item_name, description, image_url, veg_type, cost) values (103, 1, 'JalJeera', 'Served as codl, with Jeera and mint', null,'true',150);

INSERT INTO menu_item (id, menu_id, item_name, description, image_url, veg_type, cost) values (201, 2, 'Idly', 'Soft batter made into small balls and steam cooked', null,'true',250);
INSERT INTO menu_item (id, menu_id, item_name, description, image_url, veg_type, cost) values (202, 2, 'Plain Dosa', 'Thin batter cooked on tawa, served hot', null,'true',300);
INSERT INTO menu_item (id, menu_id, item_name, description, image_url, veg_type, cost) values (203, 2, 'Masala Dosa', 'Thin batter cooked on tawa, served hot with stuffed Masala', null,'true',300);
INSERT INTO menu_item (id, menu_id, item_name, description, image_url, veg_type, cost) values (204, 2, 'Onion Dosa', 'Thin batter cooked on tawa, served hot with stuffed Onion', null,'true',300);

INSERT INTO menu_item (id, menu_id, item_name, description, image_url, veg_type, cost) values (301, 3, 'Dal Fry', 'Yellow lentils cooked, and with little salt and chilli', null,'true',200);
INSERT INTO menu_item (id, menu_id, item_name, description, image_url, veg_type, cost) values (302, 3, 'Bengan Fry', 'Eggplant - cooked on flame and softly crushed', null,'true',300);

INSERT INTO menu_item (id, menu_id, item_name, description, image_url, veg_type, cost) values (401, 4, 'South Indian Veg Thali', 'Rice, Dal, Pappad, Curd, Pickle', null,'true',400);
INSERT INTO menu_item (id, menu_id, item_name, description, image_url, veg_type, cost) values (402, 4, 'North Indian Veg Thali', 'Roti, Dal, Lassi, Pickle', null,'true',400);

INSERT INTO menu_item (id, menu_id, item_name, description, image_url, veg_type, cost) values (501, 5, 'Kulfi', 'Milk shake cold and served with pista badams', null,'true',100);
INSERT INTO menu_item (id, menu_id, item_name, description, image_url, veg_type, cost) values (502, 5, 'Sweet Lassi', 'Lassi with Sugar', null,'true',100);
INSERT INTO menu_item (id, menu_id, item_name, description, image_url, veg_type, cost) values (503, 5, 'Salt Lassi', 'Lassi with Salt', null,'true',100);

