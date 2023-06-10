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

    public ArrayList<Club> getClubsCreatorFromUserID(int uID) {
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

    public Club getClubToManage(int clubID) {
        try {
            con = new DBConnect().getConnection();
            String query = "select * from Clubs\n" + "where ClubID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, clubID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Club(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public ArrayList<User> getClubManagersWithoutCreator(int clubID, String creatorID) {
        try {
            user = new ArrayList<>();
            con = new DBConnect().getConnection();
            String query = "SELECT Users.UserID, Users.UserName, Users.UserDOB, Users.UserGender\n"
                    + "FROM Member\n"
                    + "INNER JOIN Users ON Member.UserID = Users.UserID\n"
                    + "WHERE Member.ClubID = ? AND Member.UserID <> ? AND IsClubManager = 1 AND Member.MemberStatus = 1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, clubID);
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

    public ArrayList<User> getClubMembersWithoutCreator(int clubID, String creatorID) {
        try {
            user = new ArrayList<>();
            con = new DBConnect().getConnection();
            String query = "SELECT Users.UserID, Users.UserName, Users.UserDOB, Users.UserGender\n"
                    + "FROM Member\n"
                    + "INNER JOIN Users ON Member.UserID = Users.UserID\n"
                    + "WHERE Member.ClubID = ? AND Member.UserID <> ? AND IsClubManager = 0 AND Member.MemberStatus = 1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, clubID);
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

    public ArrayList<Post> getPostFromClubID(int clubID) {
        try {
            post = new ArrayList<>();
            con = new DBConnect().getConnection();
            String query = "select * from Post\n" + "where ClubID = ? and PostStatus = 1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, clubID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int postID = rs.getInt(1);
                String postTitle = rs.getString(2);
                String postDescription = rs.getString(3);
                String postDated = rs.getString(4);
                String userID = rs.getString(5);
                String sClubID = rs.getString(6);

                String posterName = getPosterName(userID);

                post.add(new Post(postID, postTitle, postDescription, postDated, posterName, sClubID));
//                post.add(new Post(rs.getInt(1), rs.getString(2), rs.getString(3),
//                        rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return post;
    }

    public String getPosterName(String userID) {
        String PosterName = null;
        try {
            con = new DBConnect().getConnection();
            String query = "SELECT UserName\n" + "FROM Users\n" + "WHERE UserID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PosterName = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return PosterName;
    }

    public void editClub(String cCode, String cName, String cDescription, int cID) {
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
            ps.setInt(4, cID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void setToManager(String mID, int cID) {
        try {
            con = new DBConnect().getConnection();
            String query = "UPDATE Member\n"
                    + "SET IsClubManager = 1\n"
                    + "WHERE UserID = ? AND ClubID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, mID);
            ps.setInt(2, cID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void setToMember(String mID, int cID) {
        try {
            con = new DBConnect().getConnection();
            String query = "UPDATE Member\n"
                    + "SET IsClubManager = 0\n"
                    + "WHERE UserID = ? AND ClubID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, mID);
            ps.setInt(2, cID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ArrayList<PostComment> getPostComment(String postID) {
        try {
            postComment = new ArrayList<>();
            con = new DBConnect().getConnection();
            String query = "SELECT PC.PostCommentID, PC.CommentContent, PC.CommentDated, PC.PostID, U.UserName\n"
                    + "FROM PostComment PC\n"
                    + "JOIN Users U ON PC.CommentorID = U.UserID\n"
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

    public void insertComment(String cContent, Date cDated, String postID, int commentorID) {
        try {
            con = new DBConnect().getConnection();
            String query = "insert into PostComment values (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cContent);
            ps.setDate(2, cDated);
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

    public void joinClubRequest(String clubID, int userID, Date requestDated) {
        try {
            con = new DBConnect().getConnection();
            String query = "insert into Member values (?, ?, 0, ?, 0)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, clubID);
            ps.setInt(2, userID);
            ps.setDate(3, requestDated);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void joinClubSuccess(String clubID, int userID, Date requestDated) {
        try {
            con = new DBConnect().getConnection();
            String query = "insert into Member values (?, ?, 0, ?, 1)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, clubID);
            ps.setInt(2, userID);
            ps.setDate(3, requestDated);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public User checkUserIsMember(String clubID, int userID) {
        try {
            con = new DBConnect().getConnection();
            String query = "SELECT Member.UserID, Users.UserName, Member.JoinDated\n"
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
            String query = "SELECT Member.UserID, Users.UserName, Member.JoinDated\n"
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
            String query = "SELECT Member.UserID, Users.UserName, Member.JoinDated\n"
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

    public void joinRequestAccept(Date joinDated, String clubID, String userID) {
        try {
            con = new DBConnect().getConnection();
            String query = "update Member\n"
                    + "set JoinDated = ?,\n"
                    + "MemberStatus = 1\n"
                    + "where ClubID = ? and UserID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDate(1, joinDated);
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
