
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import di.appModule
import org.koin.compose.KoinApplication
import activity.screen.ActivityRoute

@Composable
fun App() {
    KoinApplication(application = {
        modules(appModule())
    }) {
        MaterialTheme {
            ActivityRoute()
        }
    }
}

expect fun getPlatformName(): String