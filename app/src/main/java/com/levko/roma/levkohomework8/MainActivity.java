package com.levko.roma.levkohomework8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import com.levko.roma.levkohomework8.Tools.AdapterPerson;
import com.levko.roma.levkohomework8.Tools.CallBackInterface;
import com.levko.roma.levkohomework8.Tools.Card;
import com.levko.roma.levkohomework8.Tools.Constants;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CallBackInterface {

    private RecyclerView mRecyclerView;
    private AdapterPerson mPersonAdapter;
    private ArrayList<Card> mPersonList = new ArrayList<>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setAdapterToRecyclerView();
    }

    private void findViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_AM);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, AddPersonActivity.class);
        startActivityForResult(intent, Constants.REQUEST_ACTIVITY_CREATE);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == Constants.REQUEST_ACTIVITY_CREATE) {
            Bundle bundle = data.getExtras();
            Card person = (Card) bundle.getSerializable(Constants.BUNDLE_KEY);
            addPerson(person);
        }
    }

    public void addPerson(Card person) {
        mPersonList.add(person);
        mPersonAdapter.notifyItemInserted(mPersonAdapter.getItemCount() - 1);
        mPersonAdapter.notifyItemRangeInserted(mPersonAdapter.getItemCount() - 1, mPersonAdapter.getItemCount());
    }

    private void setAdapterToRecyclerView() {
        mPersonAdapter = new AdapterPerson(this, mPersonList);
        mRecyclerView.setAdapter(mPersonAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void startActivity(int position) {
        Intent intent = new Intent(this, ShowPersonActivity.class);
        Card person = mPersonList.get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.BUNDLE_KEY, person);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void deleteCard(int position) {
        mPersonList.remove(position);
        mPersonAdapter.notifyItemRemoved(position);
        mPersonAdapter.notifyItemRangeChanged(position, mPersonAdapter.getItemCount());
    }

}