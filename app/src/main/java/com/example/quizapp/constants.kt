package com.example.quizapp

object constant
    {
        const val user_name:String="user_name"
        const val total_questions:String="total_questions"
        const val correct_answers:String="correct_answers"

        fun getQuestions(): ArrayList<Questions>
        {
            val questionsList=ArrayList<Questions>()

            val ques1 = Questions(1,
                "What country does this flag belong to?",
                R.drawable.ic_flag_of_argentina,
                "Argentina","Romania","Kigali","southafrica",
                1)
            questionsList.add(ques1)

            val ques2 = Questions(2,
                "What country does this flag belong to?",
                R.drawable.ic_flag_of_australia,
                "Brazil","Australia","Congo","southafrica",
                2)
            questionsList.add(ques2)

            val ques3 = Questions(3,
                "What country does this flag belong to?",
                R.drawable.ic_flag_of_belgium,
                "Morroco","Romania","Belgium","Nigeria",
                3)
            questionsList.add(ques3)

            val ques4 = Questions(4,
                "What country does this flag belong to?",
                R.drawable.ic_flag_of_brazil,
                "Brazil","Russia","USA","Ghana",
                1)
            questionsList.add(ques4)

            val ques5 = Questions(5,
                "What country does this flag belong to?",
                R.drawable.ic_flag_of_denmark,
                "Ukraine","Ivory coast","Bostwana","Denmark",
                4)
            questionsList.add(ques5)

            val ques6 = Questions(6,
                "What country does this flag belong to?",
                R.drawable.ic_flag_of_fiji,
                "Fiji","Turkey","Dubai","Togo",
                1)
            questionsList.add(ques6)

            val ques7 = Questions(7,
                "What country does this flag belong to?",
                R.drawable.ic_flag_of_germany,
                "Norway","Germany","China","South korea",
                2)
            questionsList.add(ques7)

            val ques8 = Questions(8,
                "What country does this flag belong to?",
                R.drawable.ic_flag_of_india,
                "Gambia","North korea","India","Japan",
                3)
            questionsList.add(ques8)

            val ques9 = Questions(9,
                "What country does this flag belong to?",
                R.drawable.ic_flag_of_kuwait,
                "Italy","Cech Republic","Dubai","Kuwait",
                4)
            questionsList.add(ques9)

            val ques10 = Questions(10,
                "What country does this flag belong to?",
                R.drawable.ic_flag_of_new_zealand,
                "Egypt","United Kingdom","New zealand","Zambia",
                3)
            questionsList.add(ques10)

            val ques11 = Questions(11,
                "What country does this flag belong to?",
                R.drawable.ic_flag_of_nigeria,
                "Nigeria","France","Isreal","Canada",
                1)
            questionsList.add(ques11)

            return questionsList
        }
    }