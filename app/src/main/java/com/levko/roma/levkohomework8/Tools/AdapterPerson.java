package com.levko.roma.levkohomework8.Tools;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.levko.roma.levkohomework8.R;

import java.util.ArrayList;

/**
 * Created by User on 09.03.2016.
 */
public class AdapterPerson extends RecyclerView.Adapter<ViewHolderPerson> {

    private ArrayList<Card> persons;
    CallBackInterface callBackInterface;

    public AdapterPerson(CallBackInterface callBackInterface, ArrayList<Card> persons) {
        this.persons = persons;
        this.callBackInterface = callBackInterface;
    }

    @Override
    public ViewHolderPerson onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_person, parent, false);
        return new ViewHolderPerson(view, callBackInterface);
    }

    @Override
    public void onBindViewHolder(ViewHolderPerson holder, int position) {
        TextView textFirstName = holder.tvName;
        CardView cardView = holder.cardView;
        textFirstName.setText(persons.get(position).getFirstName());
        cardView.setCardBackgroundColor(persons.get(position).isAllFieldsNotEmpty() ? Color.RED : Color.YELLOW);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}