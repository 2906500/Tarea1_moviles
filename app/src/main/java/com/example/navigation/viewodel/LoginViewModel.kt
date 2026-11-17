package com.example.navigation.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class EstadoLogin(
    val email: String = "",
    val password: String = "",
    val emailValido: Boolean = false,
    val passwordValida: Boolean = false
) {

    val loginActivo: Boolean
        get() = emailValido && passwordValida
}

class LoginViewModel : ViewModel() {


    private val _estado = MutableStateFlow(EstadoLogin())


    val estado: StateFlow<EstadoLogin> = _estado.asStateFlow()

    fun cambiarEmail(email: String) {
        val valido = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        _estado.value = _estado.value.copy(email = email, emailValido = valido)
    }

    fun cambiarPassword(password: String) {
        val valida = password.length >= 6
        _estado.value = _estado.value.copy(password = password, passwordValida = valida)
    }
}