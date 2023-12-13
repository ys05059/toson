package com.android.todayson.ui.home

import androidx.lifecycle.ViewModel
import com.android.todayson.VoiceToTextParser
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(
    private val voiceToTextParser: VoiceToTextParser
): ViewModel(){
    val voiceToTextParserState = voiceToTextParser.state

    fun startListening(){
        voiceToTextParser.startListening()
    }
    fun resetVoiceToTextParser(){
        voiceToTextParser.reset()
    }

    fun stopListening(){
        voiceToTextParser.stopListening()
    }

}