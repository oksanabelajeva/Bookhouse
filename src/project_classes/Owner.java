package project_classes;

public class Owner {

    private String ownerName;
    private String ownerSurname;
    private String ownerNickname;
    private String ownerEmail;
    private String ownerPhone;

    public Owner(String ownerName, String ownerSurname, String ownerNickname, String ownerEmail, String ownerPhone) {
        this.ownerName = ownerName;
        this.ownerSurname = ownerSurname;
        this.ownerNickname = ownerNickname;
        this.ownerEmail = ownerEmail;
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerSurname() {
        return ownerSurname;
    }

    public void setOwnerSurname(String ownerSurname) {
        this.ownerSurname = ownerSurname;
    }

    public String getOwnerNickname() {
        return ownerNickname;
    }

    public void setOwnerNickname(String ownerNickname) {
        this.ownerNickname = ownerNickname;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerName='" + ownerName + '\'' +
                ", ownerSurname='" + ownerSurname + '\'' +
                ", ownerNickname='" + ownerNickname + '\'' +
                ", ownerEmail='" + ownerEmail + '\'' +
                ", ownerPhone='" + ownerPhone + '\'' +
                '}';
    }
}