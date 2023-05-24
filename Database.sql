USE [master]
GO
/****** Object:  Database [ClubProject]    Script Date: 5/24/2023 1:41:24 PM ******/
CREATE DATABASE [ClubProject]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ClubProject', FILENAME = N'C:\Database\ClubProject.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'ClubProject_log', FILENAME = N'C:\Database\ClubProject_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [ClubProject] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ClubProject].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ClubProject] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ClubProject] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ClubProject] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ClubProject] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ClubProject] SET ARITHABORT OFF 
GO
ALTER DATABASE [ClubProject] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ClubProject] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ClubProject] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ClubProject] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ClubProject] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ClubProject] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ClubProject] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ClubProject] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ClubProject] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ClubProject] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ClubProject] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ClubProject] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ClubProject] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ClubProject] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ClubProject] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ClubProject] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ClubProject] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ClubProject] SET RECOVERY FULL 
GO
ALTER DATABASE [ClubProject] SET  MULTI_USER 
GO
ALTER DATABASE [ClubProject] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ClubProject] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ClubProject] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ClubProject] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ClubProject] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ClubProject] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'ClubProject', N'ON'
GO
ALTER DATABASE [ClubProject] SET QUERY_STORE = OFF
GO
USE [ClubProject]
GO
/****** Object:  Table [dbo].[Admins]    Script Date: 5/24/2023 1:41:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Admins](
	[AdminID] [int] IDENTITY(1,1) NOT NULL,
	[AdminName] [varchar](255) NOT NULL,
	[AdminEmail] [varchar](255) NOT NULL,
	[AdminPassword] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[AdminID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Clubs]    Script Date: 5/24/2023 1:41:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Clubs](
	[ClubID] [int] IDENTITY(1,1) NOT NULL,
	[ClubName] [varchar](255) NOT NULL,
	[ClubDesription] [varchar](255) NOT NULL,
	[ClubCreatorID] [int] NOT NULL,
	[DateCreated] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[ClubID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Event]    Script Date: 5/24/2023 1:41:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Event](
	[EventID] [int] IDENTITY(1,1) NOT NULL,
	[EventName] [varchar](255) NOT NULL,
	[EventDesription] [varchar](255) NOT NULL,
	[EventDate] [date] NULL,
	[ClubID] [int] NOT NULL,
	[UserID] [int] NOT NULL,
	[StatusID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[EventID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[EventAttendees]    Script Date: 5/24/2023 1:41:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EventAttendees](
	[EventID] [int] NOT NULL,
	[UserID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[UserID] ASC,
	[EventID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[EventStatus]    Script Date: 5/24/2023 1:41:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EventStatus](
	[StatusID] [int] IDENTITY(1,1) NOT NULL,
	[StatusName] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[StatusID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Member]    Script Date: 5/24/2023 1:41:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Member](
	[ClubID] [int] NOT NULL,
	[UserID] [int] NOT NULL,
	[IsClubManager] [bit] NULL,
	[JoinDate] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[UserID] ASC,
	[ClubID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Post]    Script Date: 5/24/2023 1:41:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Post](
	[PostID] [int] IDENTITY(1,1) NOT NULL,
	[PostTitle] [varchar](255) NOT NULL,
	[PostDesription] [varchar](255) NOT NULL,
	[PostDate] [date] NULL,
	[UserID] [int] NOT NULL,
	[ClubID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[PostID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PostComment]    Script Date: 5/24/2023 1:41:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PostComment](
	[PostCommentID] [int] IDENTITY(1,1) NOT NULL,
	[CommentContent] [varchar](255) NOT NULL,
	[CommentDate] [date] NULL,
	[PostID] [int] NOT NULL,
	[CommentorID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[PostCommentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Rating]    Script Date: 5/24/2023 1:41:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Rating](
	[RatingID] [int] IDENTITY(1,1) NOT NULL,
	[Vote] [tinyint] NOT NULL,
	[Note] [varchar](255) NOT NULL,
	[ClubID] [int] NOT NULL,
	[UserID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[RatingID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 5/24/2023 1:41:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[UserID] [int] IDENTITY(1,1) NOT NULL,
	[UserName] [varchar](255) NOT NULL,
	[UserEmail] [varchar](255) NOT NULL,
	[UserPassword] [varchar](255) NOT NULL,
	[UserPhone] [varchar](255) NOT NULL,
	[UserDOB] [date] NULL,
	[UserGender] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Admins] ON 

INSERT [dbo].[Admins] ([AdminID], [AdminName], [AdminEmail], [AdminPassword]) VALUES (1, N'admin', N'admin@gmail.com', N'admin')
SET IDENTITY_INSERT [dbo].[Admins] OFF
GO
SET IDENTITY_INSERT [dbo].[Clubs] ON 

INSERT [dbo].[Clubs] ([ClubID], [ClubName], [ClubDesription], [ClubCreatorID], [DateCreated]) VALUES (1, N'Dever', N'Dever là m?t câu l?c b? h?c thu?t, theo xu hư?ng nghiên c?u và phát tri?n s?n ph?m', 1, CAST(N'2017-11-15' AS Date))
INSERT [dbo].[Clubs] ([ClubID], [ClubName], [ClubDesription], [ClubCreatorID], [DateCreated]) VALUES (2, N'NYS Club', N'Name Your Soul CLB Ngh? Thu?t FUDN', 2, CAST(N'2019-10-12' AS Date))
INSERT [dbo].[Clubs] ([ClubID], [ClubName], [ClubDesription], [ClubCreatorID], [DateCreated]) VALUES (3, N'Mirai JC', N'FUDA Japanese Club Chúng m?nh là câu l?c b? v? văn hóa và h?c thu?t c?a Nh?t B?n tr?c thu?c', 3, CAST(N'2021-07-15' AS Date))
INSERT [dbo].[Clubs] ([ClubID], [ClubName], [ClubDesription], [ClubCreatorID], [DateCreated]) VALUES (4, N'FPTU Vovinam club - FVC Đà N?ng', N'CLB do các sinh viên trư?ng Đ?i H?c FPT Đà N?ng yêu thích Vovinam thành l?p', 4, CAST(N'2021-01-26' AS Date))
INSERT [dbo].[Clubs] ([ClubID], [ClubName], [ClubDesription], [ClubCreatorID], [DateCreated]) VALUES (5, N'EVo - FUDA Event Club', N'CLB s? ki?n tr?c thu?c FPT University Đà N?ng, CLB báo nh?t trư?ng!', 5, CAST(N'2018-07-23' AS Date))
INSERT [dbo].[Clubs] ([ClubID], [ClubName], [ClubDesription], [ClubCreatorID], [DateCreated]) VALUES (6, N'FUDA Hoops Gene', N'Câu l?c b? Bóng r? FUDN. Nơi các sinh viên trư?ng Đ?i h?c FPT Đà N?ng đư?c th?a s?c đam mê v?i bóng r?', 6, CAST(N'2019-08-13' AS Date))
INSERT [dbo].[Clubs] ([ClubID], [ClubName], [ClubDesription], [ClubCreatorID], [DateCreated]) VALUES (7, N'EFlame', N'English Club FPTU Danang. Leave A Memorable Experience!', 7, CAST(N'2018-07-18' AS Date))
SET IDENTITY_INSERT [dbo].[Clubs] OFF
GO
SET IDENTITY_INSERT [dbo].[Event] ON 

INSERT [dbo].[Event] ([EventID], [EventName], [EventDesription], [EventDate], [ClubID], [UserID], [StatusID]) VALUES (1, N'Dever Annual Conference', N'Join us for Dever Club annual conference and explore the latest trends!', CAST(N'2022-11-11' AS Date), 1, 1, 1)
INSERT [dbo].[Event] ([EventID], [EventName], [EventDesription], [EventDate], [ClubID], [UserID], [StatusID]) VALUES (2, N'NYS Club Art Exhibition', N'Experience the artistic expressions of NYS Club members through their artworks.', CAST(N'2022-12-12' AS Date), 2, 2, 1)
INSERT [dbo].[Event] ([EventID], [EventName], [EventDesription], [EventDate], [ClubID], [UserID], [StatusID]) VALUES (3, N'Mirai JC Cultural Festival', N'Immerse yourself in Japanese culture through various activities organized by Mirai JC Club.', CAST(N'2023-01-15' AS Date), 3, 3, 2)
INSERT [dbo].[Event] ([EventID], [EventName], [EventDesription], [EventDate], [ClubID], [UserID], [StatusID]) VALUES (4, N'Vovinam Workshop', N'Learn Vovinam martial arts techniques and self-defense skills in this interactive workshop.', CAST(N'2023-02-20' AS Date), 4, 4, 1)
INSERT [dbo].[Event] ([EventID], [EventName], [EventDesription], [EventDate], [ClubID], [UserID], [StatusID]) VALUES (5, N'EVo Networking Night', N'Expand your professional network and connect with industry experts at Evo Club Networking Night.', CAST(N'2023-03-25' AS Date), 5, 5, 2)
INSERT [dbo].[Event] ([EventID], [EventName], [EventDesription], [EventDate], [ClubID], [UserID], [StatusID]) VALUES (6, N'FUDA Hoops Gene Tournament', N'Compete in the FUDA Hoops Gene Club basketball tournament and showcase your skills.', CAST(N'2023-04-30' AS Date), 6, 6, 3)
INSERT [dbo].[Event] ([EventID], [EventName], [EventDesription], [EventDate], [ClubID], [UserID], [StatusID]) VALUES (7, N'EFlame English Speaking Contest', N'Participate in the EFlame Club English speaking contest and showcase your language proficiency.', CAST(N'2023-05-05' AS Date), 7, 7, 1)
SET IDENTITY_INSERT [dbo].[Event] OFF
GO
INSERT [dbo].[EventAttendees] ([EventID], [UserID]) VALUES (1, 1)
INSERT [dbo].[EventAttendees] ([EventID], [UserID]) VALUES (1, 2)
INSERT [dbo].[EventAttendees] ([EventID], [UserID]) VALUES (2, 3)
INSERT [dbo].[EventAttendees] ([EventID], [UserID]) VALUES (2, 4)
INSERT [dbo].[EventAttendees] ([EventID], [UserID]) VALUES (3, 5)
INSERT [dbo].[EventAttendees] ([EventID], [UserID]) VALUES (4, 6)
INSERT [dbo].[EventAttendees] ([EventID], [UserID]) VALUES (4, 7)
INSERT [dbo].[EventAttendees] ([EventID], [UserID]) VALUES (5, 8)
INSERT [dbo].[EventAttendees] ([EventID], [UserID]) VALUES (5, 9)
INSERT [dbo].[EventAttendees] ([EventID], [UserID]) VALUES (6, 10)
GO
SET IDENTITY_INSERT [dbo].[EventStatus] ON 

INSERT [dbo].[EventStatus] ([StatusID], [StatusName]) VALUES (1, N'Upcoming')
INSERT [dbo].[EventStatus] ([StatusID], [StatusName]) VALUES (2, N'Ongoing')
INSERT [dbo].[EventStatus] ([StatusID], [StatusName]) VALUES (3, N'Completed')
SET IDENTITY_INSERT [dbo].[EventStatus] OFF
GO
INSERT [dbo].[Member] ([ClubID], [UserID], [IsClubManager], [JoinDate]) VALUES (1, 1, 1, CAST(N'2021-01-01' AS Date))
INSERT [dbo].[Member] ([ClubID], [UserID], [IsClubManager], [JoinDate]) VALUES (2, 2, 1, CAST(N'2021-02-02' AS Date))
INSERT [dbo].[Member] ([ClubID], [UserID], [IsClubManager], [JoinDate]) VALUES (3, 3, 1, CAST(N'2021-03-03' AS Date))
INSERT [dbo].[Member] ([ClubID], [UserID], [IsClubManager], [JoinDate]) VALUES (4, 4, 1, CAST(N'2021-04-04' AS Date))
INSERT [dbo].[Member] ([ClubID], [UserID], [IsClubManager], [JoinDate]) VALUES (5, 5, 1, CAST(N'2021-05-05' AS Date))
INSERT [dbo].[Member] ([ClubID], [UserID], [IsClubManager], [JoinDate]) VALUES (6, 6, 1, CAST(N'2021-06-06' AS Date))
INSERT [dbo].[Member] ([ClubID], [UserID], [IsClubManager], [JoinDate]) VALUES (7, 7, 1, CAST(N'2021-07-07' AS Date))
INSERT [dbo].[Member] ([ClubID], [UserID], [IsClubManager], [JoinDate]) VALUES (1, 8, 0, CAST(N'2021-08-08' AS Date))
INSERT [dbo].[Member] ([ClubID], [UserID], [IsClubManager], [JoinDate]) VALUES (2, 9, 0, CAST(N'2021-09-09' AS Date))
INSERT [dbo].[Member] ([ClubID], [UserID], [IsClubManager], [JoinDate]) VALUES (3, 10, 0, CAST(N'2021-10-10' AS Date))
INSERT [dbo].[Member] ([ClubID], [UserID], [IsClubManager], [JoinDate]) VALUES (4, 11, 0, CAST(N'2021-11-11' AS Date))
INSERT [dbo].[Member] ([ClubID], [UserID], [IsClubManager], [JoinDate]) VALUES (5, 12, 0, CAST(N'2021-12-12' AS Date))
INSERT [dbo].[Member] ([ClubID], [UserID], [IsClubManager], [JoinDate]) VALUES (6, 13, 0, CAST(N'2022-01-01' AS Date))
INSERT [dbo].[Member] ([ClubID], [UserID], [IsClubManager], [JoinDate]) VALUES (7, 14, 0, CAST(N'2022-02-02' AS Date))
INSERT [dbo].[Member] ([ClubID], [UserID], [IsClubManager], [JoinDate]) VALUES (1, 16, 0, CAST(N'2022-03-03' AS Date))
INSERT [dbo].[Member] ([ClubID], [UserID], [IsClubManager], [JoinDate]) VALUES (2, 17, 0, CAST(N'2022-04-04' AS Date))
GO
SET IDENTITY_INSERT [dbo].[Post] ON 

INSERT [dbo].[Post] ([PostID], [PostTitle], [PostDesription], [PostDate], [UserID], [ClubID]) VALUES (1, N'My experience at Club XYZ', N'I had a great time at Club XYZ. Highly recommended!', CAST(N'2022-01-01' AS Date), 1, 1)
INSERT [dbo].[Post] ([PostID], [PostTitle], [PostDesription], [PostDate], [UserID], [ClubID]) VALUES (2, N'Club ABC event announcement', N'Join us for an exciting event at Club ABC!', CAST(N'2022-02-02' AS Date), 2, 2)
INSERT [dbo].[Post] ([PostID], [PostTitle], [PostDesription], [PostDate], [UserID], [ClubID]) VALUES (3, N'Looking for new members', N'Our club is looking for enthusiastic individuals to join us!', CAST(N'2022-03-03' AS Date), 3, 3)
INSERT [dbo].[Post] ([PostID], [PostTitle], [PostDesription], [PostDate], [UserID], [ClubID]) VALUES (4, N'Club XYZ updates', N'Stay tuned for the latest updates from Club XYZ.', CAST(N'2022-04-04' AS Date), 4, 4)
INSERT [dbo].[Post] ([PostID], [PostTitle], [PostDesription], [PostDate], [UserID], [ClubID]) VALUES (5, N'My favorite club activities', N'Here are some of my favorite activities at Club ABC.', CAST(N'2022-05-05' AS Date), 5, 5)
INSERT [dbo].[Post] ([PostID], [PostTitle], [PostDesription], [PostDate], [UserID], [ClubID]) VALUES (6, N'Upcoming event at Club XYZ', N'Save the date for our upcoming event at Club XYZ!', CAST(N'2022-06-06' AS Date), 6, 6)
INSERT [dbo].[Post] ([PostID], [PostTitle], [PostDesription], [PostDate], [UserID], [ClubID]) VALUES (7, N'Join us for a workshop', N'Don not miss our workshop on topic X. Register now!', CAST(N'2022-07-07' AS Date), 7, 7)
SET IDENTITY_INSERT [dbo].[Post] OFF
GO
SET IDENTITY_INSERT [dbo].[PostComment] ON 

INSERT [dbo].[PostComment] ([PostCommentID], [CommentContent], [CommentDate], [PostID], [CommentorID]) VALUES (1, N'Great post!', CAST(N'2022-01-01' AS Date), 1, 1)
INSERT [dbo].[PostComment] ([PostCommentID], [CommentContent], [CommentDate], [PostID], [CommentorID]) VALUES (2, N'I completely agree.', CAST(N'2022-01-02' AS Date), 1, 2)
INSERT [dbo].[PostComment] ([PostCommentID], [CommentContent], [CommentDate], [PostID], [CommentorID]) VALUES (3, N'Thanks for sharing.', CAST(N'2022-01-03' AS Date), 2, 3)
INSERT [dbo].[PostComment] ([PostCommentID], [CommentContent], [CommentDate], [PostID], [CommentorID]) VALUES (4, N'Interesting perspective.', CAST(N'2022-01-04' AS Date), 2, 4)
INSERT [dbo].[PostComment] ([PostCommentID], [CommentContent], [CommentDate], [PostID], [CommentorID]) VALUES (5, N'Looking forward to the event!', CAST(N'2022-01-05' AS Date), 3, 5)
INSERT [dbo].[PostComment] ([PostCommentID], [CommentContent], [CommentDate], [PostID], [CommentorID]) VALUES (6, N'Can not wait to join!', CAST(N'2022-01-06' AS Date), 3, 6)
INSERT [dbo].[PostComment] ([PostCommentID], [CommentContent], [CommentDate], [PostID], [CommentorID]) VALUES (7, N'I had a similar experience.', CAST(N'2022-01-07' AS Date), 4, 7)
INSERT [dbo].[PostComment] ([PostCommentID], [CommentContent], [CommentDate], [PostID], [CommentorID]) VALUES (8, N'Congratulations on the achievement!', CAST(N'2022-01-08' AS Date), 4, 8)
INSERT [dbo].[PostComment] ([PostCommentID], [CommentContent], [CommentDate], [PostID], [CommentorID]) VALUES (9, N'I recommend this club!', CAST(N'2022-01-09' AS Date), 5, 9)
INSERT [dbo].[PostComment] ([PostCommentID], [CommentContent], [CommentDate], [PostID], [CommentorID]) VALUES (10, N'Well done!', CAST(N'2022-01-10' AS Date), 5, 10)
SET IDENTITY_INSERT [dbo].[PostComment] OFF
GO
SET IDENTITY_INSERT [dbo].[Rating] ON 

INSERT [dbo].[Rating] ([RatingID], [Vote], [Note], [ClubID], [UserID]) VALUES (1, 5, N'Great club!', 1, 1)
INSERT [dbo].[Rating] ([RatingID], [Vote], [Note], [ClubID], [UserID]) VALUES (2, 4, N'Good club!', 2, 2)
INSERT [dbo].[Rating] ([RatingID], [Vote], [Note], [ClubID], [UserID]) VALUES (3, 3, N'Average club.', 3, 3)
INSERT [dbo].[Rating] ([RatingID], [Vote], [Note], [ClubID], [UserID]) VALUES (4, 5, N'Amazing experience!', 4, 4)
INSERT [dbo].[Rating] ([RatingID], [Vote], [Note], [ClubID], [UserID]) VALUES (5, 2, N'Not satisfied.', 5, 5)
INSERT [dbo].[Rating] ([RatingID], [Vote], [Note], [ClubID], [UserID]) VALUES (6, 4, N'Fun activities!', 6, 6)
INSERT [dbo].[Rating] ([RatingID], [Vote], [Note], [ClubID], [UserID]) VALUES (7, 5, N'Highly recommended!', 7, 7)
SET IDENTITY_INSERT [dbo].[Rating] OFF
GO
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([UserID], [UserName], [UserEmail], [UserPassword], [UserPhone], [UserDOB], [UserGender]) VALUES (1, N'John Doe', N'john.doe@example.com', N'password1', N'123456789', CAST(N'1999-01-01' AS Date), N'Male')
INSERT [dbo].[Users] ([UserID], [UserName], [UserEmail], [UserPassword], [UserPhone], [UserDOB], [UserGender]) VALUES (2, N'Jane Smith', N'jane.smith@example.com', N'password2', N'987654321', CAST(N'2000-02-02' AS Date), N'Female')
INSERT [dbo].[Users] ([UserID], [UserName], [UserEmail], [UserPassword], [UserPhone], [UserDOB], [UserGender]) VALUES (3, N'Mark Johnson', N'mark.johnson@example.com', N'password3', N'456789123', CAST(N'2001-03-03' AS Date), N'Male')
INSERT [dbo].[Users] ([UserID], [UserName], [UserEmail], [UserPassword], [UserPhone], [UserDOB], [UserGender]) VALUES (4, N'Emily Brown', N'emily.brown@example.com', N'password4', N'321654987', CAST(N'2002-04-04' AS Date), N'Female')
INSERT [dbo].[Users] ([UserID], [UserName], [UserEmail], [UserPassword], [UserPhone], [UserDOB], [UserGender]) VALUES (5, N'Michael Davis', N'michael.davis@example.com', N'password5', N'789123456', CAST(N'2006-08-08' AS Date), N'Male')
INSERT [dbo].[Users] ([UserID], [UserName], [UserEmail], [UserPassword], [UserPhone], [UserDOB], [UserGender]) VALUES (6, N'Sarah Wilson', N'sarah.wilson@example.com', N'password6', N'654987321', CAST(N'2007-09-09' AS Date), N'Female')
INSERT [dbo].[Users] ([UserID], [UserName], [UserEmail], [UserPassword], [UserPhone], [UserDOB], [UserGender]) VALUES (7, N'Alexis Johnson', N'alexis.johnson@example.com', N'password7', N'123456789', CAST(N'2004-10-10' AS Date), N'Female')
INSERT [dbo].[Users] ([UserID], [UserName], [UserEmail], [UserPassword], [UserPhone], [UserDOB], [UserGender]) VALUES (8, N'Ryan Wilson', N'ryan.wilson@example.com', N'password8', N'987654321', CAST(N'2005-11-11' AS Date), N'Male')
INSERT [dbo].[Users] ([UserID], [UserName], [UserEmail], [UserPassword], [UserPhone], [UserDOB], [UserGender]) VALUES (9, N'Olivia Davis', N'olivia.davis@example.com', N'password9', N'456789123', CAST(N'2002-12-12' AS Date), N'Female')
INSERT [dbo].[Users] ([UserID], [UserName], [UserEmail], [UserPassword], [UserPhone], [UserDOB], [UserGender]) VALUES (10, N'Ethan Thompson', N'ethan.thompson@example.com', N'password10', N'321654987', CAST(N'2001-01-13' AS Date), N'Male')
INSERT [dbo].[Users] ([UserID], [UserName], [UserEmail], [UserPassword], [UserPhone], [UserDOB], [UserGender]) VALUES (11, N'Sophia Clark', N'sophia.clark@example.com', N'password11', N'789123456', CAST(N'2000-02-14' AS Date), N'Female')
INSERT [dbo].[Users] ([UserID], [UserName], [UserEmail], [UserPassword], [UserPhone], [UserDOB], [UserGender]) VALUES (12, N'Jacob Adams', N'jacob.adams@example.com', N'password12', N'654987321', CAST(N'2003-03-15' AS Date), N'Male')
INSERT [dbo].[Users] ([UserID], [UserName], [UserEmail], [UserPassword], [UserPhone], [UserDOB], [UserGender]) VALUES (13, N'Ava Lee', N'ava.lee@example.com', N'password13', N'123456789', CAST(N'2004-04-16' AS Date), N'Female')
INSERT [dbo].[Users] ([UserID], [UserName], [UserEmail], [UserPassword], [UserPhone], [UserDOB], [UserGender]) VALUES (14, N'Huy', N'huy@gmail.com', N'123', N'989572340', CAST(N'2003-04-03' AS Date), N'Male')
INSERT [dbo].[Users] ([UserID], [UserName], [UserEmail], [UserPassword], [UserPhone], [UserDOB], [UserGender]) VALUES (16, N'Duy', N'duy@gmail.com', N'duy123', N'099299574', CAST(N'2002-05-13' AS Date), N'Male')
INSERT [dbo].[Users] ([UserID], [UserName], [UserEmail], [UserPassword], [UserPhone], [UserDOB], [UserGender]) VALUES (17, N'Yen Thi', N'yenthi@gmail.com', N'123456', N'092477592', CAST(N'2005-05-03' AS Date), N'Female')
SET IDENTITY_INSERT [dbo].[Users] OFF
GO
ALTER TABLE [dbo].[Member] ADD  DEFAULT ((0)) FOR [IsClubManager]
GO
ALTER TABLE [dbo].[Clubs]  WITH CHECK ADD FOREIGN KEY([ClubCreatorID])
REFERENCES [dbo].[Users] ([UserID])
GO
ALTER TABLE [dbo].[Event]  WITH CHECK ADD FOREIGN KEY([ClubID])
REFERENCES [dbo].[Clubs] ([ClubID])
GO
ALTER TABLE [dbo].[Event]  WITH CHECK ADD FOREIGN KEY([StatusID])
REFERENCES [dbo].[EventStatus] ([StatusID])
GO
ALTER TABLE [dbo].[Event]  WITH CHECK ADD FOREIGN KEY([UserID])
REFERENCES [dbo].[Users] ([UserID])
GO
ALTER TABLE [dbo].[EventAttendees]  WITH CHECK ADD FOREIGN KEY([EventID])
REFERENCES [dbo].[Event] ([EventID])
GO
ALTER TABLE [dbo].[EventAttendees]  WITH CHECK ADD FOREIGN KEY([UserID])
REFERENCES [dbo].[Users] ([UserID])
GO
ALTER TABLE [dbo].[Member]  WITH CHECK ADD FOREIGN KEY([ClubID])
REFERENCES [dbo].[Clubs] ([ClubID])
GO
ALTER TABLE [dbo].[Member]  WITH CHECK ADD FOREIGN KEY([UserID])
REFERENCES [dbo].[Users] ([UserID])
GO
ALTER TABLE [dbo].[Post]  WITH CHECK ADD FOREIGN KEY([ClubID])
REFERENCES [dbo].[Clubs] ([ClubID])
GO
ALTER TABLE [dbo].[Post]  WITH CHECK ADD FOREIGN KEY([UserID])
REFERENCES [dbo].[Users] ([UserID])
GO
ALTER TABLE [dbo].[PostComment]  WITH CHECK ADD FOREIGN KEY([CommentorID])
REFERENCES [dbo].[Users] ([UserID])
GO
ALTER TABLE [dbo].[PostComment]  WITH CHECK ADD FOREIGN KEY([PostID])
REFERENCES [dbo].[Post] ([PostID])
GO
ALTER TABLE [dbo].[Rating]  WITH CHECK ADD FOREIGN KEY([ClubID])
REFERENCES [dbo].[Clubs] ([ClubID])
GO
ALTER TABLE [dbo].[Rating]  WITH CHECK ADD FOREIGN KEY([UserID])
REFERENCES [dbo].[Users] ([UserID])
GO
USE [master]
GO
ALTER DATABASE [ClubProject] SET  READ_WRITE 
GO
