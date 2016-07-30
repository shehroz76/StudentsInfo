package com.example.msk.studentsinfo.Model;

/**
 * Created by DELL on 7/29/2016.
 */
public class Model {

    private String mName;
    private String mEmail;
    private String mMobile;
    private String mAddress;
    private String mGender;



    public Model(String name1, String email1, String mobile1, String address1, String gender1) {
        mName = name1;
        mEmail = email1;
        mMobile = mobile1;
        mAddress = address1;
        mGender = gender1;

    }


    public String getName() {
        return mName;
    }

    public String getEmail() {
        return mEmail;
    }


    public String getMobile() {
        return mMobile;
    }


    public String getAddress() {
        return mAddress;
    }

    public String getGender() {
        return mGender;
    }
}


