package servlet.reflection;

import lombok.Getter;
import lombok.Setter;

public class User {
    @Getter
    @Setter
    private String userName;
    @Getter
    @Setter
    private int userAge;

    public User() {
    }

    public User(String userName, int userAge) {
        this.userName = userName;
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}
