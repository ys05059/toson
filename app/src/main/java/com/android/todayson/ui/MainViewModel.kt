package com.android.todayson.ui

import androidx.lifecycle.ViewModel
import com.android.todayson.VoiceToTextParser
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
