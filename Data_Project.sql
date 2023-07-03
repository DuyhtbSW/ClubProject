INSERT INTO Admins (AdminName, AdminEmail, AdminPassword)
VALUES ('admin', 'admin@gmail.com', 'admin');

-- Inserting records into the "Users" table with birthdates from 1999 to 2007
INSERT INTO Users (UserName, UserEmail, UserPassword, UserPhone, UserDOB, UserGender, UserStatus, UserImg)
VALUES ('John Doe', 'john.doe@example.com', 'password1', '123456789', '1999-01-01', 'Male', 0, '');

INSERT INTO Users (UserName, UserEmail, UserPassword, UserPhone, UserDOB, UserGender, UserStatus, UserImg)
VALUES ('Jane Smith', 'jane.smith@example.com', 'password2', '987654321', '2000-02-02', 'Female', 0, '');

INSERT INTO Users (UserName, UserEmail, UserPassword, UserPhone, UserDOB, UserGender, UserStatus, UserImg)
VALUES ('Mark Johnson', 'mark.johnson@example.com', 'password3', '456789123', '2001-03-03', 'Male', 0, '');

INSERT INTO Users (UserName, UserEmail, UserPassword, UserPhone, UserDOB, UserGender, UserStatus, UserImg)
VALUES ('Emily Brown', 'emily.brown@example.com', 'password4', '321654987', '2002-04-04', 'Female', 0, '');

INSERT INTO Users (UserName, UserEmail, UserPassword, UserPhone, UserDOB, UserGender, UserStatus, UserImg)
VALUES ('Michael Davis', 'michael.davis@example.com', 'password5', '789123456', '2006-08-08', 'Male', 0, '');

INSERT INTO Users (UserName, UserEmail, UserPassword, UserPhone, UserDOB, UserGender, UserStatus, UserImg)
VALUES ('Sarah Wilson', 'sarah.wilson@example.com', 'password6', '654987321', '2007-09-09', 'Female', 0, '');

INSERT INTO Users (UserName, UserEmail, UserPassword, UserPhone, UserDOB, UserGender, UserStatus, UserImg)
VALUES ('Alexis Johnson', 'alexis.johnson@example.com', 'password7', '123456789', '2004-10-10', 'Female', 0, '');

INSERT INTO Users (UserName, UserEmail, UserPassword, UserPhone, UserDOB, UserGender, UserStatus, UserImg)
VALUES ('Ryan Wilson', 'ryan.wilson@example.com', 'password8', '987654321', '2005-11-11', 'Male', 0, '');

INSERT INTO Users (UserName, UserEmail, UserPassword, UserPhone, UserDOB, UserGender, UserStatus, UserImg)
VALUES ('Olivia Davis', 'olivia.davis@example.com', 'password9', '456789123', '2002-12-12', 'Female', 0, '');

INSERT INTO Users (UserName, UserEmail, UserPassword, UserPhone, UserDOB, UserGender, UserStatus, UserImg)
VALUES ('Ethan Thompson', 'ethan.thompson@example.com', 'password10', '321654987', '2001-01-13', 'Male', 0, '');

INSERT INTO Users (UserName, UserEmail, UserPassword, UserPhone, UserDOB, UserGender, UserStatus, UserImg)
VALUES ('Sophia Clark', 'sophia.clark@example.com', 'password11', '789123456', '2000-02-14', 'Female', 0, '');

INSERT INTO Users (UserName, UserEmail, UserPassword, UserPhone, UserDOB, UserGender, UserStatus, UserImg)
VALUES ('Jacob Adams', 'jacob.adams@example.com', 'password12', '654987321', '2003-03-15', 'Male', 0, '');

INSERT INTO Users (UserName, UserEmail, UserPassword, UserPhone, UserDOB, UserGender, UserStatus, UserImg)
VALUES ('Ava Lee', 'ava.lee@example.com', 'password13', '123456789', '2004-04-16', 'Female', 0, '');



