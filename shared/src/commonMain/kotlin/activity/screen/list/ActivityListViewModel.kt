package activity.screen.list

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class ActivityListUiState(
    val list: List<Int> = emptyList(),
)

class ActivityListViewModel(
    //private val activityRepository: ActivityRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ActivityListUiState())
    val uiState = _uiState.asStateFlow()

    fun update() {
        _uiState.update { ActivityListUiState((0..1000).toList()) }
    }
}