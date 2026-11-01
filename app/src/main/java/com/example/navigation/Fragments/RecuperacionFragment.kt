package com.example.navigation.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigation.databinding.FragmentRecuperacionBinding

class RecuperacionFragment : Fragment() {

    private var _binding: FragmentRecuperacionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecuperacionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRecuperar.setOnClickListener {
            val email = binding.EmailRecuperacion.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(requireContext(), "Introduce un correo válido", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Instrucciones enviadas a $email", Toast.LENGTH_LONG).show()
                findNavController().popBackStack()
            }
        }

        binding.VolverLoginDesdeRecuperacion.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}