package thangducanh.tagroup.com.mycontacts;

import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_ACCOUNT = 1111;
    private TextInputEditText edtUserName, edtPassWord;
    private Button btnDangNhap;
    private TextView tvDangKy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        initEvents();
    }

    private void initEvents() {
        SpannableString content = new SpannableString(getResources().getString(R.string.dang_ky_tai_day));
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        tvDangKy.setText(content);
        tvDangKy.setOnClickListener(this);

        btnDangNhap.setOnClickListener(this);
    }

    private void initView() {
        edtUserName = findViewById(R.id.edt_user_name);
        edtPassWord = findViewById(R.id.edt_pass_word);
        btnDangNhap = findViewById(R.id.btn_dang_nhap);
        tvDangKy = findViewById(R.id.tv_dang_ky);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dang_nhap:
                xuLyDangNhap();
                break;
            case R.id.tv_dang_ky:
                xuLyDangKy();
                break;
        }
    }

    private void xuLyDangKy() {
        Intent intentMainAcitivty = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivityForResult(intentMainAcitivty,REQUEST_ACCOUNT);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    private void xuLyDangNhap() {

        Dialog dialog=new Dialog(this,android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        dialog.setContentView(R.layout.dialog_loading);
        dialog.show();
        boolean check = checkValueRegister(edtUserName.getText().toString(),edtPassWord.getText().toString());
        if(check){
            Toast.makeText(LoginActivity.this,"regex ok",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(LoginActivity.this,"regex failed",Toast.LENGTH_SHORT).show();
        }
    }
    public boolean checkValueRegister(String userName, String passWord){
        String regex = "[a-zA-Z0-9_]{3,}";
        return userName.matches(regex);
    }
}
