package com.example.intermediate.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.intermediate.R
import com.example.intermediate.data.model.UserModel
import com.example.intermediate.databinding.ActivityRegisterBinding
import com.example.intermediate.ui.login.MainActivity

class RegisterActivity : AppCompatActivity(),  View.OnClickListener {

    companion object{
        const val FIELD_REQUIRED = "Field tidak boleh kosong"
        const val FIELD_IS_NOT_VALID = "Email tidak valid"
    }

    private val registerViewModel: RegisterViewModel by viewModels()
    private lateinit var binding : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivPassword.setOnClickListener(this)
        binding.btnDaftar.setOnClickListener(this)
        binding.btnLogin.setOnClickListener(this)
    }

    private fun switchPassword() {
        if (binding.ivPassword.getTag().toString().equals("hidden")) {
            binding.ivPassword.setTag("show")
            binding.ivPassword.setImageDrawable(resources.getDrawable(R.drawable.ic_show_password))
            binding.etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
        } else {
            binding.ivPassword.setTag("hidden")
            binding.ivPassword.setImageDrawable(resources.getDrawable(R.drawable.ic_hide_password))
            binding.etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance())
        }
    }

    override fun onClick(view: View) {
        if (view.id == R.id.iv_password){
            switchPassword()
        }
        else if (view.id == R.id.btnDaftar){

            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val nama = binding.etName.text.toString().trim()

            if (email.isEmpty()) {
                binding.etEmail.error = MainActivity.FIELD_REQUIRED
                return
            }

            if (!isValidEmail(email)) {
                binding.etEmail.error = MainActivity.FIELD_IS_NOT_VALID
                return
            }

            if (nama.isEmpty()){
                binding.etEmail.error = MainActivity.FIELD_REQUIRED
                return
            }

            register(email,password,nama)

        }else if (view.id == R.id.btnLogin){
            val mIntent = Intent(this@RegisterActivity, MainActivity::class.java)
            startActivity(mIntent)
        }
    }

    private fun register(email: String, password: String, nama: String) {
        registerViewModel.register(email,password,nama).observe(this){
            if(it != null){
                Log.i("cekRegister", "register berhasil")
            }
        }
    }

    private fun isValidEmail(email: CharSequence): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}