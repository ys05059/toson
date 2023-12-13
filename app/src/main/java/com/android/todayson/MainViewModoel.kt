package com.android.todayson

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val voiceToTextParser: VoiceToTextParser
):ViewModel(){

    fun setCanRecord(canRecord: Boolean){
        voiceToTextParser.setCanRecord(canRecord)
    }

}
