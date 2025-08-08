package com.example.myapplication

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Observa los estados del email
        viewModel.emailStatus.observe(this, Observer { status ->
            binding.emailStatusTextView.text = status
        })
        viewModel.isEmailValid.observe(this, Observer { isValid ->
            binding.registerButton.isEnabled = isValid == true
        })

        // Valida en tiempo real mientras escribe el usuario
        binding.emailEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val email = s.toString()
                viewModel.validateEmailRealtime(email)
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        // (Opcional) Puedes poner la acción del botón de registro aquí:
        /*
        binding.registerButton.setOnClickListener {
            // Lógica de registro, si quieres implementarla
        }
        */
    }
}
