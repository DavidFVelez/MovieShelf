package com.davidvelez.misseriesapp.ui.signup

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import com.davidvelez.misseriesapp.databinding.ActivitySignUpBinding
import java.util.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var signUpBinding: ActivitySignUpBinding
    private lateinit var signUpViewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = signUpBinding.root
        setContentView(view)

        signUpViewModel = ViewModelProvider(this)[SignUpViewModel::class.java]

        val errorEmailObserver = Observer<String> { errorEmailOut ->
            signUpBinding.emailEditText.error =
                "Error. El email debe contener @"
        }
        signUpViewModel.errorEmailOut.observe(this, errorEmailObserver)


        val infoOutObserver = Observer<String> { infoOut ->
            signUpBinding.infoTextView.setText(infoOut)
        }
        signUpViewModel.infoOut.observe(this, infoOutObserver)

        val errorPasswordObserver = Observer<String> { errorPasswordOut ->
            Toast.makeText(
                applicationContext,
                "Las contraseñas no son iguales",
                Toast.LENGTH_SHORT
            ).show()
            signUpBinding.repPasswordEditText.setText("")
        }
        signUpViewModel.errorPasswordOut.observe(this, errorPasswordObserver)

        val errorEmptyNameOutObserver = Observer<String> { errorEmptyNameOut ->
            signUpBinding.nameEditText.error =
                "Este campo es obligatorio"
        }
        signUpViewModel.errorEmptyNameOut.observe(this, errorEmptyNameOutObserver)

        val errorEmptyEmailOutObserver = Observer<String> { errorEmptyEmailOut ->
            signUpBinding.emailEditText.error =
                "Este campo es obligatorio"
        }
        signUpViewModel.errorEmptyEmailOut.observe(this, errorEmptyEmailOutObserver)


        val errorEmptyPasswordOutObserver = Observer<String> { errorEmptyPasswordOut ->
            signUpBinding.passwordEditText.error =
                "Este campo es obligatorio"
        }
        signUpViewModel.errorEmptyPasswordOut.observe(this, errorEmptyPasswordOutObserver)

        val errorEmptyRepPasswordOutObserver = Observer<String> { errorEmptyRepPasswordOut ->
            signUpBinding.repPasswordEditText.error =
                "Este campo es obligatorio"
        }
        signUpViewModel.errorEmptyRepPasswordOut.observe(this, errorEmptyRepPasswordOutObserver)

        val errorEmptyBirthDateOutObserver = Observer<String> { errorEmptyBirthDateOut ->
            Toast.makeText(
                applicationContext,
                "La fecha de nacimiento es obligatoria",
                Toast.LENGTH_SHORT
            ).show()
        }
        signUpViewModel.errorEmptyBirthDateOut.observe(this, errorEmptyBirthDateOutObserver)

        val errorplaceOfBirthOutObserver = Observer<String> { errorplaceOfBirthOut ->

            Toast.makeText(
                applicationContext,
                "Por favor seleccionar el lugar de nacimiento",
                Toast.LENGTH_SHORT
            ).show()
        }
        signUpViewModel.errorplaceOfBirthOut.observe(this, errorplaceOfBirthOutObserver)

        val currentDateObserver = Observer<String> { currentDate ->
            signUpBinding.fechaNacimientoEditText.setText(currentDate)

        }
        signUpViewModel.currentDate.observe(this, currentDateObserver)


        signUpBinding.fechaNacimientoEditText.setOnClickListener {
            val cal = Calendar.getInstance()
            DatePickerDialog(
                this,
                signUpViewModel.dataSet(),
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        signUpBinding.registerButton.setOnClickListener {

            signUpViewModel.registerUser(
                signUpBinding.nameEditText.text.toString(),
                signUpBinding.emailEditText.text.toString(),
                signUpBinding.passwordEditText.text.toString(),
                signUpBinding.repPasswordEditText.text.toString(),
                signUpBinding.maleRadioButton.isChecked,
                signUpBinding.actionCheckBox.isChecked,
                signUpBinding.adventureCheckBox.isChecked,
                signUpBinding.comicCheckBox.isChecked,
                signUpBinding.loveCheckBox.isChecked,
                signUpBinding.suspenseCheckBox.isChecked,
                signUpBinding.horrorCheckBox.isChecked,
                signUpBinding.fechaNacimientoEditText.text.toString(),
                signUpBinding.spCiudad.selectedItem.toString()
            )

        }

    }
}