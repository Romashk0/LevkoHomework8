package com.levko.roma.levkohomework8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.levko.roma.levkohomework8.Tools.Card;
import com.levko.roma.levkohomework8.Tools.Constants;

/**
 * Created by User on 09.03.2016.
 */
public class AddPersonActivity extends AppCompatActivity implements View.OnClickListener{


    private EditText     etFirstName,
                         etLastName,
                         etGender,
                         etAge,
                         etPhoneNumber;
    private Button       btnAddPerson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        findViews();
        addSupportActionBar();
        setListeners();
    }

    private void setListeners() {
        btnAddPerson.setOnClickListener(this);
    }

    private void findViews() {
        etFirstName = (EditText) findViewById(R.id.et_first_name_AAP);
        etLastName = (EditText) findViewById(R.id.et_last_name_AAP);
        etGender = (EditText) findViewById(R.id.et_gender_AAP);
        etAge = (EditText) findViewById(R.id.et_age_AAP);
        etPhoneNumber = (EditText) findViewById(R.id.et_phone_number_AAP);
        btnAddPerson = (Button) findViewById(R.id.btn_add_person_AAP);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_person_AAP:
                addPerson();
                break;
        }
    }

    private void addPerson() {
        if (fieldIsEmpty(etFirstName) || fieldIsEmpty(etPhoneNumber)) {
            Toast.makeText(this, getResources().getString(R.string.fields_empty), Toast.LENGTH_SHORT).show();
        }else {
            Card person = new Card(getStringFromView(etFirstName),
                    getStringFromView(etLastName),
                    getStringFromView(etGender),
                    getStringFromView(etAge),
                    getStringFromView(etPhoneNumber));
            Bundle bundle = new Bundle();
            bundle.putSerializable(Constants.BUNDLE_KEY, person);

            Intent returnIntent = new Intent();
            returnIntent.putExtras(bundle);

            setResult(Activity.RESULT_OK, returnIntent);
            finish();
        }
    }

    private String getStringFromView(EditText v) {
        return v.getText().toString();
    }

    private boolean fieldIsEmpty(EditText editText) {
            String text = editText.getText().toString();
            return TextUtils.getTrimmedLength(text) == 0;
    }
}

