package sample.model;

import java.io.Serializable;

public class User implements Serializable {
    private String userName;
    private String passWord;

    public User(String userName,String passWord){
        this.userName = userName;
        this.passWord = passWord;

    }
    public boolean correctPassWord(String passWord){
        return this.passWord.equals(passWord);
    }

    public String getUserName() {
        return userName;
    }
}
