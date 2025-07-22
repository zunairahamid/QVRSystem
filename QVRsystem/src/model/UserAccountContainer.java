package model;
import java.util.ArrayList;
import java.util.List;
public class UserAccountContainer {
private static List<UserAccount> userAccounts = new ArrayList<UserAccount>();
public static void addUser(UserAccount user) {
if (user!=null)
userAccounts.add(user);
}
public static UserAccount find(String username) {
for (UserAccount user : userAccounts)
if(user.getUsername().equals(username))
return user;
return null;
}
public static UserAccount login(String username, String password) {
UserAccount temp = find(username);
if (temp!=null && temp.isValid(username, password))
{
temp.login();
return temp;
}
return null;
}
public static void logout(UserAccount user) {
if(user.isLogged())
user.logout();
}
}
