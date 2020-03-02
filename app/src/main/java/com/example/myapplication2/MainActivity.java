package com.example.myapplication2;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public Button btnThem , btnSua;
    private EditText editTuoi ,editTen;
    private ListView listView;
    private UserAdapter userAdapter;
    private ArrayList<User> listUser;
    private int vitri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXA();
        btnThem.setEnabled(false);
        btnSua.setEnabled(false);
        listUser = new ArrayList<>();
        listUser.add(new User("Trieu Hoai Thuong" , 21));
        listUser.add(new User("Nong Thi Thu" , 26));
        userAdapter = new UserAdapter(this ,R.layout.user , listUser);
        listView.setAdapter(userAdapter);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = editTen.getText().toString().trim();
                try{
                    int tuoi = Integer.parseInt(editTuoi.getText().toString().trim());
                    listUser.add(new User(ten , tuoi));
                    editTen.setText("");
                    editTuoi.setText("");
                    editTen.requestFocus();
                    userAdapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this , "Thêm thành công" , Toast.LENGTH_SHORT).show();
                }catch (Exception ex){
                    Toast.makeText(MainActivity.this , "Bạn phải nhập tuổi là chữ số" , Toast.LENGTH_SHORT).show();
                }


            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = editTen.getText().toString().trim();
                int tuoi = Integer.parseInt(editTuoi.getText().toString().trim());
                listUser.set(vitri , new User(ten , tuoi));
                editTen.setText("");
                editTuoi.setText("");
                editTen.requestFocus();
                vitri = -1;
                userAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this , "Sửa thành công" , Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                listUser.remove(position);
                userAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this , "Xóa thành công" , Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user = listUser.get(position);
                editTen.setText(user.getTen()+"");
                editTuoi.setText(user.getTuoi()+"");
                vitri = position;
                validate();
            }
        });
        editTen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validate();
            }
        });
        editTuoi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validate();
            }
        });
    }
    public void AnhXA(){

        editTuoi = findViewById(R.id.editTuoi);
        editTen = findViewById(R.id.editTen);
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        listView = findViewById(R.id.listView);

    }

    public void validate(){
        if(editTen.getText().toString().length()!=0 && editTuoi.getText().toString().length()!=0){

            btnThem.setEnabled(true);
            btnSua.setEnabled(true);
        }else{
            btnThem.setEnabled(false);
            btnSua.setEnabled(false);
        }
    }
}
