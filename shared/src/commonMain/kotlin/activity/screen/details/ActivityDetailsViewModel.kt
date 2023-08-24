package activity.screen.details

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import respository.ActivityRepository

data class ActivityDetailsUiState(
    val count: Int = 0,
)

class ActivityDetailsViewModel(
    private val value: String,
    private val activityRepository: ActivityRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ActivityDetailsUiState())
    val uiState = _uiState.asStateFlow()

    init {
        _uiState.update { ActivityDetailsUiState(value.toIntOrNull() ?: 0) }
    }
}