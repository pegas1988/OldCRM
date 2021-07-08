package entity;

import java.util.Date;

public class Client {

    private Integer ClientID;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String sex;
    private int phoneNumber;
    private String diagnose;
    private String twoDScanname;

    public String getTwoDScan() {
        return twoDScanname;
    }

    public void setTwoDScan(String twoDScan) {
        this.twoDScanname = twoDScan;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public Client() {

    }

    public Client(String firstName, String lastName, Date dateOfBirth, String sex, String diagnoses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.diagnoses = diagnoses;
    }

    private String diagnoses;

    public String getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", sex='" + sex + '\'' +
                ", diagnoses='" + diagnoses + '\'' +
                '}';
    }

    public Integer getClientID() {
        return ClientID;
    }

    public void setClientID(Integer clientID) {
        ClientID = clientID;
    }
}
