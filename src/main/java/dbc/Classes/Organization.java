package dbc.Classes;

public class Organization {
    private int ID;
    private String name_oganization;
    private String password;
    private String descreption;
    private String email;
    private String phone;
    private String facebook;
    private String instagram;
    private String twitter;
    private byte[] logo;

    public Organization(String name_oganization, int ID, String password, String descreption, String email, String phone, String facebook, String instagram, String twitter, byte[] logo) {
        this.name_oganization = name_oganization;
        this.ID = ID;
        this.password = password;
        this.descreption = descreption;
        this.email = email;
        this.phone = phone;
        this.facebook = facebook;
        this.instagram = instagram;
        this.twitter = twitter;
        this.logo = logo;
    }

    public int getID() {
        return ID;
    }

    public String getName_oganization() {
        return name_oganization;
    }

    public String getPassword() {
        return password;
    }

    public String getDescreption() {
        return descreption;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public String getTwitter() {
        return twitter;
    }
    public byte[] getLogo() {
        return logo;
    }

}
