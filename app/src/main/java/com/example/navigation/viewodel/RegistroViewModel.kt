package com.example.navigation.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class EstadoRegistro(
    val nombre: String = "",
    val email: String = "",
    val password: String = "",
    val nombreValido: Boolean = false,
    val emailValido: Boolean = false,
    val passwordValida: Boolean = false
) {
    val registroActivo: Boolean
        get() = nombreValido && emailValido && passwordValida
}

class RegistroViewModel : ViewModel() {

    private val _estado = MutableStateFlow(EstadoRegistro())
    val estado: StateFlow<EstadoRegistro> = _estado.asStateFlow()

    fun cambiarNombre(nombre: String) {
        val valido = nombre.trim().length >= 2
        _estado.value = _estado.value.copy(nombre = nombre, nombreValido = valido)
    }

    fun cambiarEmail(email: String) {
        val valido = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        _estado.value = _estado.value.copy(email = email, emailValido = valido)
    }

    fun cambiarPassword(password: String) {
        val valida = password.length >= 6
        _estado.value = _estado.value.copy(password = password, passwordValida = valida)
    }
}