package com.example.quizapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.quizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity()
{
    private lateinit var binding:ActivityResultBinding
    private lateinit var resultLauncher2:ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding= ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val intent = Intent()
        resultLauncher2.launch(intent)

        resultLauncher2 = registerForActivityResult(ActivityResultContracts.StartActivityForResult() ){ result ->
            if(result.resultCode == Activity.RESULT_OK)
            {
                val data: Intent? = result.data
                binding.tvName.text=data?.getStringExtra(constant.user_name)

                val totalquestion=data?.getIntExtra(constant.total_questions,0)
                val correctanswer=data?.getIntExtra(constant.correct_answers,0)

                binding.tvScore.text= "Your score is $correctanswer out of $totalquestion"


            }
        }*/

        val username = intent.extras!!.getString(constant.user_name)
        binding.tvName.text=username

        val totalquestions=intent.extras!!.getInt(constant.total_questions,0)
        val correctanswer=intent.extras!!.getInt(constant.correct_answers,0)

        binding.tvScore.text= "Your score is $correctanswer out of $totalquestions"
        binding.btnFinish.setOnClickListener {
            startActivity(Intent(this@ResultActivity, MainActivity::class.java))
        }

    }
}