package iooojik.anon.meet.ui.auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import iooojik.anon.meet.R
import iooojik.anon.meet.data.models.user.User
import iooojik.anon.meet.databinding.FragmentLoginBinding
import iooojik.anon.meet.hideKeyBoard

class LoginFragment : Fragment(), LoginFragmentLogic {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater)
        binding.activity = requireActivity() as AppCompatActivity
        binding.fragment = this
        return binding.root
    }

    fun hideKeyboardAndClearFocus(view: View?) {
        view?.let {
            hideKeyBoard(requireActivity(), binding.root)
            binding.passwordTextField.clearFocus()
            binding.emailTextField.clearFocus()
        }
    }

    fun onRegistrationButtonClick(view: View?) {
        view?.let {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment1)
        }
    }

    fun onLoginButtonClick(view: View?) {
        view?.let {
            User.mUserLogin = binding.emailTextField.editText!!.text.trim().toString()
            User.mPassword = binding.passwordTextField.editText!!.text.trim().toString()
            if (checkEmailAndPassword(
                    requireView(),
                    resources,
                    binding.passwordTextField.editText!!.text.trim().toString()
                )
            ) {
                auth(findNavController(), requireActivity(), binding)
            }
        }
    }
}