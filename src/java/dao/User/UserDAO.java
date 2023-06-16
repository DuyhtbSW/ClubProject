package dao.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.User.Club;
import model.User.Post;
import model.User.PostComment;
import model.User.User;

public class UserDAO {

    private Connection con;
    private ArrayList<User> user;
    private ArrayList<Club> club;
    private ArrayList<Post> post;
    private ArrayList<PostComment> postComment;

    public User checkUserLogin(String acc, String pass) {
        try {
            con = new DBConnect().getConnection();
            String query = "select * from Users\n" + "where UserEmail = ? and UserPassword = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, acc);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public User checkUserEmail(String email) {
        try {
            con = new DBConnect().getConnection();
            String query = "select * from Users\n" + "where UserEmail = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void insertUser(String name, String email, String pass) {
        try {
            con = new DBConnect().getConnection();
            String query = "insert into Users values (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, pass);
            ps.setString(4, "");
            ps.setString(5, "");
            ps.setString(6, "");
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void editUser(String uName, String uEmail, String uPhone,
            String uDOB, String uGender, int uID) {
        try {
            con = new DBConnect().getConnection();
            String query = "update Users\n"
                    + "set UserName = ?,\n"
                    + "UserEmail = ?,\n"
                    + "UserPhone = ?,\n"
                    + "UserDOB = ?,\n"
                    + "UserGender = ?\n"
                    + "where UserID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, uName);
            ps.setString(2, uEmail);
            ps.setString(3, uPhone);
            ps.setString(4, uDOB);
            ps.setString(5, uGender);
            ps.setInt(6, uID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public User getUserByID(int ID) {
        try {
            con = new DBConnect().getConnection();
            String query = "select * from Users\n" + "where UserID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public ArrayList<Club> getAllClub() {
        try {
            club = new ArrayList<>();
            con = new DBConnect().getConnection();
            String query = "select * from Clubs\n" + "where ClubStatus = 1";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                club.add(new Club(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }
        } catch (Exception e) {
        }
        return club;
    }

//    public ArrayList<Club> getClubCreatorName(String ClubID, String ClubCreatorID) {
//        try {
//            club = new ArrayList<>();
//            con = new DBConnect().getConnection();
//            String query = "SELECT Clubs.ClubID, Clubs.ClubCode, Clubs.ClubName , Clubs.ClubDescription, Users.UserName, Clubs.DateCreated\n"
//                    + "FROM Clubs INNER JOIN Users \n"
//                    + "ON Clubs.ClubCreatorID = Users.UserID \n"
//                    + "WHERE Clubs.ClubID = ? and Clubs.ClubCreatorID = ?";
//            PreparedStatement ps = con.prepareStatement(query);
//            ps.setString(1, ClubID);
//            ps.setString(1, ClubCreatorID);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                int cID = rs.getInt(1);
//                String cCode = rs.getString(2);
//                String cName = rs.getString(3);
//                String cDescription = rs.getString(4);
//                String cCreatorID = rs.getString(5);
//                String cDateCreated = rs.getString(6);
//                club.add(new Club(cID, cCode, cName, cDescription, cCreatorID, cDateCreated));
//            }
//        } catch (Exception e) {
//        }
//        return club;
//    }
    public String getClubCreatorName(String ID) {
        String ClubCreatorName = null;
        try {
            con = new DBConnect().getConnection();
            String query = "SELECT Users.UserName \n"
                    + "FROM Clubs INNER JOIN Users \n"
                    + "ON Clubs.ClubCreatorID = Users.UserID \n"
                    + "WHERE Clubs.ClubCreatorID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ClubCreatorName = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return ClubCreatorName;
    }
//
//    public Club getClubCreatorName2(String ClubID, String ClubCreatorID) {
//        try {
//            con = new DBConnect().getConnection();
//            String query = "SELECT Clubs.ClubID, Clubs.ClubCode, Clubs.ClubName , Clubs.ClubDescription, Users.UserName, Clubs.DateCreated\n"
//                    + "FROM Clubs INNER JOIN Users \n"
//                    + "ON Clubs.ClubCreatorID = Users.UserID \n"
//                    + "WHERE Clubs.ClubID = ? and Clubs.ClubCreatorID = ?";
//            PreparedStatement ps = con.prepareStatement(query);
//            ps.setString(1, ClubID);
//            ps.setString(1, ClubCreatorID);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                return new Club(rs.getInt(1), rs.getString(2), rs.getString(3),
//                        rs.getString(4), rs.getInt(5), rs.getString(6));
//            }
//        } catch (Exception e) {
//        }
//        return null;
//    }

    public void insertClub(String cCode, String cName, String cDescription, int cCreatorID, Date cDateCreated) {
        try {
            con = new DBConnect().getConnection();
            String query = "insert into Clubs values (?, ?, ?, ?, ?, 0, 0)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cCode);
            ps.setString(2, cName);
            ps.setString(3, cDescription);
            ps.setInt(4, cCreatorID);
            ps.setDate(5, cDateCreated);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Club getClubByID(String ID) {
        try {
            con = new DBConnect().getConnection();
            String query = "select * from Clubs\n" + "where ClubID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Club(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public ArrayList<Club> getClubCreator(int uID) {
        try {
            club = new ArrayList<>();
            con = new DBConnect().getConnection();
            String query = "select * from Clubs\n" + "where ClubCreatorID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, uID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                club.add(new Club(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return club;
    }

    public ArrayList<Club> getClubManager(int uID) {
        try {
            club = new ArrayList<>();
            con = new DBConnect().getConnection();
            String query = "SELECT c.ClubID, c.ClubCode, c.ClubName, c.ClubDescription, c.ClubCreatorID, c.DateCreated\n"
                    + "FROM Clubs c\n"
                    + "INNER JOIN Member m ON c.ClubID = m.ClubID\n"
                    + "WHERE c.ClubCreatorID <> ? AND m.UserID = ? AND m.IsClubManager = 1 AND m.MemberStatus = 1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, uID);
            ps.setInt(2, uID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                club.add(new Club(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return club;
    }

    public int getTotalManager(String clubID, String clubCreatorID) {
        try {
            con = new DBConnect().getConnection();
            String query = "SELECT COUNT(*) AS ManagerCount\n"
                    + "FROM Member\n"
                    + "WHERE ClubID = ? AND UserID != ? AND IsClubManager = 1 AND MemberStatus = 1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, clubID);
            ps.setString(2, clubCreatorID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int getTotalMember(String clubID) {
        try {
            con = new DBConnect().getConnection();
            String query = "SELECT COUNT(*) AS MemberCount\n"
                    + "FROM Member\n"
                    + "WHERE ClubID = ? AND IsClubManager = 0 AND MemberStatus = 1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, clubID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int getTotalPost(String clubID) {
        try {
            con = new DBConnect().getConnection();
            String query = "SELECT COUNT(*) AS PostCount\n"
                    + "FROM Post\n"
                    + "WHERE ClubID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, clubID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int getTotalEvent(String clubID) {
        try {
            con = new DBConnect().getConnection();
            String query = "SELECT COUNT(*) AS EventCount\n"
                    + "FROM [Event]\n"
                    + "WHERE ClubID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, clubID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public Club getClubCreatorFromUserID(int userID) {
        try {
            con = new DBConnect().getConnection();
            String query = "select * from Clubs\n" + "where ClubCreatorID = ? and ClubStatus = 1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Club(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Club getClubToManage(String clubID) {
        try {
            con = new DBConnect().getConnection();
            String query = "select * from Clubs\n" + "where ClubID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, clubID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Club(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public ArrayList<User> getClubManagersWithoutCreator(String clubID, String creatorID) {
        try {
            user = new ArrayList<>();
            con = new DBConnect().getConnection();
            String query = "SELECT Users.UserID, Users.UserName, Users.UserDOB, Users.UserGender\n"
                    + "FROM Member\n"
                    + "INNER JOIN Users ON Member.UserID = Users.UserID\n"
                    + "WHERE Member.ClubID = ? AND Member.UserID <> ? AND IsClubManager = 1 AND Member.MemberStatus = 1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, clubID);
            ps.setString(2, creatorID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int userID = rs.getInt(1);
                String userName = rs.getString(2);
                String userDOB = rs.getString(3);
                String userGender = rs.getString(4);
                user.add(new User(userID, userName, userDOB, userGender));
            }
        } catch (Exception e) {
        }
        return user;
    }

    public ArrayList<User> getClubMembersWithoutCreator(String clubID, String creatorID) {
        try {
            user = new ArrayList<>();
            con = new DBConnect().getConnection();
            String query = "SELECT Users.UserID, Users.UserName, Users.UserDOB, Users.UserGender\n"
                    + "FROM Member\n"
                    + "INNER JOIN Users ON Member.UserID = Users.UserID\n"
                    + "WHERE Member.ClubID = ? AND Member.UserID <> ? AND IsClubManager = 0 AND Member.MemberStatus = 1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, clubID);
            ps.setString(2, creatorID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int userID = rs.getInt(1);
                String userName = rs.getString(2);
                String userDOB = rs.getString(3);
                String userGender = rs.getString(4);
                user.add(new User(userID, userName, userDOB, userGender));
            }
        } catch (Exception e) {
        }
        return user;
    }

    public ArrayList<Post> getPostFromClubID(String clubID) {
        try {
            post = new ArrayList<>();
            con = new DBConnect().getConnection();
            String query = "select * from Post\n" + "where ClubID = ? and PostStatus = 1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, clubID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int postID = rs.getInt(1);
                String postTitle = rs.getString(2);
                String postDescription = rs.getString(3);
                String postDate = rs.getString(4);
                String memberID = rs.getString(5);
                String sClubID = rs.getString(6);

                String posterName = getPosterName(memberID);

                post.add(new Post(postID, postTitle, postDescription, postDate, posterName, sClubID));
//                post.add(new Post(rs.getInt(1), rs.getString(2), rs.getString(3),
//                        rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return post;
    }

    public Post getPost(String clubID, String postID) {
        try {
            con = new DBConnect().getConnection();
            String query = "select * from Post\n" + "where ClubID = ? and PostID = ? and PostStatus = 1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, clubID);
            ps.setString(2, postID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int pID = rs.getInt(1);
                String postTitle = rs.getString(2);
                String postDescription = rs.getString(3);
                String postDate = rs.getString(4);
                String memberID = rs.getString(5);
                String sClubID = rs.getString(6);

                String posterName = getPosterName(memberID);

                return new Post(pID, postTitle, postDescription, postDate, posterName, sClubID);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Post getMyPost(String postID, int memberID) {
        try {
            con = new DBConnect().getConnection();
            String query = "SELECT * FROM Post\n" + "WHERE PostID = ? AND MemberID = ? AND PostStatus = 1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, postID);
            ps.setInt(2, memberID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int pID = rs.getInt(1);
                String postTitle = rs.getString(2);
                String postDescription = rs.getString(3);
                String postDate = rs.getString(4);
                String mID = rs.getString(5);
                String sClubID = rs.getString(6);

                String posterName = getPosterName(mID);

                return new Post(pID, postTitle, postDescription, postDate, posterName, sClubID);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Post getPostOfClubCreator(String postID, int memberID) {
        try {
            con = new DBConnect().getConnection();
            String query = "SELECT * FROM Post WHERE PostID = ? AND MemberID = ? AND PostStatus = 1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, postID);
            ps.setInt(2, memberID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int pID = rs.getInt(1);
                String postTitle = rs.getString(2);
                String postDescription = rs.getString(3);
                String postDate = rs.getString(4);
                String mID = rs.getString(5);
                String sClubID = rs.getString(6);

                String posterName = getPosterName(mID);

                return new Post(pID, postTitle, postDescription, postDate, posterName, sClubID);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public int getClubCreatorID(String clubID) {
        try {
            con = new DBConnect().getConnection();
            String query = "SELECT ClubCreatorID FROM Clubs WHERE ClubID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, clubID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public String getPosterName(String memberID) {
        String PosterName = null;
        try {
            con = new DBConnect().getConnection();
            String query = "SELECT Users.UserName\n"
                    + "FROM Member\n"
                    + "JOIN Users ON Member.UserID = Users.UserID\n"
                    + "where Member.MemberID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, memberID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PosterName = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return PosterName;
    }

    public void insertPost(String pTitle, String pDescription, Date pDate, int pMemberID, String pClubID, String pStatus) {
        try {
            con = new DBConnect().getConnection();
            String query = "insert into Post values (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, pTitle);
            ps.setString(2, pDescription);
            ps.setDate(3, pDate);
            ps.setInt(4, pMemberID);
            ps.setString(5, pClubID);
            ps.setString(6, pStatus);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void editPost(String pTitle, String pDescription, String postID) {
        try {
            con = new DBConnect().getConnection();
            String query = "update Post\n"
                    + "set PostTitle = ?,\n"
                    + "PostDescription = ?\n"
                    + "where PostID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, pTitle);
            ps.setString(2, pDescription);
            ps.setString(3, postID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int getMemberID(int userID, String clubID) {
        try {
            con = new DBConnect().getConnection();
            String query = "SELECT MemberID\n"
                    + "FROM Member\n"
                    + "WHERE UserID = ? and ClubID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userID);
            ps.setString(2, clubID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int isClubManager(int memberID) {
        try {
            con = new DBConnect().getConnection();
            String query = "SELECT IsClubManager\n"
                    + "FROM Member\n"
                    + "WHERE MemberID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, memberID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void editClub(String cCode, String cName, String cDescription, String cID) {
        try {
            con = new DBConnect().getConnection();
            String query = "update Clubs\n"
                    + "set ClubCode = ?,\n"
                    + "ClubName = ?,\n"
                    + "ClubDescription = ?\n"
                    + "where ClubID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cCode);
            ps.setString(2, cName);
            ps.setString(3, cDescription);
            ps.setString(4, cID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void setToManager(String mID, String cID) {
        try {
            con = new DBConnect().getConnection();
            String query = "UPDATE Member\n"
                    + "SET IsClubManager = 1\n"
                    + "WHERE UserID = ? AND ClubID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, mID);
            ps.setString(2, cID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void setToMember(String mID, String cID) {
        try {
            con = new DBConnect().getConnection();
            String query = "UPDATE Member\n"
                    + "SET IsClubManager = 0\n"
                    + "WHERE UserID = ? AND ClubID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, mID);
            ps.setString(2, cID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ArrayList<PostComment> getPostComment(String postID) {
        try {
            postComment = new ArrayList<>();
            con = new DBConnect().getConnection();
            String query = "SELECT PC.PostCommentID, PC.CommentContent, PC.CommentDate, PC.PostID, U.UserName\n"
                    + "FROM PostComment PC\n"
                    + "JOIN Member M ON PC.CommentorID = M.MemberID\n"
                    + "JOIN Users U ON M.UserID = U.UserID\n"
                    + "WHERE PC.PostID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, postID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                postComment.add(new PostComment(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5)));
            }
        } catch (Exception e) {
        }
        return postComment;
    }

    public int getMemberIDFromPost(int userID, String clubID) {
        try {
            con = new DBConnect().getConnection();
            String query = "select M.MemberID\n"
                    + "from Member M\n"
                    + "join Users U on M.UserID = U.UserID\n"
                    + "join Post P on M.ClubID = P.ClubID\n"
                    + "where U.UserID = ? and P.ClubID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userID);
            ps.setString(2, clubID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void insertComment(String cContent, Date cDate, String postID, int commentorID) {
        try {
            con = new DBConnect().getConnection();
            String query = "insert into PostComment values (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cContent);
            ps.setDate(2, cDate);
            ps.setString(3, postID);
            ps.setInt(4, commentorID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteComment(String pcID) {
        try {
            con = new DBConnect().getConnection();
            String query = "delete from PostComment\n" + "where PostCommentID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, pcID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public String getClubManagerFromUserID(int userID) {
        String isManager = null;
        try {
            con = new DBConnect().getConnection();
            String query = "SELECT m.IsClubManager\n"
                    + "FROM Member m\n"
                    + "JOIN Clubs c ON m.ClubID = c.ClubID\n"
                    + "WHERE m.UserID = ?\n"
                    + "  AND m.IsClubManager = 1\n"
                    + "  AND m.UserID != c.ClubCreatorID";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                isManager = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return isManager;
    }

    public Club checkClubStatus(String clubID) {
        try {
            con = new DBConnect().getConnection();
            String query = "select * from Clubs\n" + "where ClubID = ? and JoinRequest = 1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, clubID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Club(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void joinClubRequest(int userID, String clubID, Date requestDate) {
        try {
            con = new DBConnect().getConnection();
            String query = "insert into Member values (?, ?, 0, ?, 0)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userID);
            ps.setString(2, clubID);
            ps.setDate(3, requestDate);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void joinClubSuccess(String clubID, int userID, Date requestDate) {
        try {
            con = new DBConnect().getConnection();
            String query = "insert into Member values (?, ?, 0, ?, 1)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, clubID);
            ps.setInt(2, userID);
            ps.setDate(3, requestDate);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public User checkUserIsMember(String clubID, int userID) {
        try {
            con = new DBConnect().getConnection();
            String query = "SELECT Member.UserID, Users.UserName, Member.JoinDate\n"
                    + "FROM Member JOIN Users\n"
                    + "ON Member.UserID = Users.UserID\n"
                    + "WHERE ClubID = ? AND Member.UserID = ? AND MemberStatus = 1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, clubID);
            ps.setInt(2, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public User checkJoinRequestExist(String clubID, int userID) {
        try {
            con = new DBConnect().getConnection();
            String query = "SELECT Member.UserID, Users.UserName, Member.JoinDate\n"
                    + "FROM Member JOIN Users\n"
                    + "ON Member.UserID = Users.UserID\n"
                    + "WHERE ClubID = ? AND Member.UserID = ? AND MemberStatus = 0";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, clubID);
            ps.setInt(2, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public ArrayList<User> getJoinRequestList(String clubID) {
        try {
            user = new ArrayList<>();
            con = new DBConnect().getConnection();
            String query = "SELECT Member.UserID, Users.UserName, Member.JoinDate\n"
                    + "FROM Member JOIN Users\n"
                    + "ON Member.UserID = Users.UserID\n"
                    + "WHERE ClubID = ? AND MemberStatus = 0";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, clubID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
        }
        return user;
    }

    public void joinRequestAccept(Date joinDate, String clubID, String userID) {
        try {
            con = new DBConnect().getConnection();
            String query = "update Member\n"
                    + "set JoinDate = ?,\n"
                    + "MemberStatus = 1\n"
                    + "where ClubID = ? and UserID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDate(1, joinDate);
            ps.setString(2, clubID);
            ps.setString(3, userID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void joinRequestDecline(String clubID, String userID) {
        try {
            con = new DBConnect().getConnection();
            String query = "delete Member\n"
                    + "where ClubID = ? and UserID = ? and MemberStatus = 0";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, clubID);
            ps.setString(2, userID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteMember(String clubID, String userID) {
        try {
            con = new DBConnect().getConnection();
            String query = "delete Member\n"
                    + "where ClubID = ? and UserID = ? and IsClubManager = 0 and MemberStatus = 1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, clubID);
            ps.setString(2, userID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteManager(String clubID, String userID) {
        try {
            con = new DBConnect().getConnection();
            String query = "delete Member\n"
                    + "where ClubID = ? and UserID = ? and IsClubManager = 1 and MemberStatus = 1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, clubID);
            ps.setString(2, userID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
