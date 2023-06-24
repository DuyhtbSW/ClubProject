package model.User;

public class Rating {

    private int ID;
    private String vote, note, memberID, clubID;

    public Rating() {
    }

    public Rating(int ID, String vote, String note, String memberID, String clubID) {
        this.ID = ID;
        this.vote = vote;
        this.note = note;
        this.memberID = memberID;
        this.clubID = clubID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getClubID() {
        return clubID;
    }

    public void setClubID(String clubID) {
        this.clubID = clubID;
    }

    @Override
    public String toString() {
        return "Rating{" + "ID=" + ID + ", vote=" + vote + ", note=" + note + ", memberID=" + memberID + ", clubID=" + clubID + '}';
    }
}
