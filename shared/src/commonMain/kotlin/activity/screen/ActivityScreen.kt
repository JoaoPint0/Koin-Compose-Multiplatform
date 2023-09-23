package activity.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.activity.screen.ActivityUiState
import ui.activity.screen.ActivityViewModel

@Composable
fun ActivityRoute(
    navigateToDetails: () -> Unit,
    viewModel: ActivityViewModel,
) {
    val state by viewModel.uiState.collectAsState()
    ActivityScreen(state, navigateToDetails, viewModel::updateCount)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivityScreen(
    state: ActivityUiState,
    navigateToDetails: () -> Unit,
    updateCount: () -> Unit,
) {

    Scaffold {

        Box(Modifier.fillMaxSize()) {
            Column(Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Text(
                    text= state.count.toString(),
                    style = MaterialTheme.typography.headlineLarge,
                )

                Button(onClick = updateCount) {
                    Text("Increment")
                }

                Button(onClick = navigateToDetails) {
                    Text("Next")
                }
            }
        }
    }
}

