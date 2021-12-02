package com.example.quizapp

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.quizapp.databinding.ActivityQuizQuestionBinding

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var binding: ActivityQuizQuestionBinding
    private var mcurrentposition: Int = 1
    private var mquestionslist: ArrayList<Questions>? = null
    private var mselectedoptionposition: Int = 0
    private var mcorrectanswers: Int = 0
    private var musername: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityQuizQuestionBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        musername = intent.extras!!.getString(constant.user_name)

        mquestionslist = constant.getQuestions()

        setquestion()

        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)




    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_option_one -> {
                selectedoptionview(binding.tvOptionOne, 1)
            }
            R.id.tv_option_two -> {
                selectedoptionview(binding.tvOptionTwo, 2)
            }
            R.id.tv_option_three -> {
                selectedoptionview(binding.tvOptionThree, 3)
            }
            R.id.tv_option_four -> {
                selectedoptionview(binding.tvOptionFour, 4)
            }
            R.id.btn_submit -> {
                if (mselectedoptionposition == 0)
                {
                    mcurrentposition++

                    when {
                        mcurrentposition <= mquestionslist!!.size -> {
                            setquestion()
                        }
                        else -> {
                            val intent = Intent(this@QuizQuestionActivity, ResultActivity::class.java)
                            intent.putExtra(constant.user_name, musername)
                            intent.putExtra(constant.correct_answers, mcorrectanswers)
                            intent.putExtra(constant.total_questions, mquestionslist!!.size)
                            setResult(Activity.RESULT_OK, intent)
                            //startActivity(intent)
                            finish()
                            //resultLauncher.launch(intent)

                        }
                    }
                } else {
                    val question = mquestionslist?.get(mcurrentposition - 1)
                    if (question!!.correctanswer != mselectedoptionposition) {
                        answerview(mselectedoptionposition, R.drawable.wrong_option_border_bg)
                    } else {
                        mcorrectanswers++
                    }
                    answerview(question.correctanswer, R.drawable.correct_option_border_bg)

                    if (mcurrentposition == mquestionslist!!.size) {
                        binding.btnSubmit.text = "Finish"
                    } else {
                        binding.btnSubmit.text = "GO TO NEXT QUESTION"
                    }
                    mselectedoptionposition = 0

                }
            }
        }
    }


    private fun answerview(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                binding.tvOptionOne.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                binding.tvOptionTwo.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                binding.tvOptionThree.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                binding.tvOptionFour.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    private fun setquestion() {
        //mcurrentposition=1
        val question = mquestionslist!!.get(mcurrentposition - 1)

        defaultoptionsview()

        if (mcurrentposition == mquestionslist!!.size) {
            binding.btnSubmit.text = "FINISH"
        } else {
            binding.btnSubmit.text = "SUBMIT"
        }

        binding.progressBar.progress = mcurrentposition
        binding.tvProgress.text = "$mcurrentposition" + "/" + binding.progressBar.max

        binding.tvQuestions.text = question!!.question
        binding.ivImage.setImageResource(question.image)

        binding.tvOptionOne.text = question.optionone
        binding.tvOptionTwo.text = question.optiontwo
        binding.tvOptionThree.text = question.optionthree
        binding.tvOptionFour.text = question.optionfour
    }

    private fun selectedoptionview(tv: TextView, selectedoptionnum: Int) {
        defaultoptionsview()
        mselectedoptionposition = selectedoptionnum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )

    }

    private fun defaultoptionsview() {
        val options = ArrayList<TextView>()
        options.add(0, binding.tvOptionOne)
        options.add(1, binding.tvOptionTwo)
        options.add(2, binding.tvOptionThree)
        options.add(3, binding.tvOptionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

}
