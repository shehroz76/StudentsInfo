package com.example.msk.studentsinfo.NetworkUtilities;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.example.msk.studentsinfo.Model.Model;

import java.util.List;

/**
 * Created by DELL on 7/29/2016.
 */
public class JasonDataLoader extends AsyncTaskLoader<List<Model>> {


    private static final String LOG_TAG = JasonDataLoader.class.getName();


    private String mUrl;


    public JasonDataLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }


    @Override
    public List<Model> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        List<Model> students_data = QueryUtils.fetchStudentsData(mUrl);
        return students_data;
    }
}
