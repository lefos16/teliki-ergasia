package users;

public class Users
{
    private String username;
    private String password;
    private String name;
    private String surname;
    private String department;
    public static int userCounter;

    public Users(){
        userCounter ++;
    }

    public Users(String username,String password, String name, String surmane,String department){
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surmane;
        this.department = department;
        userCounter ++;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
