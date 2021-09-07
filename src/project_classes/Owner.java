package project_classes;

import java.util.Objects;
import java.util.Scanner;

public class Owner {

    final static Scanner scanner = new Scanner(System.in);
    final static Owner newOwner = new Owner();

    private String ownerName;
    private String ownerSurname;
    private String ownerNickname;
    private String ownerEmail;
    private String ownerPhone;

    public Owner() {
    }

    public Owner(String ownerName, String ownerSurname, String ownerNickname, String ownerEmail, String ownerPhone) {
        this.ownerName = ownerName;
        this.ownerSurname = ownerSurname;
        this.ownerNickname = ownerNickname;
        this.ownerEmail = ownerEmail;
        this.ownerPhone = ownerPhone;
    }

    public static Owner insertInformationOwner() {
        System.out.println("Enter your name: ");
        newOwner.setOwnerName(scanner.nextLine());
        System.out.println("Enter your surname: ");
        newOwner.setOwnerSurname(scanner.nextLine());
        System.out.println("Enter your nickname:  ");
        newOwner.setOwnerNickname(scanner.nextLine());
        System.out.println("Enter your e-mail: ");
        newOwner.setOwnerEmail(scanner.nextLine());
        System.out.println("Enter your phone number:  ");
        newOwner.setOwnerPhone(scanner.nextLine());
        return newOwner;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Owner)) return false;
        Owner owner = (Owner) o;
        return Objects.equals(getOwnerName(), owner.getOwnerName()) && Objects.equals(getOwnerSurname(), owner.getOwnerSurname()) && Objects.equals(getOwnerNickname(), owner.getOwnerNickname()) && Objects.equals(getOwnerEmail(), owner.getOwnerEmail()) && Objects.equals(getOwnerPhone(), owner.getOwnerPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOwnerName(), getOwnerSurname(), getOwnerNickname(), getOwnerEmail(), getOwnerPhone());
    }
}