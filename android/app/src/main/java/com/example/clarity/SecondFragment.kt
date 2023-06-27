package com.example.clarity

<<<<<<< HEAD
import android.app.AlertDialog
=======
>>>>>>> e447f3838fff6eb13007107376fdf8ab08935c85
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.clarity.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonCreateAccount.setOnClickListener {
            val username = binding.editTextUsername.text.toString()
            val password = binding.editTextPassword.text.toString()
            val name = binding.editTextName.text.toString()
            val email = binding.editTextEmail.text.toString()

            //call api

<<<<<<< HEAD
            val successfulSignup = true

            if(successfulSignup) {
                val intent = Intent(activity, IndexActivity::class.java)
                startActivity(intent)
            } else {
                binding.editTextUsername.setText("")
                binding.editTextPassword.setText("")
                binding.editTextName.setText("")
                binding.editTextEmail.setText("")
                unsuccessfulSignUp()
            }
=======
            findNavController().navigate(R.id.FirstFragment) //will go to login page once they signup for now
>>>>>>> e447f3838fff6eb13007107376fdf8ab08935c85
        }

        binding.loginLink.setOnClickListener {
            findNavController().navigate(R.id.FirstFragment)
        }


    }

    private fun unsuccessfulSignUp() {
        val alertDialog = AlertDialog.Builder(requireContext()).create() //the method to get context might be incorrect
        alertDialog.setMessage("Unsuccessful Sign-Up. Please try again.")
        alertDialog.setTitle("Incorrect Credentials")
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK") { dialog, _ ->
            dialog.dismiss()
        }
        alertDialog.show()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}