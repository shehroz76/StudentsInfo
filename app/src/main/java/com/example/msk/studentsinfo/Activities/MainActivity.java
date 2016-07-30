package com.example.msk.studentsinfo.Activities;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.msk.studentsinfo.Adapter.JasonDataAdapter;
import com.example.msk.studentsinfo.Model.Model;
import com.example.msk.studentsinfo.R;
import com.example.msk.studentsinfo.NetworkUtilities.JasonDataLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 7/29/2016.
 */
public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<Model>> {

    private static final String LOG_TAG = MainActivity.class.getName();


    private static final String USGS_REQUEST_URL =
            "https://raw.githubusercontent.com/mobilesiri/JSON-Parsing-in-Android/master/index.html";


    private static final int DATA_LOADER_ID = 1;

    /** Adapter for the list of students_Data */
    private JasonDataAdapter mAdapter;

    /** TextView that is displayed when the list is empty */
    private TextView mEmptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find a reference to the {@link ListView} in the layout
        ListView listView = (ListView) findViewById(R.id.list);

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        listView.setEmptyView(mEmptyStateTextView);

        // Create a new adapter that takes an empty list as input
        mAdapter = new JasonDataAdapter(this, new ArrayList<Model>());

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        listView.setAdapter(mAdapter);


        // Get a reference to the ConnectivityManager to check state of network connectivity
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        // Get details on the currently active default data network
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        // If there is a network connection, fetch data
        if (networkInfo != null && networkInfo.isConnected()) {

            LoaderManager loaderManager = getLoaderManager();

            loaderManager.initLoader(DATA_LOADER_ID, null, this);
        } else {

            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);


            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }
    }

    @Override
    public Loader<List<Model>> onCreateLoader(int i, Bundle bundle) {

        return new JasonDataLoader(this, USGS_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Model>> loader, List<Model> students_data) {

        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);


        mEmptyStateTextView.setText(R.string.no_data);


        mAdapter.clear();


        if (students_data != null && !students_data.isEmpty()) {
            mAdapter.addAll(students_data);
        }
    }
    @Override
    public void onLoaderReset(Loader<List<Model>> loader) {

        mAdapter.clear();
    }
}

