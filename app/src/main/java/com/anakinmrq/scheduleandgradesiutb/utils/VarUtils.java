package com.anakinmrq.scheduleandgradesiutb.utils;

public class VarUtils {

    public static boolean isEtuNumber(String etunum){
        if(etunum.replaceAll(" ", "").length() != 8) return false;
        try{ int num = Integer.parseInt(etunum);
        }catch(Exception ex){ return false; }
        return true;
    }

}
