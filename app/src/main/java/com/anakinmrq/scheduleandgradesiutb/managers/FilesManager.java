package com.anakinmrq.scheduleandgradesiutb.managers;

import android.util.Log;

import com.anakinmrq.scheduleandgradesiutb.objects.Profile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.util.ArrayList;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class FilesManager {

    private static final String filextent = ".hh0w";
    private static final String profiles_file = "/profiles"+filextent;

    private static final String x = "3O98YDN7Y937Y937@@3#32DBXH789Y3D";
    private static final String algo = "AES";

    private static ArrayList<Profile> profiles = new ArrayList<>();

    private static File fprofiles;

    /* GETTERS */
    public static ArrayList<Profile> getProfiles(){
        return profiles;
    }

    /* SETTERS */
    public static void addProfile(Profile pr){
        if(profileExists(pr)) return;
        profiles.add(pr);
    }

    /* Main Function */
    public static void setupFiles(File base) {
        if(!base.exists() || !base.isDirectory()) base.mkdirs();
        String dirpath = base.getAbsolutePath();

        fprofiles = new File(dirpath+profiles_file);

        Object objprofiles = getFile(fprofiles);
        if(objprofiles != null){
            FilesManager.profiles.clear();
            FilesManager.profiles = (ArrayList<Profile>) objprofiles;
        }

    }

    private static boolean profileExists(Profile profile){
        for(Profile pr : profiles){
            if(pr.getNom().replaceAll(" ", "").equalsIgnoreCase(profile.getNom().replaceAll(" ", ""))
                    && pr.getPrenom().replaceAll(" ", "").equalsIgnoreCase(profile.getPrenom().replaceAll(" ", ""))){
                return true;
            }
        }
        return false;
    }

    public static void saveProfiles(){
        saveFile(fprofiles, profiles);
    }

    /* Serialization & Crypto */
    public static Object getFile(File file){
        Object obj = null;
        try{
            if(!file.exists() || !file.isFile()) return null;
            FileInputStream fis = new FileInputStream(file);
            byte[] bytearray = new byte[(int) file.length()];
            fis.read(bytearray);

            bytearray = decrypt(bytearray);

            ByteArrayInputStream bais = new ByteArrayInputStream(bytearray);
            ObjectInputStream ois = new ObjectInputStream(bais);
            obj = ois.readObject();

            fis.close();
            ois.close();
            bais.close();
        }catch(Exception ex){
            ex.printStackTrace();
            if(ex.getClass().getName().toLowerCase().startsWith("javax.crypto")){
                Log.i("INFO", "BAD KEY !");
            }
        }
        return obj;
    }

    public static void saveFile(File file, Object obj){
        try{
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();

            byte[] bytearray = baos.toByteArray();
            bytearray = encrypt(bytearray);

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bytearray);
            fos.close();
            baos.close();
            Log.i("INFO", file.getName()+" Saved !");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    /* CRYPTO */
    public static byte[] encrypt(byte[] Data) throws Exception {
        Key k = new SecretKeySpec(x.getBytes(), algo);
        Cipher c = Cipher.getInstance(algo);
        c.init(Cipher.ENCRYPT_MODE, k);
        byte[] encVal = c.doFinal(Data);
        return encVal;
    }
    public static byte[] decrypt(byte[] encryptedData) throws Exception {
        Key k = new SecretKeySpec(x.getBytes(), algo);
        Cipher c = Cipher.getInstance(algo);
        c.init(Cipher.DECRYPT_MODE, k);
        byte[] decValue = c.doFinal(encryptedData);
        return decValue;
    }

}
