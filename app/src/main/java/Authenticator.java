import java.security.NoSuchAlgorithmException;
        import java.security.SecureRandom;
        import java.security.spec.InvalidKeySpecException;
        import java.security.spec.KeySpec;
        import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
        import javax.crypto.spec.PBEKeySpec;

public class Authenticator {

    public static byte[] generateHash(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String algorithm = "PBKDF2WithHmacSHA512";
        int length = 512;
        int iterations = 60000;
        KeySpec sp = new PBEKeySpec(password.toCharArray(), salt, iterations, length);
        SecretKeyFactory kf = SecretKeyFactory.getInstance(algorithm);
        return kf.generateSecret(sp).getEncoded();

    }

    public static byte[] generateSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[8];
        sr.nextBytes(salt);
        return salt;
    }

    public static boolean check(byte[] hash_Input, String hash_User) {
        return Arrays.equals(hash_Input, hash_User.getBytes());
    }
    long  x_Y = 1000000000;

}


//WHADDUP DOEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE








