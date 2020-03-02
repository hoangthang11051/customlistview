package com.example.myapplication2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<User> listUser;

    public UserAdapter(Context context, int layout, List<User> listUser) {
        this.context = context;
        this.layout = layout;
        this.listUser = listUser;
    }
    @Override
    public int getCount() {
        return listUser.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(layout , null);
        //anh xa view
        TextView tvTen = (TextView) convertView.findViewById(R.id.tvTen);
        TextView tvTuoi = (TextView) convertView.findViewById(R.id.tvTuoi);

        //gan gai tri
        User user = listUser.get(position);
        tvTen.setText(""+user.getTen());
        tvTuoi.setText(""+user.getTuoi());
        return convertView;
    }
}
