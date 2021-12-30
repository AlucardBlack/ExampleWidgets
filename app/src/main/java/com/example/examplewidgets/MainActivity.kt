package com.example.examplewidgets

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import android.widget.RadioGroup
import android.widget.RadioButton
import androidx.appcompat.widget.SwitchCompat
import com.google.android.material.switchmaterial.SwitchMaterial


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val helloText = findViewById<TextView>(R.id.textHello) as TextView

        helloText.setOnClickListener {
            Toast.makeText(this@MainActivity, "Kotlin Widgets", Toast.LENGTH_SHORT).show()
        }

        val editText = findViewById<EditText>(R.id.editTextDemo) as EditText
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val a: String = editText.text.toString()
                Toast.makeText(this@MainActivity, a, Toast.LENGTH_SHORT).show()
            }

        })

        val buttonListener = findViewById<Button>(R.id.button2) as Button
        buttonListener.setOnClickListener {
            Toast.makeText(this@MainActivity, "Using OnClick Listener", Toast.LENGTH_SHORT).show()
        }

        val radioButton = findViewById<RadioGroup>(R.id.radioGroup) as RadioGroup
        val background = findViewById<LinearLayout>(R.id.back) as LinearLayout

        radioButton.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.red -> {
                    background.setBackgroundColor(Color.parseColor("#FF0000"))
                }
                R.id.green -> {
                    background.setBackgroundColor(Color.parseColor("#00FF00"))
                }
                R.id.blue -> {
                    background.setBackgroundColor(Color.parseColor("#0000FF"))
                }
                //check how to actually make it default, not just white
                R.id.white -> {
                    background.setBackgroundColor(Color.parseColor("#FFFFFF"))
                }
            }

        }

        //CheckBox code
        val checkBoxButton = findViewById<Button>(R.id.buttonCB) as Button
        val checkBox1 = findViewById<CheckBox>(R.id.football) as CheckBox
        val checkBox2 = findViewById<CheckBox>(R.id.hockey) as CheckBox

        checkBoxButton.setOnClickListener {
            if (checkBox1.isChecked && checkBox2.isChecked) {
                Toast.makeText(this@MainActivity, "Football and Hockey", Toast.LENGTH_SHORT).show()
            } else if (checkBox1.isChecked) {
                Toast.makeText(this@MainActivity, "Football", Toast.LENGTH_SHORT).show()
            } else if (checkBox2.isChecked) {
                Toast.makeText(this@MainActivity, "Hockey", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "You didn't select anything", Toast.LENGTH_SHORT)
                    .show()
            }
        }
//Rating Bar
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar) as RatingBar
        val buttonRatingBar = findViewById<Button>(R.id.buttonRB) as Button

        buttonRatingBar.setOnClickListener {
            val ratingBarValue = ratingBar.rating
            Toast.makeText(this@MainActivity, "Rating is $ratingBarValue", Toast.LENGTH_SHORT)
                .show()
        }

        //Spinner
        val spinner = findViewById<Spinner>(R.id.spinner) as Spinner

        val teams = arrayOf(
            "Fiorentina",
            "Uventus",
            "Milan",
            "Inter",
            "Bologna",
            "Udinese",
            "Napoli",
            "Atalanta"
        )
        val arrayAdapter =
            ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_dropdown_item, teams)
        spinner.adapter = arrayAdapter
        //Switch
        val switchBtn = findViewById<SwitchMaterial>(R.id.switchbutton) as SwitchMaterial
        switchBtn.setOnClickListener {
            if (switchBtn.isChecked)
                Toast.makeText(this@MainActivity, "Switch ON", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this@MainActivity, "Switch OFF", Toast.LENGTH_SHORT).show()
        }

        //Progress Bar
        val progressBarHorizontal = findViewById<ProgressBar>(R.id.progressBar) as ProgressBar
        val btnStart = findViewById<Button>(R.id.buttonStart) as Button

        btnStart.setOnClickListener {
            var barStatus = 0
            Thread(Runnable {
                while (barStatus < 100) {
                    barStatus += 1
                    try {
                        Thread.sleep(20)
                        progressBarHorizontal.setProgress(barStatus)
                    } catch (exp: InterruptedException) {
                        exp.printStackTrace()
                    }
                }
            }).start()
        }
    }


    //end of MainActivity

    fun buttonFunction(v: View) {
        if (v.id == R.id.button1) {
            Toast.makeText(this@MainActivity, "Using OnClick attribute in XML", Toast.LENGTH_SHORT)
                .show()
        }
    }


}