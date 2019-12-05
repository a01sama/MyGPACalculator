package com.example.mygpacalculator

//Import statements
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.view.View
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.floor

//Class with everything in it
class MainActivity : AppCompatActivity() {

    //creating and setting the spinners to base 0
    val credits = arrayOf(0, 0,0, 0,0, 0)
    val grades = DoubleArray(6) { 0.0 }
    lateinit var option1 : Spinner
    lateinit var option2 : Spinner
    lateinit var option3 : Spinner
    lateinit var option4 : Spinner
    lateinit var option5 : Spinner
    lateinit var option6 : Spinner
    lateinit var result : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Making spinners
        option1 = findViewById(R.id.spinner)
        option2 = findViewById(R.id.spinner2)
        option3 = findViewById(R.id.spinner3)
        option4 = findViewById(R.id.spinner4)
        option5 = findViewById(R.id.spinner5)
        option6 = findViewById(R.id.spinner6)

        result = findViewById(R.id.textView3)

        //Giving the spinners values
        val options = arrayOf(" ", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-","F")
        option1.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        option2.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        option3.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        option4.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        option5.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        option6.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)

        //optimizing the spinners and inputs
        option1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long) {
                getgpa(options[position], 0)
            }
        }
        option2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long) {
                getgpa(options.get(position), 1)
            }
        }
        option3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long) {
                getgpa(options.get(position), 2)
            }
        }
        option4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long) {
                getgpa(options.get(position), 3)
            }
        }
        option5.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long) {
                getgpa(options.get(position), 4)
            }
        }
        option6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long) {
                getgpa(options.get(position), 5)
            }
        }

        //Optimizing the credits box and taking input
        editText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                var v = s.toString()
                credits[0] = v.toInt()
            }
        })

        editText2.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                var v = s.toString()
                credits[1] = v.toInt()
            }
        })

        editText3.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                var v = s.toString()
                credits[2] = v.toInt()
            }
        })

        editText4.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                var v = s.toString()
                credits[3] = v.toInt()
            }
        })

        editText5.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                var v = s.toString()
                credits[4] = v.toInt()
            }
        })

        editText6.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                var v = s.toString()
                credits[5] = v.toInt()
            }
        })

        //Calculating the GPA
        val btn_click_me = findViewById(R.id.button) as Button
        btn_click_me.setOnClickListener {
            var finalgpa = 0.0
            var totalCredits = 0

            for(i in 0..5) {
                finalgpa += (grades[i] * credits[i])
                totalCredits += credits[i]
            }
            finalgpa /= totalCredits
            finalgpa = floor(finalgpa*100)/100
            result.text = "Final GPA: " + finalgpa
        }

    }

    //Setting the grades to values
    fun getgpa(str: String, int: Int)
    {
        when (str) {
            " " -> grades[int] = 0.0
            "A" -> grades[int] = 4.0
            "A-" -> grades[int] = 3.7
            "B+" -> grades[int] = 3.3
            "B" -> grades[int] = 3.0
            "B-" -> grades[int] = 2.7
            "C+" -> grades[int] = 2.3
            "C" -> grades[int] = 2.0
            "C-" -> grades[int] = 1.7
            "D+" -> grades[int] = 1.3
            "D" -> grades[int] = 1.0
            "D-" -> grades[int] = 0.7
            "F" -> grades[int] = 0.0
        }
    }
}