INSERT INTO Clubs (ClubCode, ClubName, ClubDescription, ClubCreatorID, DateCreated, ClubStatus, JoinRequest, CreateRequest, CreateStatus, RemoveStatus, ClubImg)
VALUES ('DEV','Dever', N'Dever là một câu lạc bộ học thuật, theo xu hướng nghiên cứu và phát triển sản phẩm', 1, '2017-11-15', 1, 0, 0, 0, 0, '');

INSERT INTO Clubs (ClubCode, ClubName, ClubDescription, ClubCreatorID, DateCreated, ClubStatus, JoinRequest, CreateRequest, CreateStatus, RemoveStatus, ClubImg)
VALUES ('NYS','NYS Club', N'Name Your Soul CLB Nghệ Thuật FUDN', 2, '2019-10-12', 1, 1, 0, 0, 0, '');

INSERT INTO Clubs (ClubCode, ClubName, ClubDescription, ClubCreatorID, DateCreated, ClubStatus, JoinRequest, CreateRequest, CreateStatus, RemoveStatus, ClubImg)
VALUES ('MJC','Mirai JC', N'FUDA Japanese Club Chúng mình là câu lạc bộ về văn hóa và học thuật của Nhật Bản trực thuộc', 3, '2021-07-15', 1, 0, 0, 0, 0, '');

INSERT INTO Clubs (ClubCode, ClubName, ClubDescription, ClubCreatorID, DateCreated, ClubStatus, JoinRequest, CreateRequest, CreateStatus, RemoveStatus, ClubImg)
VALUES ('VOV',N'FPTU Vovinam club - FVC Đà Nẵng', N'CLB do các sinh viên trường Đại Học FPT Đà Nẵng yêu thích Vovinam thành lập', 4, '2021-01-26', 1, 1, 0, 0, 0, '');

INSERT INTO Clubs (ClubCode, ClubName, ClubDescription, ClubCreatorID, DateCreated, ClubStatus, JoinRequest, CreateRequest, CreateStatus, RemoveStatus, ClubImg)
VALUES ('EVO','EVo - FUDA Event Club', N'CLB sự kiện trực thuộc FPT University Đà Nẵng, CLB báo nhất trường!', 5, '2018-07-23', 1, 0, 0, 0, 0, '');

INSERT INTO Clubs (ClubCode, ClubName, ClubDescription, ClubCreatorID, DateCreated, ClubStatus, JoinRequest, CreateRequest, CreateStatus, RemoveStatus, ClubImg)
VALUES ('FHG','FUDA Hoops Gene', N'Câu lạc bộ Bóng rổ FUDN. Nơi các sinh viên trường Đại học FPT Đà Nẵng được thỏa sức đam mê với bóng rổ', 6, '2019-08-13', 1, 1, 0, 0, 0, '');

INSERT INTO Clubs (ClubCode, ClubName, ClubDescription, ClubCreatorID, DateCreated, ClubStatus, JoinRequest, CreateRequest, CreateStatus, RemoveStatus, ClubImg)
VALUES ('EFL','EFlame', 'English Club FPTU Danang. Leave A Memorable Experience!', 7, '2018-07-18', 1, 0, 0, 0, 0, '');

INSERT INTO Member (UserID, ClubID, IsClubManager, JoinDate, MemberStatus, JoinStatus, KickStatus)
VALUES (1, 1, 1, '2021-01-01', 1, 1, 0);

INSERT INTO Member (UserID, ClubID, IsClubManager, JoinDate, MemberStatus, JoinStatus, KickStatus)
VALUES (2, 2, 1, '2021-02-02', 1, 1, 0);

INSERT INTO Member (UserID, ClubID, IsClubManager, JoinDate, MemberStatus, JoinStatus, KickStatus)
VALUES (3, 3, 1, '2021-03-03', 1, 1, 0);

INSERT INTO Member (UserID, ClubID, IsClubManager, JoinDate, MemberStatus, JoinStatus, KickStatus)
VALUES (4, 4, 1, '2021-04-04', 1, 1, 0);

INSERT INTO Member (UserID, ClubID, IsClubManager, JoinDate, MemberStatus, JoinStatus, KickStatus)
VALUES (5, 5, 1, '2021-05-05', 1, 1, 0);

