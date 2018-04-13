package thangducanh.tagroup.com.mycontacts;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

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
        }
    }

    private void xuLyDangNhap() {
        Intent intentMainAcitivty = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intentMainAcitivty);
    }
}
