package com.anakinmrq.scheduleandgradesiutb.managers;

import com.anakinmrq.scheduleandgradesiutb.objects.Profile;

public class ProfilesManager {

    private static Profile currentProfile;

    public static Profile getCurrentProfile(){
        if(currentProfile == null){
            Profile pr = null;
            if(FilesManager.getProfiles().size() > 0) pr = FilesManager.getProfiles().get(0);
            return pr;
        }
        return currentProfile;
    }

    public static void setCurrentProfile(Profile pr){
        currentProfile = pr;
    }

}
