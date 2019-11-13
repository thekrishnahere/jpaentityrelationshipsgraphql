create
	table
		`bookstore`.`book` ( `book_id` VARCHAR(255)  not null,
		`name` VARCHAR(100) null,
		`category` VARCHAR(100) not null,
		primary key (`book_id`) ) ENGINE = INNODB character set
		utf8 collate utf8_general_ci;


create
	table
		`bookstore`.`author` ( `author_id` varchar(255) not null,
		`name` varchar(100) null,
		primary key (`author_id`) ) ENGINE = INNODB character set
		utf8 collate utf8_general_ci;

create
	table
		`bookstore`.`authorbooks` ( `author_book_id` varchar(255) not null,
		`author` varchar(255) not null,
		`book` varchar(255) not null,
		constraint `Constr_authorbooks_author_fk` foreign key `author_fk` (`author`) references `author` (`author_id`) on
		delete
			cascade on
			update
				cascade,
		constraint `Constr_authorbooks_book_fk` foreign key `book_fk` (`book`) references `book` (`book_id`) on
		delete
			cascade on
			update
				cascade,
				primary key (`author_book_id`),
				unique key `UK_author_book` (`author`, `book`)
				) ENGINE = INNODB character set
		utf8 collate utf8_general_ci;

create trigger `bookstore`.init_uuid BEFORE INSERT ON `bookstore`.`book` FOR EACH ROW SET NEW.book_id = UUID();

create trigger `bookstore`.init_uuid_author BEFORE INSERT ON `bookstore`.`author` FOR EACH ROW SET NEW.author_id = UUID();

create trigger `bookstore`.init_uuid_authorbooks BEFORE INSERT ON `bookstore`.`authorbooks` FOR EACH ROW SET NEW.author_book_id = UUID();

