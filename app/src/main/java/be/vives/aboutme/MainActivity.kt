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
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {



    private lateinit var nicknameButton: Button;
    private lateinit var nicknameTextView: TextView;
    private lateinit var nicknameEditText: EditText;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        findViewById<Button>(R.id.nicknameButton).setOnClickListener{
            addNickname(it)
        }
    }

    private fun addNickname(view: View)  {

        var nicknameTextView: TextView = findViewById<TextView>(R.id.nicknameTextView)
        var nicknameEditText: EditText = findViewById<EditText>(R.id.nicknameEditText)

        if (nicknameEditText.text.isNotBlank()) {

            nicknameTextView.text = nicknameEditText.text

            nicknameEditText.visibility = View.GONE

            view.visibility = View.GONE

            nicknameTextView.visibility = View.VISIBLE

            val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)


        } else  {
            Toast.makeText(this,"Nickname moet ingevuld worden.", Toast.LENGTH_LONG).show()
        }



    }




}
