package com.example.intermediate.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import androidx.activity.viewModels
import com.example.intermediate.R
import com.example.intermediate.data.model.UserModel
import com.example.intermediate.databinding.ActivityRegisterBinding
import com.example.intermediate.ui.login.MainActivity
import com.shashank.sony.fancytoastlib.FancyToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

            val data = UserModel(nama,email,password)
            registUser(data)

        }else if (view.id == R.id.btnLogin){
            val mIntent = Intent(this@RegisterActivity, MainActivity::class.java)
            startActivity(mIntent)
        }
    }

    private fun isValidEmail(email: CharSequence): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun registUser(user: UserModel){
        registerViewModel.registerUser(user).observe(this){
            when(it){
                is ApiResponse.Loading ->{
                    binding.progresbar.visibility = View.VISIBLE
                }
                is ApiResponse.Success ->{
                    try {
                        binding.progresbar.visibility = View.GONE
                    }finally {
                        MainActivity.start(this)
                        finish()
                        FancyToast.makeText(this, "Register Success",
                            FancyToast.LENGTH_LONG, FancyToast.SUCCESS, 0, false);
                    }
                }
                is ApiResponse.Error ->{
                    binding.progresbar.visibility = View.GONE
                    FancyToast.makeText(this, "Register Failed",
                        FancyToast.LENGTH_LONG, FancyToast.ERROR, 0, false);
                }
                else -> {
                    FancyToast.makeText(this, "Network error",
                        FancyToast.LENGTH_LONG, FancyToast.CONFUSING, 0, false);
                }
            }
        }
    }


}