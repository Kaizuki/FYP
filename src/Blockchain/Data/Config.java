package Blockchain.Data;

public class Config {
    public static final String ALGORITHM = "RSA";
	public static final String HASH_ALGORITHM = "SHA-256";
	public static final String SIGNATURE_ALGORITHM = "SHA256WithRSA";
	
	public static final String PUBLICKEY_FILE = "FYP/src/Blockchain/Data/PublicKey";
    public static final String PRIVATEKEY_FILE = "FYP/src/Blockchain/Data/PrivateKey";
    
    public static final String BC_OBJ_FILE = "FYP/src/Blockchain/Data/blockchainobj.dat";
    public static final String BC_FILE = "FYP/src/Blockchain/Data/bc.txt";
    public static final String BC_ORDER_FILE = "FYP/src/Blockchain/Data/bc_order.txt";
    // public static final String DB_USER_CREDENTIAL = "./src/Blockchain.Data/dbUserCredential.txt";
}
