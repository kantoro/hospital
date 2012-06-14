package kg.cloud.hospital;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;





/**
 *
 * @author Kantoro
 */
public class PasswordEncryptionService {
    
    public String getEncryptedPassword(String password)
            throws NoSuchAlgorithmException {
        
        String algorithmName = "MD5";
        
        //KeySpec spec = new PBEKeySpec(password.toCharArray());
        byte[] defaultBytes = password.getBytes();
        
        MessageDigest algorithm = MessageDigest.getInstance(algorithmName);
        algorithm.reset();
        algorithm.update(defaultBytes);
        byte messageDigest[] = algorithm.digest();
        
        StringBuffer hexString = new StringBuffer();
        for (int i=0;i<messageDigest.length;i++) {
            hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
        }
        String foo = messageDigest.toString();
        System.out.println("password "+foo+" md5 version is "+hexString.toString());
        password=hexString+"";
        return password;
        
        
        
        //KeySpec spec2= new DESKeySpec(password.toCharArray());
        //MessageD
        
        //SecretKeyFactory f = SecretKeyFactory.getInstance(algorithm);        
        //System.out.println(Security.getProviders());
        //Provider [] arr = Security.getProviders();
        //arr[5].
        
        
        
        
        //byte[] encryptedBytePass = f.generateSecret(spec2).getEncoded();
        //String encryptedPass = "";
        //for(byte element:encryptedBytePass) {
        //    encryptedPass+=element;
        //}
        //System.out.println("Encrypted Pass... " + encryptedPass);
        //return encryptedPass;
    }
}
