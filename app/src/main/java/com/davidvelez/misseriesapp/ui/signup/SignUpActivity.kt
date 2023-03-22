package com.davidvelez.misseriesapp.ui.signup

import android.app.DatePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.davidvelez.misseriesapp.databinding.ActivitySignUpBinding
import java.text.SimpleDateFormat
import java.util.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var signUpBinding: ActivitySignUpBinding
    private var fechaNacimiento: String = ""
    private var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = signUpBinding.root
        setContentView(view)

        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, month)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val format = "MM/dd/yyyy"
                val sdf = SimpleDateFormat(format, Locale.US)
                fechaNacimiento = sdf.format(cal.time).toString()
                signUpBinding.fechaNacimientoEditText.setText(fechaNacimiento)
            }
        signUpBinding.fechaNacimientoEditText.setOnClickListener {
            DatePickerDialog(
                this, dateSetListener, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()

        }

        signUpBinding.registerButton.setOnClickListener {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(signUpBinding.fechaNacimientoTextInputLayout.windowToken, 0)

            val name = signUpBinding.nameEditText.text.toString()
            val email = signUpBinding.emailEditText.text.toString()
            val password = signUpBinding.passwordEditText.text.toString()
            val repPassword = signUpBinding.repPasswordEditText.text.toString()
            val genre = if (signUpBinding.maleRadioButton.isChecked)
                "Masculino"
            else
                "Femenino"

            var favoritesGenre = ""
            if (signUpBinding.actionCheckBox.isChecked) favoritesGenre = "Acción"
            if (signUpBinding.adventureCheckBox.isChecked) favoritesGenre += " Aventura"
            if (signUpBinding.comicCheckBox.isChecked) favoritesGenre += " Humor"
            if (signUpBinding.loveCheckBox.isChecked) favoritesGenre += " Amor"
            if (signUpBinding.suspenseCheckBox.isChecked) favoritesGenre += " Suspenso"
            if (signUpBinding.horrorCheckBox.isChecked) favoritesGenre += " Terror"

            val birthDate = signUpBinding.fechaNacimientoEditText.text.toString()
            val placeOfBirth = signUpBinding.spCiudad.selectedItem.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && repPassword.isNotEmpty() && birthDate.isNotEmpty() && placeOfBirth.isNotEmpty() &&placeOfBirth != "Seleccionar") {
                if (password == repPassword && password.isNotEmpty()) {

                    if (email.indexOf("@") != -1) {
                        val info =
                            "Nombre: $name\nEmail: $email\nPassword: $password\nGenre: $genre\nFavorites Genre: $favoritesGenre\nBirth Date: $birthDate\nPlace Of Birth: $placeOfBirth"
                        signUpBinding.infoTextView.setText(info.toString())

                    } else {
                        signUpBinding.emailEditText.error =
                            "Error. El email debe contener @"
                    }

                } else {
                    Toast.makeText(
                        applicationContext,
                        "Las contraseñas no son iguales",
                        Toast.LENGTH_SHORT
                    ).show()
                    signUpBinding.repPasswordEditText.setText("")
                }
            } else {

                val arrayFields =
                    arrayOf(name, email, password, repPassword, birthDate)

                if (arrayFields[0].isEmpty()) {
                    signUpBinding.nameEditText.error =
                        "Este campo es obligatorio"
                }
                if (arrayFields[1].isEmpty()) {
                    signUpBinding.emailEditText.error =
                        "Este campo es obligatorio"
                }
                if (arrayFields[2].isEmpty()) {
                    signUpBinding.passwordEditText.error =
                        "Este campo es obligatorio"
                }
                if (arrayFields[3].isEmpty()) {
                    signUpBinding.repPasswordEditText.error =
                        "Este campo es obligatorio"

                }

                if (arrayFields[4].isEmpty()) {
                    Toast.makeText(
                        applicationContext,
                        "La fecha de nacimiento es obligatoria",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                if (placeOfBirth == "Seleccionar") {

                    Toast.makeText(
                        applicationContext,
                        "Por favor seleccionar el lugar de nacimiento",
                        Toast.LENGTH_SHORT
                    ).show()

                }

            }

        }

    }
}