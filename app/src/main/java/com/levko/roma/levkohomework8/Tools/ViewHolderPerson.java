package com.levko.roma.levkohomework8.Tools;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.levko.roma.levkohomework8.R;

/**
 * Created by User on 09.03.2016.
 */
public class ViewHolderPerson extends RecyclerView.ViewHolder implements View.OnClickListener {

    public CardView cardView;
    public TextView tvName;
    public ImageButton iBtnDel;
    private CallBackInterface callBackInterface;

    public ViewHolderPerson(View itemView, CallBackInterface callBackInterface) {
        super(itemView);

        cardView = (CardView) itemView.findViewById(R.id.cv_item);
        this.callBackInterface = callBackInterface;

        tvName = (TextView) itemView.findViewById(R.id.tv_fn_card_view_IP);
        tvName.setOnClickListener(this);
        iBtnDel = (ImageButton) itemView.findViewById(R.id.btn_del_card_view_IP);
        iBtnDel.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_fn_card_view_IP:
                callBackInterface.startActivity(getAdapterPosition());
                break;
            case R.id.btn_del_card_view_IP:
                callBackInterface.deleteCard(getAdapterPosition());
                break;
        }
    }
}
