CREATE TABLE `book` (
	`id` varchar(36) NOT NULL,
	`judul_buku` varchar(255) NOT NULL,
	`publisher_id` varchar(36) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `book_detail` (
	`id` varchar(36) NOT NULL,
	`sinposis` varchar(255) NOT NULL,
	`harga` double NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `publisher` (
	`id` varchar(36) NOT NULL,
	`publisher-name` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `author` (
	`id` varchar(36) NOT NULL,
	`name` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `book_author` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`book_id` varchar(36) NOT NULL,
	`author_id` varchar(36) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `category` (
	`id` varchar(36) NOT NULL,
	`name` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `book_category` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`book_id` varchar(36) NOT NULL,
	`category_id` varchar(36) NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `book` ADD CONSTRAINT `book_fk0` FOREIGN KEY (`id`) REFERENCES `book_detail`(`id`);

ALTER TABLE `book` ADD CONSTRAINT `book_fk1` FOREIGN KEY (`publisher_id`) REFERENCES `publisher`(`id`);

ALTER TABLE `book_detail` ADD CONSTRAINT `book_detail_fk0` FOREIGN KEY (`id`) REFERENCES `book`(`id`);

ALTER TABLE `book_author` ADD CONSTRAINT `book_author_fk0` FOREIGN KEY (`book_id`) REFERENCES `book`(`id`);

ALTER TABLE `book_author` ADD CONSTRAINT `book_author_fk1` FOREIGN KEY (`author_id`) REFERENCES `author`(`id`);

ALTER TABLE `book_category` ADD CONSTRAINT `book_category_fk0` FOREIGN KEY (`book_id`) REFERENCES `book`(`id`);

ALTER TABLE `book_category` ADD CONSTRAINT `book_category_fk1` FOREIGN KEY (`category_id`) REFERENCES `category`(`id`);