INSERT INTO Member (UserID, ClubID, IsClubManager, JoinDate, MemberStatus, JoinStatus, KickStatus)
VALUES (6, 6, 1, '2021-06-06', 1, 1, 0);

INSERT INTO Member (UserID, ClubID, IsClubManager, JoinDate, MemberStatus, JoinStatus, KickStatus)
VALUES (7, 7, 1, '2021-07-07', 1, 1, 0);

INSERT INTO Member (UserID, ClubID, IsClubManager, JoinDate, MemberStatus, JoinStatus, KickStatus)
VALUES (8, 1, 0, '2021-08-08', 1, 1, 0);

INSERT INTO Member (UserID, ClubID, IsClubManager, JoinDate, MemberStatus, JoinStatus, KickStatus)
VALUES (9, 2, 0, '2021-09-09', 1, 1, 0);

INSERT INTO Member (UserID, ClubID, IsClubManager, JoinDate, MemberStatus, JoinStatus, KickStatus)
VALUES (10, 3, 0, '2021-10-10', 1, 1, 0);

INSERT INTO Member (UserID, ClubID, IsClubManager, JoinDate, MemberStatus, JoinStatus, KickStatus)
VALUES (11, 4, 0, '2021-11-11', 1, 1, 0);

INSERT INTO Member (UserID, ClubID, IsClubManager, JoinDate, MemberStatus, JoinStatus, KickStatus)
VALUES (12, 5, 0, '2021-12-12', 1, 1, 0);

INSERT INTO Member (UserID, ClubID, IsClubManager, JoinDate, MemberStatus, JoinStatus, KickStatus)
VALUES (13, 6, 0, '2022-01-01', 1, 1, 0);


-- Adding records to the "Rating" table
INSERT INTO Rating (Vote, Note, MemberID, ClubID, RemoveStatus)
VALUES (5, 'Great club!', 1, 1, 0);

INSERT INTO Rating (Vote, Note, MemberID, ClubID, RemoveStatus)
VALUES (4, 'Good club!', 2, 2, 0);

INSERT INTO Rating (Vote, Note, MemberID, ClubID, RemoveStatus)
VALUES (3, 'Average club.', 3, 3, 0);

INSERT INTO Rating (Vote, Note, MemberID, ClubID, RemoveStatus)
VALUES (5, 'Amazing experience!', 4, 4, 0);

INSERT INTO Rating (Vote, Note, MemberID, ClubID, RemoveStatus)
VALUES (2, 'Not satisfied.', 5, 5, 0);

INSERT INTO Rating (Vote, Note, MemberID, ClubID, RemoveStatus)
VALUES (4, 'Fun activities!', 6, 6, 0);

INSERT INTO Rating (Vote, Note, MemberID, ClubID, RemoveStatus)
VALUES (5, 'Highly recommended!', 7, 7, 0);

-- Adding records to the "Post" table
INSERT INTO Post (PostTitle, PostDescription, PostDate, MemberID, ClubID, PostStatus, CreateRequest, CreateStatus, RemoveStatus, PostImg)
VALUES ('My experience at Club XYZ', 'I had a great time at Club XYZ. Highly recommended!', '2022-01-01', 1, 1, 1, 0, 0, 0, '');

INSERT INTO Post (PostTitle, PostDescription, PostDate, MemberID, ClubID, PostStatus, CreateRequest, CreateStatus, RemoveStatus, PostImg)
VALUES ('Club ABC event announcement', 'Join us for an exciting event at Club ABC!', '2022-02-02', 2, 2, 1, 0, 0, 0, '');

INSERT INTO Post (PostTitle, PostDescription, PostDate, MemberID, ClubID, PostStatus, CreateRequest, CreateStatus, RemoveStatus, PostImg)
VALUES ('Looking for new members', 'Our club is looking for enthusiastic individuals to join us!', '2022-03-03', 3, 3, 1, 0, 0, 0, '');

INSERT INTO Post (PostTitle, PostDescription, PostDate, MemberID, ClubID, PostStatus, CreateRequest, CreateStatus, RemoveStatus, PostImg)
VALUES ('Club XYZ updates', 'Stay tuned for the latest updates from Club XYZ.', '2022-04-04', 4, 4, 1, 0, 0, 0, '');

