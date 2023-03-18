package com.davidvelez.misseriesapp.ui.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.davidvelez.misseriesapp.R
import com.davidvelez.misseriesapp.databinding.ActivityMainBinding
import com.davidvelez.misseriesapp.databinding.ActivitySignUpBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.math.sign

class SignUpActivity : AppCompatActivity() {
    private lateinit var signUpBinding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = signUpBinding.root
        setContentView(view)

        signUpBinding.registerButton.setOnClickListener {
//            Log.d("Saludo","hola")
//            Log.e("Saludo2","hola2")
//            Log.i("Saludo3","hola3")
            val name = signUpBinding.nameEditText.text.toString()
            val email = signUpBinding.emailEditText.text.toString()
            val password = signUpBinding.passwordEditText.text.toString()
            val repPassword = signUpBinding.repPasswordEditText.text.toString()
            val genre = if (signUpBinding.maleRadioButton.isChecked)
               "Masculino"
            else
                "Femenino"


            var favoritesGenre = ""
            if(signUpBinding.actionCheckBox.isChecked) favoritesGenre = "Acción"
            if(signUpBinding.adventureCheckBox.isChecked) favoritesGenre += " Aventura"
            if(signUpBinding.comicCheckBox.isChecked) favoritesGenre += " Humor"
            if(signUpBinding.loveCheckBox.isChecked) favoritesGenre += " Amor"
            if(signUpBinding.suspenseCheckBox.isChecked) favoritesGenre += " Suspenso"
            if(signUpBinding.horrorCheckBox.isChecked) favoritesGenre += " Terror"



            val info = "Nombre: $name\nEmail: $email\nPassword: $password\nGenre: $genre\nFavorites Genre: $favoritesGenre"

            if (password == repPassword)
                signUpBinding.infoTextView.setText(info.toString())
            else {
                Toast.makeText(
                    applicationContext,
                    "Las contraseñas no son iguales",
                    Toast.LENGTH_SHORT
                ).show()
                signUpBinding.repPasswordTextInputLayout.error = "Las contraseñas no son iguales"
                Snackbar.make(signUpBinding.linearLayout,"Las contraseñas no son iguales",Snackbar.LENGTH_INDEFINITE).
                setAction("Aceptar"){
                    signUpBinding.repPasswordEditText.setText("")
                    signUpBinding.repPasswordTextInputLayout.isErrorEnabled = false

                } .show()

            }


//            val numero1 = signUpBinding.nameEditText.text.toString().toInt()
//            val numero2 = signUpBinding.emailEditText.text.toString().toInt()
//            val suma = numero1 + numero2
//            signUpBinding.passwordEditText.setText(suma.toString())

        }

    }
}