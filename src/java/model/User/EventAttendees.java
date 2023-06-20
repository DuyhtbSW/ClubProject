package model.User;

public class EventAttendees {

    private int ID;
    private String eventID, memberID;

    public EventAttendees() {
    }

    public EventAttendees(int ID, String eventID, String memberID) {
        this.ID = ID;
        this.eventID = eventID;
        this.memberID = memberID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    @Override
    public String toString() {
        return "EventAttendees{" + "ID=" + ID + ", eventID=" + eventID + ", memberID=" + memberID + '}';
    }
}
