package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.SignInMethodQueryResult

class MainViewModel : ViewModel() {
    private val auth = FirebaseAuth.getInstance()
    val emailStatus = MutableLiveData<String>()
    val isEmailValid = MutableLiveData<Boolean>()

    fun validateEmailRealtime(email: String) {
        // Validación de formato
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailStatus.value = "Correo no válido"
            isEmailValid.value = false
            return
        }
        // Consultar si el correo ya está registrado en Firebase
        auth.fetchSignInMethodsForEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val result: SignInMethodQueryResult? = task.result
                    val signInMethods = result?.signInMethods
                    if (signInMethods.isNullOrEmpty()) {
                        emailStatus.value = "Correo disponible"
                        isEmailValid.value = true
                    } else {
                        emailStatus.value = "Correo ya registrado"
                        isEmailValid.value = false
                    }
                } else {
                    emailStatus.value = "Error al validar"
                    isEmailValid.value = false
                }
            }
    }
}
