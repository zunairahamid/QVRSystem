package model;
public class UserAccount {
private String username="", password="";
private boolean isLogged=false;
public UserAccount(String username, String password) {
if (UserAccountContainer.find(username)==null) {//check if Account exists
this.username = username;
this.password = password;
UserAccountContainer.addUser(this);//automatically added to container
}
else
System.err.println("Error: Username already exists.");
}
public String getUsername() {
return username;
}
public boolean isLogged() {
return isLogged;
}
public void logout() {
final StackTraceElement[] elements = new Throwable().getStackTrace();
if (elements[1].getClassName().equals("model.UserAccountContainer"))//only the
// container is allowed to set isLogged
this.isLogged = false;
}
public void login() {
final StackTraceElement[] elements = new Throwable().getStackTrace();
if (elements[1].getClassName().equals("model.UserAccountContainer"))//only the
 //container is allowed to set isLogged
this.isLogged = true;
}
public void changePassword(String oldPassword, String newPassword) {
if (this.password.equals(oldPassword))
this.password = newPassword;
}
public boolean isValid(String username, String password) {
 return this.username.equalsIgnoreCase(username) && this.password.equals(password);
}
}
