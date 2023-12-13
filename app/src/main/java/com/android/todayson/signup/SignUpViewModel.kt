package com.android.todayson.signup

import androidx.lifecycle.ViewModel
import com.android.todayson.VoiceToTextParser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

data class SignUpUiState(
    val name : String = "",
    val sex : String = "남자",
    val birth : Birth = Birth(2023, 12, 8),
    val alarm: Alarm = Alarm()
)

data class Birth(
    val year : Int,
    val month : Int,
    val day : Int
)

data class Alarm(
    val morning : Pair<Int,Int> = Pair(7,0),
    val noon : Pair<Int,Int> = Pair(14,0),
    val evening : Pair<Int,Int> = Pair(18,0),
)

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val voiceToTextParser: VoiceToTextParser
) : ViewModel(){
    val voiceToTextParserState = voiceToTextParser.state
    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState = _uiState.asStateFlow()
    fun startListening(){
        voiceToTextParser.startListening()
    }
    fun resetVoiceToTextParser(){
        voiceToTextParser.reset()
    }
    fun stopListening(){
        voiceToTextParser.stopListening()
    }

    fun updateName(name: String){
        _uiState.update {
            it.copy(name = name)
        }
    }

    fun updateSex(sex: String){
        _uiState.update {
            it.copy(sex = sex)
        }
    }

    fun updateBirth(birth: Birth){
        _uiState.update {
            it.copy(birth = birth)
        }
    }
    fun updateAlarm(alarm: Alarm){
        _uiState.update {
            it.copy(alarm = alarm)
        }
    }
}