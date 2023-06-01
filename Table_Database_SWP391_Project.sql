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
UserDOB date,
UserGender nvarchar(255) NOT NULL,
primary key(UserID)
)

create table Clubs(
ClubID int identity(1,1) NOT NULL,
ClubCode varchar(255) NOT NULL,
ClubName nvarchar(255) NOT NULL,
ClubDescription nvarchar(255) NOT NULL,
ClubCreatorID int NOT NULL,
DateCreated date,
ClubStatus nvarchar(255) NOT NULL,
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
Note nvarchar(255) NOT NULL,
ClubID int NOT NULL,
UserID int NOT NULL,
primary key(RatingID),
foreign key (ClubID) references Clubs (ClubID),
foreign key (UserID) references Users (UserID),
)

create table Post(
PostID int identity(1,1) NOT NULL,
PostTitle nvarchar(255) NOT NULL,
PostDescription nvarchar(255) NOT NULL,
PostDated date,
UserID int NOT NULL,
ClubID int NOT NULL,
primary key(PostID),
foreign key (ClubID) references Clubs (ClubID),
foreign key (UserID) references Users (UserID)
)

create table PostComment(
PostCommentID int identity(1,1) NOT NULL,
CommentContent nvarchar(255) NOT NULL,
CommentDated date,
PostID int NOT NULL,
CommentorID int NOT NULL,
primary key(PostCommentID),
foreign key (PostID) references Post (PostID),
foreign key (CommentorID) references Users (UserID)
)

create table EventStatus(
StatusID int identity(1,1) NOT NULL,
StatusName nvarchar(10) NOT NULL,
primary key(StatusID)
)

create table [Event](
EventID int identity(1,1) NOT NULL,
EventName nvarchar(255) NOT NULL,
EventDesription nvarchar(255) NOT NULL,
EventDated date,
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