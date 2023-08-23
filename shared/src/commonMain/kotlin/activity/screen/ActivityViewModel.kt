package ui.activity.screen

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import respository.ActivityRepository

data class ActivityUiState(
    val count: Int = 0,
)

class ActivityViewModel(
    private val activityRepository: ActivityRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ActivityUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val count = activityRepository.getCount()
            _uiState.update { ActivityUiState(count) }
        }
    }

    fun updateCount() {

        _uiState.update { it.copy(it.count + 1) }

        viewModelScope.launch {
            activityRepository.increaseCount()
        }
    }
}