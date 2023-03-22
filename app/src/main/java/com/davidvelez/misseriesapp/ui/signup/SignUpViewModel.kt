package com.davidvelez.misseriesapp.ui.signup

import android.app.DatePickerDialog
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class SignUpViewModel : ViewModel() {

    val calOut: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val infoOut: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val errorEmailOut: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val errorPasswordOut: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val errorEmptyNameOut: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val errorEmptyEmailOut: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val errorEmptyPasswordOut: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val errorEmptyRepPasswordOut: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val errorEmptyBirthDateOut: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val errorplaceOfBirthOut: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }


    fun registerUser(
        name: String,
        email: String,
        password: String,
        repPassword: String,
        maleRadioButton: Boolean,
        actionCheckBox: Boolean,
        adventureCheckBox: Boolean,
        comicCheckBox: Boolean,
        loveCheckBox: Boolean,
        suspenseCheckBox: Boolean,
        horrorCheckBox: Boolean,
        birthDate: String,
        placeOfBirth: String
    ) {

        val genre = if (maleRadioButton)
            "Masculino"
        else
            "Femenino"

        var favoritesGenre = ""
        if (actionCheckBox) favoritesGenre = "Acción"
        if (adventureCheckBox) favoritesGenre += " Aventura"
        if (comicCheckBox) favoritesGenre += " Humor"
        if (loveCheckBox) favoritesGenre += " Amor"
        if (suspenseCheckBox) favoritesGenre += " Suspenso"
        if (horrorCheckBox) favoritesGenre += " Terror"

        checkFields(
            name,
            email,
            password,
            repPassword,
            birthDate,
            placeOfBirth,
            genre,
            favoritesGenre
        )

    }

    private fun checkFields(
        name: String,
        email: String,
        password: String,
        repPassword: String,
        birthDate: String,
        placeOfBirth: String,
        genre: String,
        favoritesGenre: String
    ) {

        if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && repPassword.isNotEmpty() && birthDate.isNotEmpty() && placeOfBirth.isNotEmpty() && placeOfBirth != "Seleccionar") {
            if (password == repPassword && password.isNotEmpty()) {

                if (email.indexOf("@") != -1) {
                    infoOut.value =
                        "Nombre: $name\nEmail: $email\nPassword: $password\nGenre: $genre\nFavorites Genre: $favoritesGenre\nBirth Date: $birthDate\nPlace Of Birth: $placeOfBirth"
//                    signUpBinding.infoTextView.setText(info)

                } else {
                    errorEmailOut.value = "on"

                }

            } else {

                errorPasswordOut.value = "on"
            }
        } else {

            val arrayFields =
                arrayOf(name, email, password, repPassword, birthDate)

            if (arrayFields[0].isEmpty()) {
                errorEmptyNameOut.value = "on"


            }

            if (arrayFields[1].isEmpty()) {

                errorEmptyEmailOut.value = "on"

            }
            if (arrayFields[2].isEmpty()) {
                errorEmptyPasswordOut.value = "on"

            }
            if (arrayFields[3].isEmpty()) {
                errorEmptyRepPasswordOut.value = "on"

            }

            if (arrayFields[4].isEmpty()) {

                errorEmptyBirthDateOut.value = "on"

            }
            if (placeOfBirth == "Seleccionar" || placeOfBirth == "Select" || placeOfBirth =="Selezionare") {
                errorplaceOfBirthOut.value = "on"
            }

        }


    }

// fun spinnerDate(){
//     var fechaNacimiento: String = ""
//     var cal = Calendar.getInstance()
//
//     val calOut: MutableLiveData<Int> by lazy {
//         MutableLiveData<Int>()
//     }
//
//     val dateSetListener =
//         DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
//             cal.set(Calendar.YEAR, year)
//             cal.set(Calendar.MONTH, month)
//             cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
//
//             val format = "MM/dd/yyyy"
//             val sdf = SimpleDateFormat(format, Locale.US)
//             fechaNacimiento = sdf.format(cal.time).toString()
//             signUpBinding.fechaNacimientoEditText.setText(fechaNacimiento)
//         }
//
// }


}