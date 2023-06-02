package dao.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.User.Club;
import model.User.Post;
import model.User.User;

public class UserDAO {

    private Connection con;
    private ArrayList<User> user;
    private ArrayList<Club> club;
    private ArrayList<Post> post;

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

    public void insertUser(String acc, String pass) {
        try {
            con = new DBConnect().getConnection();
            String query = "insert into Users values (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, "");
            ps.setString(2, acc);
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
            String query = "select * from Clubs";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                club.add(new Club(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)));
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
            String query = "insert into Clubs values (?, ?, ?, ?, ?)";
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
            String query = "select * from Clubs\n" + "where ClubCreatorID = ?";
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
                    + "WHERE Member.ClubID = ? and Member.UserID <> ? and IsClubManager = 1";
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
                    + "WHERE Member.ClubID = ? AND Member.UserID <> ? AND IsClubManager = 0";
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
            String query = "select * from Post\n" + "where ClubID = ?";
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
}
