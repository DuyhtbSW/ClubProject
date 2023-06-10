select * from Admins
where AdminEmail = 'admin@gmail.com' and AdminPassword = 'admin'

select * from Admins
where AdminEmail = ? and AdminPassword = ?

delete from Admins
where AdminID = 2

select * from Users
where UserEmail = 'huy@gmail.com' and UserPassword = '123'

select * from Users
where UserEmail = 'huy2@gmail.com'

insert into Users
values ( '', 'huy2@gmail.com', '123', '', '', '')

INSERT INTO Users (UserName, UserEmail, UserPassword, UserPhone, UserDOB, UserGender)
VALUES ('Huy', 'huy@gmail.com', '123', '123456789', '1999-01-01', 'Male');

update Users
set UserName = 'huy',
UserEmail = 'huy2@gmail.com',
UserPhone = '0123423424',
UserDOB = '2000-04-27',
UserGender = 'Be de'
where UserID = 28

select * from Users
where UserID = 14

delete from Users
where UserID = 22

INSERT INTO Member (ClubID, UserID, IsClubManager, JoinDated)
VALUES (14, 2, 0, '2021-01-01');

INSERT INTO Member (ClubID, UserID, IsClubManager, JoinDated)
VALUES (14, 3, 1, '2021-03-03');

select * from Clubs
where ClubID = 14

delete from Clubs
where ClubID = 13

drop table Clubs

insert into Clubs
values ( 'TET', 'Tester', N'Tester là câu lạc bộ dành cho những người thích testing các phần mềm', '14', '2018-07-29')

SELECT Users.UserName
FROM Clubs INNER JOIN Users 
ON Clubs.ClubCreatorID = Users.UserID 
WHERE Clubs.ClubCreatorID = 1

SELECT Clubs.ClubID, Clubs.ClubCode, Clubs.ClubName , Clubs.ClubDescription, Users.UserName, Clubs.DateCreated
FROM Clubs INNER JOIN Users 
ON Clubs.ClubCreatorID = Users.UserID 
WHERE Clubs.ClubID = 1 and Clubs.ClubCreatorID = 1

select * from Clubs
where ClubCreatorID = 14

select * from Member
where Member.ClubID = 14

SELECT Users.UserName
FROM Member
INNER JOIN Users ON Member.UserID = Users.UserID
WHERE Member.ClubID = 1

SELECT Users.UserID, Users.UserName, Users.UserDOB, Users.UserGender
FROM Member
INNER JOIN Users ON Member.UserID = Users.UserID
WHERE Member.ClubID = 14 AND Member.UserID <> 14 AND IsClubManager = 1 AND Member.MemberStatus = 1

SELECT Users.UserID, Users.UserName, Users.UserDOB, Users.UserGender
FROM Member
INNER JOIN Users ON Member.UserID = Users.UserID
WHERE Member.ClubID = 14 AND Member.UserID <> 14 AND IsClubManager = 0 AND Member.MemberStatus = 1

select * from Clubs
where ClubID = 14

select * from Post
where ClubID = 14 and PostStatus = 1

INSERT INTO Post (PostTitle, PostDesription, PostDate, UserID, ClubID)
VALUES (N'Đi chơi đêss', N'Ai đi chơi comment vào nha !', '2022-01-01', 14, 14);

SELECT Users.UserName
FROM Post
INNER JOIN Users ON Post.UserID = Users.UserID
WHERE Post.PostID = 8

INSERT INTO PostComment (CommentContent, CommentDate, PostID, CommentorID)
VALUES ('Ko ik choi au', '2022-01-01', 8, 14);

select * from Post

select * from PostComment

update Clubs
set ClubCode = 'TES',
ClubName = N'Tester 2',
ClubDescription = N'Tester là câu lạc bộ dành cho những người thích testing các phần mềm.'
where ClubID = 14

UPDATE Member
SET IsClubManager = 1
WHERE UserID = 14 AND ClubID = 14

SELECT PC.PostCommentID, PC.CommentContent, PC.CommentDated, PC.PostID, U.UserName
FROM PostComment PC
JOIN Users U ON PC.CommentorID = U.UserID
WHERE PC.PostID = 8

delete from PostComment
where PostCommentID = 17

SELECT IsClubManager
FROM Member JOIN Clubs
ON Member.ClubID = Clubs.ClubID
WHERE UserID = 14 AND Member.IsClubManager = 1

SELECT m.IsClubManager
FROM Member m
JOIN Clubs c ON m.ClubID = c.ClubID
WHERE m.UserID = 23
  AND m.IsClubManager = 1
  AND m.UserID != c.ClubCreatorID

INSERT INTO Member (ClubID, UserID, IsClubManager, JoinDated, MemberStatus)
VALUES (14, 23, 1, '2022-05-23', 0);

select * from Users

select * from Clubs
where ClubID = 14 and JoinRequest = 1

SELECT Member.UserID, Users.UserName, Member.JoinDated
FROM Member JOIN Users
ON Member.UserID = Users.UserID
WHERE ClubID = 14 AND Member.UserID = 14 AND MemberStatus = 1

update Member
set JoinDated = '',
MemberStatus = 0
where ClubID = 14 and UserID = 24

update Member
set MemberStatus = 0
where ClubID = 14 and UserID = 24

delete Member
where ClubID = 14 and UserID = 24 and MemberStatus = 0

select * from Clubs
where JoinRequest = 1

delete Member
where ClubID = 14 and UserID = 24 and IsClubManager = 0 and MemberStatus = 1

Select * from Clubs Where clubStatus = 0

Select * from Clubs WHERE clubstatus = 1
