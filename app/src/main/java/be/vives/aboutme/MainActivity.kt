package be.vives.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

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
        findViewById<Button>(R.id.nicknameButton).setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View)  {
        var nicknameButton = findViewById<Button>(R.id.nicknameButton)
        var nicknameTextView: TextView = findViewById<TextView>(R.id.nicknameTextView)
        var nicknameEditText: EditText = findViewById<EditText>(R.id.nicknameEditText)

    }




    }
