package Blockchain;

import java.io.File;
import java.util.LinkedList;

import com.google.gson.GsonBuilder;

import Blockchain.Data.Config;

public class BlockchainOperation {
    static LinkedList<Block> blockchain = new LinkedList<Block>();

    public static void initBlock(Object data) throws Exception {
        Block b1 = new Block(data, "0", 0);
        blockchain.add(b1);
        Blockchain.persist(blockchain);
        distributeBlockchain(blockchain);   
    }

    public static void nextBlock(Object data) throws Exception {
        blockchain = Blockchain.getBlockchain();
        Block block = new Block(data, blockchain.getLast().getNowHash(), blockchain.getLast().getBlockIndex());
        blockchain.add(block);
        Blockchain.persist(blockchain);
        distributeBlockchain(blockchain);
    }

    public static void distributeBlockchain(LinkedList<Block> blockchain) {
        String temp = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        Blockchain.distribute(temp);
    }

    public static void createBlock(Object data) throws Exception {
        File file = new File(Config.BC_OBJ_FILE);
        if (file.exists() && !file.isDirectory())
            nextBlock(data);
        else
            initBlock(data);
    }
}