INSERT INTO Post (PostTitle, PostDescription, PostDate, MemberID, ClubID, PostStatus, CreateRequest, CreateStatus, RemoveStatus, PostImg)
VALUES ('My favorite club activities', 'Here are some of my favorite activities at Club ABC.', '2022-05-05', 5, 5, 1, 0, 0, 0, '');

INSERT INTO Post (PostTitle, PostDescription, PostDate, MemberID, ClubID, PostStatus, CreateRequest, CreateStatus, RemoveStatus, PostImg)
VALUES ('Upcoming event at Club XYZ', 'Save the date for our upcoming event at Club XYZ!', '2022-06-06', 6, 6, 1, 0, 0, 0, '');

INSERT INTO Post (PostTitle, PostDescription, PostDate, MemberID, ClubID, PostStatus, CreateRequest, CreateStatus, RemoveStatus, PostImg)
VALUES ('Join us for a workshop', 'Don not miss our workshop on topic X. Register now!', '2022-07-07', 7, 7, 1, 0, 0, 0, '');



-- Thêm dữ liệu vào bảng "PostComment"
INSERT INTO PostComment (CommentContent, CommentDate, PostID, CommenterID, RemoveStatus, CommentImg)
VALUES ('Great post!', '2022-01-01', 1, 1, 0, '');

INSERT INTO PostComment (CommentContent, CommentDate, PostID, CommenterID, RemoveStatus, CommentImg)
VALUES ('I completely agree.', '2022-01-02', 1, 2, 0, '');

INSERT INTO PostComment (CommentContent, CommentDate, PostID, CommenterID, RemoveStatus, CommentImg)
VALUES ('Thanks for sharing.', '2022-01-03', 2, 3, 0, '');

INSERT INTO PostComment (CommentContent, CommentDate, PostID, CommenterID, RemoveStatus, CommentImg)
VALUES ('Interesting perspective.', '2022-01-04', 2, 4, 0, '');

INSERT INTO PostComment (CommentContent, CommentDate, PostID, CommenterID, RemoveStatus, CommentImg)
VALUES ('Looking forward to the event!', '2022-01-05', 3, 5, 0, '');

INSERT INTO PostComment (CommentContent, CommentDate, PostID, CommenterID, RemoveStatus, CommentImg)
VALUES ('Can not wait to join!', '2022-01-06', 3, 6, 0, '');

INSERT INTO PostComment (CommentContent, CommentDate, PostID, CommenterID, RemoveStatus, CommentImg)
VALUES ('I had a similar experience.', '2022-01-07', 4, 7, 0, '');

INSERT INTO PostComment (CommentContent, CommentDate, PostID, CommenterID, RemoveStatus, CommentImg)
VALUES ('Congratulations on the achievement!', '2022-01-08', 4, 8, 0, '');

INSERT INTO PostComment (CommentContent, CommentDate, PostID, CommenterID, RemoveStatus, CommentImg)
VALUES ('I recommend this club!', '2022-01-09', 5, 9, 0, '');

INSERT INTO PostComment (CommentContent, CommentDate, PostID, CommenterID, RemoveStatus, CommentImg)
VALUES ('Well done!', '2022-01-10', 5, 10, 0, '');

-- Thêm dữ liệu vào bảng "EventStatus"
--INSERT INTO EventStatus (StatusName)
--VALUES ('Upcoming');

--INSERT INTO EventStatus (StatusName)
--VALUES ('Ongoing');

--INSERT INTO EventStatus (StatusName)
--VALUES ('Completed');

-- Thêm dữ liệu vào bảng "Event"
INSERT INTO [Event] (EventName, EventDescription, EventDate, ClubID, EventStatus, CreateRequest, CreateStatus, RemoveStatus, EventImg)
VALUES ('Dever Annual Conference', 'Join us for Dever Club annual conference and explore the latest trends!', '2022-11-11', 1, 1, 0, 0, 0, '');

