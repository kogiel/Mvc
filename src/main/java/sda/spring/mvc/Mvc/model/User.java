package sda.spring.mvc.Mvc.model;

public class User {
    long id;


    private String name;
    private String surname;
    private String login;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
}
