package com.example.quizapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import com.google.android.material.textfield.TextInputLayout
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
   private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_FULLSCREEN

       binding.btnStart.setOnClickListener {
            if (binding.etName.text.toString().isEmpty())
            {
                Toast.makeText(this,"please enter your name",Toast.LENGTH_SHORT).show()
            }
            else
            {
                val intent = Intent(this,QuizQuestionActivity::class.java)
                intent.putExtra(constant.user_name,binding.etName.text.toString())
                //setResult(Activity.RESULT_OK, intent)
                startActivity(intent)
                finish()
            }
        }


    }

    }
