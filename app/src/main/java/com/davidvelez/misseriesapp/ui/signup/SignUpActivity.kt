package com.davidvelez.misseriesapp.ui.signup

import android.app.DatePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import com.davidvelez.misseriesapp.databinding.ActivitySignUpBinding
import java.text.SimpleDateFormat
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


//        val dateSetListenerObserver =Observer<String> { dateSetListenerOut ->
//
//        }
//
//        signUpViewModel.dateSetListenerOut.observe(this, dateSetListenerObserver)
//
//        signUpBinding.fechaNacimientoEditText.setOnClickListener {
//            val calObserver = Observer<String> { calOut ->
//                DatePickerDialog(
//                    this, dateSetListener, calOut.get(Calendar.YEAR), calOut.get(Calendar.MONTH),
//                    calOut.get(Calendar.DAY_OF_MONTH)
//                ).show()
//            }
//            signUpViewModel.calOut.observe(this, calObserver)
//
//
//
//            costCalculatorViewModel.fixedCost.observe(this, fixedCostObserver)
//
//            signUpViewModel.spinnerDate()
//            val dateSetListener =
//                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
//                    cal.set(Calendar.YEAR, year)
//                    cal.set(Calendar.MONTH, month)
//                    cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
//
//                    val format = "MM/dd/yyyy"
//                    val sdf = SimpleDateFormat(format, Locale.US)
//                    fechaNacimiento = sdf.format(cal.time).toString()
//                    signUpBinding.fechaNacimientoEditText.setText(fechaNacimiento)
//                }
//            signUpBinding.fechaNacimientoEditText.setOnClickListener {
//                DatePickerDialog(
//                    this, dateSetListener, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
//                    cal.get(Calendar.DAY_OF_MONTH)
//                ).show()
//
//            }

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

//            val name = signUpBinding.nameEditText.text.toString()
//            val email = signUpBinding.emailEditText.text.toString()
//            val password = signUpBinding.passwordEditText.text.toString()
//            val repPassword = signUpBinding.repPasswordEditText.text.toString()
//            val genre = if (signUpBinding.maleRadioButton.isChecked)
//                "Masculino"
//            else
//                "Femenino"
//
//            var favoritesGenre = ""
//            if (signUpBinding.actionCheckBox.isChecked) favoritesGenre = "Acción"
//            if (signUpBinding.adventureCheckBox.isChecked) favoritesGenre += " Aventura"
//            if (signUpBinding.comicCheckBox.isChecked) favoritesGenre += " Humor"
//            if (signUpBinding.loveCheckBox.isChecked) favoritesGenre += " Amor"
//            if (signUpBinding.suspenseCheckBox.isChecked) favoritesGenre += " Suspenso"
//            if (signUpBinding.horrorCheckBox.isChecked) favoritesGenre += " Terror"
//
//            val birthDate = signUpBinding.fechaNacimientoEditText.text.toString()
//            val placeOfBirth = signUpBinding.spCiudad.selectedItem.toString()

//            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && repPassword.isNotEmpty() && birthDate.isNotEmpty() && placeOfBirth.isNotEmpty() && placeOfBirth != "Seleccionar") {
//                if (password == repPassword && password.isNotEmpty()) {
//
//                    if (email.indexOf("@") != -1) {
//                        val info =
//                            "Nombre: $name\nEmail: $email\nPassword: $password\nGenre: $genre\nFavorites Genre: $favoritesGenre\nBirth Date: $birthDate\nPlace Of Birth: $placeOfBirth"
//                        signUpBinding.infoTextView.setText(info.toString())
//
//                    } else {
//                        signUpBinding.emailEditText.error =
//                            "Error. El email debe contener @"
//                    }
//
//                } else {
//                    Toast.makeText(
//                        applicationContext,
//                        "Las contraseñas no son iguales",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    signUpBinding.repPasswordEditText.setText("")
//                }
//            } else {
//
//                val arrayFields =
//                    arrayOf(name, email, password, repPassword, birthDate)
//
//                if (arrayFields[0].isEmpty()) {
//                    signUpBinding.nameEditText.error =
//                        "Este campo es obligatorio"
//                }
//                if (arrayFields[1].isEmpty()) {
//                    signUpBinding.emailEditText.error =
//                        "Este campo es obligatorio"
//                }
//                if (arrayFields[2].isEmpty()) {
//                    signUpBinding.passwordEditText.error =
//                        "Este campo es obligatorio"
//                }
//                if (arrayFields[3].isEmpty()) {
//                    signUpBinding.repPasswordEditText.error =
//                        "Este campo es obligatorio"
//
//                }
//
//                if (arrayFields[4].isEmpty()) {
//                    Toast.makeText(
//                        applicationContext,
//                        "La fecha de nacimiento es obligatoria",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//                if (placeOfBirth == "Seleccionar") {
//
//                    Toast.makeText(
//                        applicationContext,
//                        "Por favor seleccionar el lugar de nacimiento",
//                        Toast.LENGTH_SHORT
//                    ).show()
//
//                }
//
//            }

        }

    }
}