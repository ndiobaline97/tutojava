package model;

public class User {
    private int id;

    private String nomComplet;
    private String login;
    private String password;
    private String profile;

    public User(String nomComplet ,String login ,String password, String profile) {

        this.nomComplet =nomComplet;
        this.login =login;
        this.password =password;
        this.profile =profile;
    }
    public User(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

}
