package be.vives.aboutme

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import be.vives.aboutme.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        //aanmaken van nieuwe binding - we willen deze klasse binden aan de activity_main

        super.onStart()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

        binding.nicknameButton.setOnClickListener(){
            addNickname(it)
        }
    }

    private fun addNickname(view: View)  {

        var nicknameTextView: TextView = binding.nicknameTextView
        var nicknameEditText: EditText = binding.nicknameEditText

        if (binding.nicknameEditText.text.isNotBlank()) {

            binding.apply {
                myName?.nickname = nicknameEditText.text.toString()
                //nicknameTextView.text = nicknameEditText.text
                nicknameEditText.visibility = View.GONE
                nicknameButton.visibility = View.GONE
                nicknameTextView.visibility = View.VISIBLE
            }

            /*
            binding.nicknameTextView.text = binding.nicknameEditText.text
            binding.nicknameEditText.visibility = View.GONE
            binding.view.visibility = View.GONE
            binding.nicknameTextView.visibility = View.VISIBLE
             */

            val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

        } else  {
            Toast.makeText(this,"Nickname moet ingevuld worden.", Toast.LENGTH_LONG).show()
        }



    }




}
