CREATE TABLE `Member` (
	`MemberID`	VARCHAR(15)	NULL,
	`PASSWORD`	VARCHAR(20)	NULL,
	`NAME`	VARCHAR(15)	NULL,
	`NICKNAME`	VARCHAR(30)	NULL
);

CREATE TABLE `Post` (
	`PostNumber`	INT	NOT NULL,
	`PostTitle`	VARCHAR(50)	NULL,
	`PostDate`	DATE	NULL,
	`Views`	INT	NULL,
	`Likes`	INT	NULL,
	`Content`	VARCHAR(2000)	NULL,
	`ID`	VARCHAR(15)	NULL,
	`GalleryNumber`	INT	NULL
);

CREATE TABLE `Category` (
	`CategoryID`	INT	NOT NULL,
	`CategorName`	VARCHAR(15)	NULL
);

CREATE TABLE `Gallery` (
	`GalleryNumber`	INT	NULL,
	`GalleryTitle`	VARCHAR(20)	NULL,
	`CategoryID`	INT	NOT NULL
);

CREATE TABLE `Comment` (
	`commentNumber`	INT	NOT NULL,
	`commentContent`	VARCHAR(1000)	NULL,
	`commentDate`	DATE	NULL,
	`ID`	VARCHAR(15)	NULL,
	`PostNumber`	INT	NOT NULL
);

ALTER TABLE `Member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`MemberID`
);

ALTER TABLE `Post` ADD CONSTRAINT `PK_POST` PRIMARY KEY (
	`PostNumber`
);

ALTER TABLE `Category` ADD CONSTRAINT `PK_CATEGORY` PRIMARY KEY (
	`CategoryID`
);

ALTER TABLE `Gallery` ADD CONSTRAINT `PK_GALLERY` PRIMARY KEY (
	`GalleryNumber`
);

ALTER TABLE `Comment` ADD CONSTRAINT `PK_COMMENT` PRIMARY KEY (
	`commentNumber`
);

INSERT INTO Category
VALUES(1, '갤러리');
INSERT INTO Category
VALUES(2, '마이너갤러리');
INSERT INTO Category
VALUES(3, '미니갤러리');

INSERT INTO Member
VALUES('ID1', 'PW1', 'Name1', 'NICK1');
INSERT INTO Member
VALUES('ID2', 'PW2', 'Name2', 'NICK2');
INSERT INTO Member
VALUES('ID3', 'PW3', 'Name3', 'NICK3');

INSERT INTO Gallery
VALUES(1, '해외축구', 1);
INSERT INTO Gallery
VALUES(2, '미국 농구', 2);
INSERT INTO Gallery
VALUES(3, '이세계아이돌', 3);
INSERT INTO Gallery
VALUES(4, '비트코인', 1);

INSERT INTO Post
VALUES(1, '제목1', '2000-01-01', 0, 0, 'Content1', 1, 1);
INSERT INTO Post
VALUES(2, '제목2', '2000-02-02', 0, 0, 'Content2',1, 1);
INSERT INTO Post
VALUES(3, '제목3', '2000-03-01', 0, 0, 'Content3', 2, 1);
INSERT INTO Post
VALUES(4, '제목4', '2000-01-01', 0, 0, 'Content4', 3, 1);

INSERT INTO Comment
VALUES(1, 'Comment1', '2000-01-01', 1, 1);
INSERT INTO Comment
VALUES(2, 'Comment2', '2000-01-01', 1, 1);
INSERT INTO Comment
VALUES(3, 'Comment3', '2000-01-01', 2, 1);
INSERT INTO Comment
VALUES(4, 'Comment4', '2000-01-01', 3, 1);

desc Member;
desc Category;
desc Gallery;
desc Post;
desc Comment;