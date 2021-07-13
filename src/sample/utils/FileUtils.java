package sample.utils;

import sample.model.User;

import java.io.*;

public class FileUtils {
    public void saveNewUser(User u){
        String fileName = "Users\\" + u.getUserName() + ".bin";
        try(FileOutputStream out = new FileOutputStream(fileName)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);

            objectOutputStream.writeObject(u);
            out.close();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public User openUserFile(String userName){
        User u = null;
        String fileName = "Users\\" + userName + ".bin";
        try (FileInputStream in = new FileInputStream(fileName)){
            ObjectInputStream objectInputStream = new ObjectInputStream(in);
            u = (User) objectInputStream.readObject();
            in.close();
            objectInputStream.close();
            return u;
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return u;
    }
}

