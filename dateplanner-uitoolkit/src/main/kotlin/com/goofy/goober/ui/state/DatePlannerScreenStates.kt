package com.goofy.goober.ui.state

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.goofy.goober.model.Question
import com.goofy.goober.ui.fragment.EndFragment
import com.goofy.goober.ui.fragment.QuestionFragment
import com.goofy.goober.ui.fragment.WelcomeFragment
import com.goofy.goober.ui.view.QuestionView
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@OptIn(ExperimentalCoroutinesApi::class)
class DatePlannerScreenStates : DatePlannerChildFragmentStates {

   private val initialWelcomeState = WelcomeFragment.State(
       welcomeVisibility = View.GONE,
       progressVisibility = View.VISIBLE,
       onStartClick = { }
   )
    private val initialQuestionState = QuestionView.State(
        question = Question.firstQuestion,
        clickListener = {}
    )
    private val initialEndState = EndFragment.State("")

    private val welcomeState = MutableStateFlow<WelcomeFragment.State>(initialWelcomeState)
    private val questionState = MutableStateFlow<QuestionView.State>(initialQuestionState)
    private val endState = MutableStateFlow<EndFragment.State>(initialEndState)

    fun updateWelcomeState(newState: WelcomeFragment.State) {
        welcomeState.value = newState
    }

    fun updateQuestionState(newState: QuestionView.State) {
        questionState.value = newState
    }

    fun updateEndState(newState: EndFragment.State) {
        endState.value = newState
    }

    override fun welcomeState(): StateFlow<WelcomeFragment.State> = welcomeState
    override fun questionState(): StateFlow<QuestionView.State> = questionState
    override fun endState(): StateFlow<EndFragment.State> = endState
}

interface DatePlannerChildFragmentStates :
    WelcomeFragment.FragmentState,
    EndFragment.FragmentState,
    QuestionFragment.FragmentState
