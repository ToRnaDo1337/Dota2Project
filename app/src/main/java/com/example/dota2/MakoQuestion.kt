package com.example.dota2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.dota2.databinding.FragmentMakoQuestionBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MakoQuestion.newInstance] factory method to
 * create an instance of this fragment.
 */
class MakoQuestion :Fragment() {
    data class Question(
        val text: String,
        val answers: List<String>)

    private val questions: MutableList<Question> = mutableListOf(
        Question(text = "With what combination is the Ice Wall caused by Invoker?",
            answers = listOf("QQE", "QWE", "WWE", "WWQ")),
        Question(text = "Which hero owns the ability \"Dispersion\"?",
            answers = listOf("Spectre", "Faceless Void", "Huskar", "Phantom Lancer")),
        Question(text = "Hero, who is the god of war?",
            answers = listOf("Mars", "Clinkz", "Razor", "Zeus")),
        Question(text = "Lina's sister",
            answers = listOf("Crystal Maiden", "Templar Assassin", "Death Prophet", "Drow Ranger")),
        Question(text = "Last added hero",
            answers = listOf("Primal Beast", "Marci", "Techies", "Mars")),
        Question(text = "Hero of the category \"Intelligence\"",
            answers = listOf("Ogre Magi", "Alchemist", "Anti-mage", "Gyrocopter")),
        Question(text = "The most popular hero in Dota 2?",
            answers = listOf("Pudge", "Shadow Fiend", "Lion", "Huskar")),
        Question(text = "Dawn Breakers real name",
            answers = listOf("Valora", "Rylai", "Azshara", "Tyrande")),
        Question(text = "Aunt of Timbersaw",
            answers = listOf("Snapfire", "Marci", "Luna", "Mirana")),
        Question(text = "Icon of ZXC culture",
            answers = listOf("Shadow Fiend", "Spirit Breaker", "Techies", "Puck"))
    )



    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = Math.min((questions.size + 1) / 2, 3)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentMakoQuestionBinding>(
            inflater, R.layout.fragment_mako_question, container, false)


        randomizeQuestions()


        binding.game = this

        binding.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId

            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.secondAnswerRadioButton -> answerIndex = 1
                    R.id.thirdAnswerRadioButton -> answerIndex = 2
                    R.id.fourthAnswerRadioButton -> answerIndex = 3
                }

                if (answers[answerIndex] == currentQuestion.answers[0]) {
                    questionIndex++

                    if (questionIndex < numQuestions) {
                        currentQuestion = questions[questionIndex]
                        setQuestion()
                        binding.invalidateAll()
                    } else {
                        view.findNavController()
                            .navigate(MakoQuestionDirections
                                .actionMakoQuestionToGameWonFragment(numQuestions, questionIndex))

                    }
                } else {
                    view.findNavController()
                        .navigate(MakoQuestionDirections.actionMakoQuestionToGameOverFragment())
                }
            }
        }
        return binding.root
    }

    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // and shuffle them
        answers.shuffle()
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_dota2_question, questionIndex + 1, numQuestions)
    }
}