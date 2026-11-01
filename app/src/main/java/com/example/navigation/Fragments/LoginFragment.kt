package com.example.navigation.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigation.databinding.FragmentLoginBinding
import com.example.navigation.R

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            val email = binding.Email.text.toString()
            val password = binding.Password.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Rellena todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Bienvenido", Toast.LENGTH_SHORT).show()
                // Aquí iría la lógica real de login
            }
        }

        binding.Registro.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_registro)
        }

        binding.Recuperar.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_recuperacion)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}