INSERT INTO [Event] (EventName, EventDescription, EventDate, ClubID, EventStatus, CreateRequest, CreateStatus, RemoveStatus, EventImg)
VALUES ('NYS Club Art Exhibition', 'Experience the artistic expressions of NYS Club members through their artworks.', '2022-12-12', 2, 1, 0, 0, 0, '');

INSERT INTO [Event] (EventName, EventDescription, EventDate, ClubID, EventStatus, CreateRequest, CreateStatus, RemoveStatus, EventImg)
VALUES ('Mirai JC Cultural Festival', 'Immerse yourself in Japanese culture through various activities organized by Mirai JC Club.', '2023-01-15', 3, 1, 0, 0, 0, '');

INSERT INTO [Event] (EventName, EventDescription, EventDate, ClubID, EventStatus, CreateRequest, CreateStatus, RemoveStatus, EventImg)
VALUES ('Vovinam Workshop', 'Learn Vovinam martial arts techniques and self-defense skills in this interactive workshop.', '2023-02-20', 4, 1, 0, 0, 0, '');

INSERT INTO [Event] (EventName, EventDescription, EventDate, ClubID, EventStatus, CreateRequest, CreateStatus, RemoveStatus, EventImg)
VALUES ('EVo Networking Night', 'Expand your professional network and connect with industry experts at Evo Club Networking Night.', '2023-03-25', 5, 1, 0, 0, 0, '');

INSERT INTO [Event] (EventName, EventDescription, EventDate, ClubID, EventStatus, CreateRequest, CreateStatus, RemoveStatus, EventImg)
VALUES ('FUDA Hoops Gene Tournament', 'Compete in the FUDA Hoops Gene Club basketball tournament and showcase your skills.', '2023-04-30', 6, 1, 0, 0, 0, '');

INSERT INTO [Event] (EventName, EventDescription, EventDate, ClubID, EventStatus, CreateRequest, CreateStatus, RemoveStatus, EventImg)
VALUES ('EFlame English Speaking Contest', 'Participate in the EFlame Club English speaking contest and showcase your language proficiency.', '2023-05-05', 7, 1, 0, 0, 0, '');

-- Thêm dữ liệu vào bảng "EventAttendees"
INSERT INTO EventAttendees (EventID, MemberID, RemoveStatus)
VALUES (1, 1, 0);

INSERT INTO EventAttendees (EventID, MemberID, RemoveStatus)
VALUES (1, 2, 0);

INSERT INTO EventAttendees (EventID, MemberID, RemoveStatus)
VALUES (2, 3, 0);

INSERT INTO EventAttendees (EventID, MemberID, RemoveStatus)
VALUES (2, 4, 0);

INSERT INTO EventAttendees (EventID, MemberID, RemoveStatus)
VALUES (3, 5, 0);

INSERT INTO EventAttendees (EventID, MemberID, RemoveStatus)
VALUES (4, 6, 0);

INSERT INTO EventAttendees (EventID, MemberID, RemoveStatus)
VALUES (4, 7, 0);

INSERT INTO [Notification] (Title, Note, UserID, ClubID, [Date], [View])
VALUES (N'Create Club', N'Accepted', 1, 1, '', 1);

INSERT INTO [Notification] (Title, Note, UserID, ClubID, [Date], [View])
VALUES (N'Create Club', N'Accepted', 2, 2, '', 1);

INSERT INTO [Notification] (Title, Note, UserID, ClubID, [Date], [View])
VALUES (N'Create Club', N'Accepted', 3, 3, '', 1);

INSERT INTO [Notification] (Title, Note, UserID, ClubID, [Date], [View])
VALUES (N'Create Club', N'Accepted', 4, 4, '', 1);

INSERT INTO [Notification] (Title, Note, UserID, ClubID, [Date], [View])
VALUES (N'Create Club', N'Accepted', 5, 5, '', 1);

INSERT INTO [Notification] (Title, Note, UserID, ClubID, [Date], [View])
VALUES (N'Create Club', N'Accepted', 6, 6, '', 1);

INSERT INTO [Notification] (Title, Note, UserID, ClubID, [Date], [View])
VALUES (N'Create Club', N'Accepted', 7, 7, '', 1);

