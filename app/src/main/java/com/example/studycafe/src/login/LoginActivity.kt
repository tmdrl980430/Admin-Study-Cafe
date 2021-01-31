package com.example.studycafe.src.login

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.studycafe.config.BaseActivity
import com.example.studycafe.databinding.ActivityLoginBinding
import com.kakao.sdk.auth.LoginClient
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate){

    val TAG = "tag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.window?.apply {
            this.statusBarColor = Color.WHITE
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        login_activity_btn.setOnClickListener {
            // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
            if (LoginClient.instance.isKakaoTalkLoginAvailable(this)) {
                LoginClient.instance.loginWithKakaoTalk(this ) { token, error ->
                    Log.i(TAG, "loginWithKakaoTalk $token $error")
                }
            } else {
                LoginClient.instance.loginWithKakaoAccount(this) { token, error ->
                    Log.i(TAG, "loginWithKakaoTalk $token $error")
                }
            }
        }
    }
}