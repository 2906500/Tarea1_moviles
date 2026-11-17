package com.example.navigation.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class EstadoRecuperacion(
    val email: String = "",
    val emailValido: Boolean = false
) {
    val recuperarActivo: Boolean
        get() = emailValido
}

class RecuperacionViewModel : ViewModel() {

    private val _estado = MutableStateFlow(EstadoRecuperacion())
    val estado: StateFlow<EstadoRecuperacion> = _estado.asStateFlow()

    fun cambiarEmail(email: String) {
        val valido = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        _estado.value = _estado.value.copy(email = email, emailValido = valido)
    }
}