package com.example.intermediate.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.intermediate.R
import com.example.intermediate.databinding.ActivityMainBinding
import com.example.intermediate.ui.ViewModelFactory
import com.example.intermediate.ui.register.RegisterActivity
import com.example.intermediate.ui.register.RegisterViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object{
        const val FIELD_REQUIRED = "Field tidak boleh kosong"
        const val FIELD_IS_NOT_VALID = "Email tidak valid"
        fun start(context: Context) {
            Intent(context, MainActivity::class.java).apply {
                context.startActivity(this)
            }
        }
    }

    private lateinit var binding : ActivityMainBinding

    private lateinit var viewModel: LoginViewModel

//    private val viewModel: LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivPassword.setOnClickListener(this)
        binding.btnDaftar.setOnClickListener(this)
        binding.btnLogin.setOnClickListener(this)

        val factory: ViewModelFactory = ViewModelFactory.getInstance(applicationContext)
        viewModel = ViewModelProvider(this, factory).get(LoginViewModel::class.java)
//        val viewModel: LoginViewModel by viewModels {
//            factory
//        }

//        viewModel.login("admin","admin123").observe(this){
//            if (it != null){
//
//            }
//        }
//        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
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
        else if (view.id == R.id.btnLogin){

            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (email.isEmpty()) {
                binding.etEmail.error = FIELD_REQUIRED
                return
            }

            if (!isValidEmail(email)) {
                binding.etEmail.error = FIELD_IS_NOT_VALID
                return
            }

//            viewModel.login()

        }else if (view.id == R.id.btnDaftar){
            val mIntent = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(mIntent)
        }
    }

    private fun isValidEmail(email: CharSequence): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}