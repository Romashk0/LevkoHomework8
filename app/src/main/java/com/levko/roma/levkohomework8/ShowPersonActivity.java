package com.levko.roma.levkohomework8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.levko.roma.levkohomework8.Tools.Card;
import com.levko.roma.levkohomework8.Tools.Constants;

/**
 * Created by User on 09.03.2016.
 */
public class ShowPersonActivity extends AppCompatActivity {

    TextView tvFirstName,
            tvLastName,
            tvGender,
            tvAge,
            tvPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_person);

        findViews();
        setDataToViews();
        addSupportActionBar();
    }

    private void setDataToViews() {
        Bundle bundle = getIntent().getExtras();
        Card person = (Card) bundle.getSerializable(Constants.BUNDLE_KEY);
        tvFirstName.setText(person.getFirstName());
        tvLastName.setText(person.getLastName());
        tvGender.setText(person.getGender());
        tvAge.setText(person.getAge());
        tvPhoneNumber.setText(person.getPhoneNumber());
    }

    private void findViews() {
        tvFirstName = (TextView) findViewById(R.id.tv_first_name_ASP);
        tvLastName = (TextView) findViewById(R.id.tv_last_name_ASP);
        tvGender = (TextView) findViewById(R.id.tv_gender_ASP);
        tvAge = (TextView) findViewById(R.id.tv_age_ASP);
        tvPhoneNumber = (TextView) findViewById(R.id.tv_phone_number_ASP);
    }

    private void addSupportActionBar() {
        final android.support.v7.app.ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setTitle(getResources().getString(R.string.activity_add_person_title));
            mActionBar.setHomeButtonEnabled(true);
            mActionBar.setDisplayShowHomeEnabled(true);
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
