package com.emmanuelarango.converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.emmanuelarango.coinschanger.databinding.ActivityConverterBinding

class ConverterActivity : AppCompatActivity() {

    private lateinit var converterBinding: ActivityConverterBinding
    private lateinit var converterViewModel: ConverterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        converterBinding = ActivityConverterBinding.inflate(layoutInflater)
        val view = converterBinding.root
        setContentView(view)

        converterViewModel = ViewModelProvider(this)[ConverterViewModel::class.java]

        val conversionCoinObserver = Observer<Double>{conversion ->
            converterBinding.textViewCoinChangedAmount.setText(conversion.toString())
        }

        val isErrorValidationObserver = Observer<Boolean> {
            Toast.makeText(
                applicationContext,
                "Debe introducir cantidades positivas",
                Toast.LENGTH_LONG
            ).show()

            converterBinding.amountEditText.setText("")
            converterBinding.textViewCoinChangedAmount.setText("")
            converterBinding.amountTextInputLayout.isErrorEnabled = false
        }

        converterViewModel.conversionCoin.observe(this, conversionCoinObserver)
        converterViewModel.isErrorValidation.observe(this, isErrorValidationObserver)





        converterBinding.buttonConvert.setOnClickListener {

            val ammountToConvert = converterBinding.amountEditText.text.toString().toDouble()


            converterViewModel.validations(ammountToConvert,
                converterBinding.radioButtonPesos.isChecked,
                converterBinding.radioButtonDolares.isChecked,
                converterBinding.radioButtonEuros.isChecked,
                converterBinding.radioButtonTopesos.isChecked,
                converterBinding.radioButtonToeuros.isChecked,
                converterBinding.radioButtonTodolares.isChecked
            )

        }

    }
}