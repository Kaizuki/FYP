package Blockchain;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;

import Blockchain.Data.Config;

public class Blockchain {
    public static void persist(LinkedList<Block> blockchain) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(Config.BC_OBJ_FILE); 
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);) {
                objectOutputStream.writeObject(blockchain);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static LinkedList<Block> getBlockchain() {
        try (FileInputStream fileInputStream = new FileInputStream(Config.BC_OBJ_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
                return (LinkedList<Block>) objectInputStream.readObject();
        } catch (Exception e) {
            return new LinkedList<Block>();
        } 
    }

    public static void distribute(String blockchain) {
        try {
            Files.write(Paths.get(Config.BC_FILE), blockchain.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
