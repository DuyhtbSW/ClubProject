create table Admins(
AdminID int identity(1,1) NOT NULL,
AdminName nvarchar(255) NOT NULL,
AdminEmail varchar(255) NOT NULL,
AdminPassword varchar(255) NOT NULL,
primary key(AdminID)
)

create table Users(
UserID int identity(1,1) NOT NULL,
UserName nvarchar(255) NOT NULL,
UserEmail varchar(255) NOT NULL,
UserPassword varchar(255) NOT NULL,
UserPhone varchar(255) NOT NULL,
UserDOB date NULL DEFAULT NULL,
UserGender nvarchar(255) NOT NULL,
UserStatus bit default 0,
UserImg nvarchar(255) NOT NULL,
primary key(UserID)
)

create table Clubs(
ClubID int identity(1,1) NOT NULL,
ClubCode varchar(255) NOT NULL,
ClubName nvarchar(255) NOT NULL,
ClubDescription nvarchar(255) NOT NULL,
ClubCreatorID int NOT NULL,
DateCreated date NULL DEFAULT NULL,
ClubStatus bit default 0,
JoinRequest bit default 0,
CreateRequest bit default 0,
CreateStatus bit default 0,
RemoveStatus bit default 0,
ClubImg nvarchar(255) NOT NULL,
primary key(ClubID),
foreign key (ClubCreatorID) references Users (UserID)
)

create table Member(
MemberID int identity(1,1) NOT NULL,
UserID int NOT NULL,
ClubID int NOT NULL,
-- 0 = false : ko phai manager
IsClubManager bit default 0,
JoinDate date NULL DEFAULT NULL,
MemberStatus bit default 0,
JoinStatus bit default 0,
KickStatus bit default 0,
primary key(MemberID),
foreign key (UserID) references Users (UserID),
foreign key (ClubID) references Clubs (ClubID)
)

create table Rating(
RatingID int identity(1,1) NOT NULL,
Vote tinyint NOT NULL,
Note nvarchar(255) NOT NULL,
MemberID int NOT NULL,
ClubID int NOT NULL,
RemoveStatus bit default 0,
primary key(RatingID),
foreign key (MemberID) references Member (MemberID),
foreign key (ClubID) references Clubs (ClubID)
)

create table Post(
PostID int identity(1,1) NOT NULL,
PostTitle nvarchar(255) NOT NULL,
PostDescription nvarchar(255) NOT NULL,
PostDate date NULL DEFAULT NULL,
MemberID int NOT NULL,
ClubID int NOT NULL,
PostStatus bit default 0,
CreateRequest bit default 0,
CreateStatus bit default 0,
RemoveStatus bit default 0,
PostImg nvarchar(255) NOT NULL,
primary key(PostID),
foreign key (MemberID) references Member (MemberID),
foreign key (ClubID) references Clubs (ClubID)
)

create table PostComment(
PostCommentID int identity(1,1) NOT NULL,
CommentContent nvarchar(255) NOT NULL,
CommentDate date NULL DEFAULT NULL,
PostID int NOT NULL,
CommenterID int NOT NULL,
RemoveStatus bit default 0,
CommentImg nvarchar(255) NOT NULL,
primary key(PostCommentID),
foreign key (PostID) references Post (PostID),
foreign key (CommenterID) references Member (MemberID)
)

create table [Event](
EventID int identity(1,1) NOT NULL,
EventName nvarchar(255) NOT NULL,
EventDescription nvarchar(255) NOT NULL,
EventDate date NULL DEFAULT NULL,
ClubID int NOT NULL,
EventStatus bit default 0,
CreateRequest bit default 0,
CreateStatus bit default 0,
RemoveStatus bit default 0,
EventImg nvarchar(255) NOT NULL,
primary key(EventID),
foreign key (ClubID) references Clubs (ClubID)
)

create table EventAttendees(
EventAttendeesID int identity(1,1) NOT NULL,
EventID int NOT NULL,
MemberID int NOT NULL,
RemoveStatus bit default 0,
primary key(EventAttendeesID),
foreign key (EventID) references [Event] (EventID),
foreign key (MemberID) references Member (MemberID)
)

create table [Notification](
NotificationID int identity(1,1) NOT NULL,
Title nvarchar(255) NOT NULL,
Note nvarchar(255) NOT NULL,
UserID int NOT NULL,
GeneralID int NOT NULL,
[Date] date NULL DEFAULT NULL,
[View] bit default 0,
primary key(NotificationID),
foreign key (UserID) references Users (UserID),
foreign key (GeneralID) references Clubs (ClubID),
foreign key (GeneralID) references Member (MemberID),
foreign key (GeneralID) references Post (PostID),
foreign key (GeneralID) references [Event] (EventID)
)

create table [Notification](
NotificationID int identity(1,1) NOT NULL,
Title nvarchar(255) NOT NULL,
Note nvarchar(255) NOT NULL,
UserID int NOT NULL,
ClubID int NULL,
MemberID int NULL,
PostID int NULL,
EventID int NULL,
[Date] date NULL DEFAULT NULL,
[View] bit default 0,
primary key(NotificationID),
foreign key (UserID) references Users (UserID),
foreign key (ClubID) references Clubs (ClubID),
foreign key (MemberID) references Member (MemberID),
foreign key (PostID) references Post (PostID),
foreign key (EventID) references [Event] (EventID)
)
drop table [Notification]

create table Chat(
ChatID int identity(1,1) NOT NULL,
ChatContent nvarchar(255) NOT NULL,
ChatDate datetime NULL DEFAULT NULL,
SenderID int NOT NULL,
RecipientID int NOT NULL,
ClubID int NOT NULL,
RemoveStatus bit default 0,
primary key(ChatID),
foreign key (SenderID) references Member (MemberID),
foreign key (RecipientID) references Member (MemberID),
foreign key (ClubID) references Clubs (ClubID)
)
