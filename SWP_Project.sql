create table Admins(
AdminID int identity(1,1) NOT NULL,
AdminName varchar(255) NOT NULL,
AdminEmail varchar(255) NOT NULL,
AdminPassword varchar(255) NOT NULL,
primary key(AdminID)
)

create table Users(
UserID int identity(1,1) NOT NULL,
UserName varchar(255) NOT NULL,
UserEmail varchar(255) NOT NULL,
UserPassword varchar(255) NOT NULL,
UserPhone varchar(255) NOT NULL,
UserDOB date,
UserGender varchar(255) NOT NULL,
primary key(UserID)
)

create table Clubs(
ClubID int identity(1,1) NOT NULL,
ClubName varchar(255) NOT NULL,
ClubDesription varchar(255) NOT NULL,
ClubCreatorID int NOT NULL,
DateCreated date,
primary key(ClubID),
foreign key (ClubCreatorID) references Users (UserID)
)

create table Member(
ClubID int NOT NULL,
UserID int NOT NULL,
-- 0 = false : ko phai manager
IsClubManager bit Default 0,
JoinDate date,
primary key(UserID, ClubID),
foreign key (UserID) references Users (UserID),
foreign key (ClubID) references Clubs (ClubID)
)

create table Rating(
RatingID int identity(1,1) NOT NULL,
Vote tinyint NOT NULL,
Note varchar(255) NOT NULL,
ClubID int NOT NULL,
UserID int NOT NULL,
primary key(RatingID),
foreign key (ClubID) references Clubs (ClubID),
foreign key (UserID) references Users (UserID),
)

create table Post(
PostID int identity(1,1) NOT NULL,
PostTitle varchar(255) NOT NULL,
PostDesription varchar(255) NOT NULL,
PostDate date,
UserID int NOT NULL,
ClubID int NOT NULL,
primary key(PostID),
foreign key (ClubID) references Clubs (ClubID),
foreign key (UserID) references Users (UserID)
)

create table PostComment(
PostCommentID int identity(1,1) NOT NULL,
CommentContent varchar(255) NOT NULL,
CommentDate date,
PostID int NOT NULL,
CommentorID int NOT NULL,
primary key(PostCommentID),
foreign key (PostID) references Post (PostID),
foreign key (CommentorID) references Users (UserID)
)

create table EventStatus(
StatusID int identity(1,1) NOT NULL,
StatusName varchar(10) NOT NULL,
primary key(StatusID)
)

create table [Event](
EventID int identity(1,1) NOT NULL,
EventName varchar(255) NOT NULL,
EventDesription varchar(255) NOT NULL,
EventDate date,
ClubID int NOT NULL,
UserID int NOT NULL,
StatusID int NOT NULL,
primary key(EventID),
foreign key (StatusID) references EventStatus (StatusID),
foreign key (ClubID) references Clubs (ClubID),
foreign key (UserID) references Users (UserID)
)

create table EventAttendees(
EventID int NOT NULL,
UserID int NOT NULL,
primary key(UserID, EventID),
foreign key (EventID) references [Event] (EventID),
foreign key (UserID) references Users (UserID)
)