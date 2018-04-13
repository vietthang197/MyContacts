package thangducanh.tagroup.com.mycontacts;

import android.app.Dialog;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import thangducanh.tagroup.com.mycontacts.model.User;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText edtRegUserName, edtRegPassWord, edtRegConfirmPassWord, edtRegEmail, edtRegHoTen;
    private Button btnQuayLai, btnDangKy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
        initEvents();
    }

    private void initEvents() {
        btnQuayLai.setOnClickListener(this);
        btnDangKy.setOnClickListener(this);

    }

    private void initView() {
        edtRegUserName = findViewById(R.id.edt_reg_user_name);
        edtRegPassWord = findViewById(R.id.edt_reg_pass_word);
        edtRegConfirmPassWord = findViewById(R.id.edt_reg_confirm_pass_word);
        edtRegEmail = findViewById(R.id.edt_reg_email);
        edtRegHoTen = findViewById(R.id.edt_reg_ten);
        btnQuayLai = findViewById(R.id.btn_reg_quay_lai);
        btnDangKy = findViewById(R.id.btn_reg_dang_ky);
    }

    @Override
    public void onBackPressed() {
       doOnFinish();
    }
    public void doOnFinish(){
        finish();
        overridePendingTransition(R.anim.slide_out_right,R.anim.slide_in_left);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_reg_dang_ky:
                doOnRegister();
                break;
            case R.id.btn_reg_quay_lai:
                doOnFinish();
                break;
        }
    }

    private void doOnRegister() {

        Dialog dialog=new Dialog(this,android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        dialog.setContentView(R.layout.dialog_loading);


        String userName = edtRegUserName.getText().toString();
        String passWord = edtRegPassWord.getText().toString();
        String conFirmPassWord = edtRegConfirmPassWord.getText().toString();
        String email = edtRegEmail.getText().toString();
        String name = edtRegHoTen.getText().toString();

        if(userName.trim() == null || passWord.trim() == null || conFirmPassWord == null || email == null || name == null){
            Toast.makeText(RegisterActivity.this,"Bạn chưa điền hết thông tin !",Toast.LENGTH_SHORT).show();
            dialog.dismiss();
            return;
        }
        String regex = "[a-zA-Z0-9_]{3,}";
        if(!userName.matches(regex) || !passWord.matches(regex)){
            Toast.makeText(RegisterActivity.this,"Invalid username or password",Toast.LENGTH_SHORT).show();
            dialog.dismiss();
            return;
        }
        User user = new User(userName,passWord,email,name);
    }



}
