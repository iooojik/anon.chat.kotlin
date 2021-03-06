package iooojik.anon.meet.ui.auth.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import iooojik.anon.meet.R
import iooojik.anon.meet.data.models.user.User
import iooojik.anon.meet.databinding.FragmentRegistration1Binding
import iooojik.anon.meet.hideKeyBoard


class RegistrationFragment1 : Fragment(), RegistrationFragment1Logic {
    private lateinit var binding: FragmentRegistration1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistration1Binding.inflate(inflater)
        binding.fragment = this
        return binding.root
    }

    fun goToNextStep(view: View?) {
        view?.let {
            User.mUserLogin = binding.emailTextField.editText!!.text.trim().toString()
            User.mPassword = binding.passwordTextField.editText!!.text.trim().toString()
            if (checkEmailAndPassword(
                    requireView(),
                    resources,
                    binding.passwordTextField.editText!!.text.trim().toString()
                )
            ) {
                findNavController().navigate(R.id.action_registrationFragment1_to_registrationFragment2)
            }
        }
    }

    fun onLayoutClick(view: View?) {
        view?.let {
            hideKeyBoard(requireActivity(), binding.root)
            binding.passwordTextField.clearFocus()
            binding.emailTextField.clearFocus()
        }
    }

}