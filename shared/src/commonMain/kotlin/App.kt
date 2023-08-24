
import activity.screen.ActivityRoute
import activity.screen.details.ActivityDetailsRoute
import activity.screen.list.ActivityListRoute
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import di.appModule
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import org.koin.compose.KoinApplication

@Composable
fun App() {
    KoinApplication(application = {
        modules(appModule())
    }) {
        MaterialTheme {
            NavigationHost()
        }
    }
}
@Composable
fun NavigationHost(){
    val navigator = rememberNavigator()

    NavHost(
        navigator = navigator,
        initialRoute = "/home"
    ) {
        scene(route = "/home") {
            ActivityRoute({
                navigator.navigate("/list")
            })
        }

        scene(route = "/list") { backStackEntry ->
            ActivityListRoute({
                navigator.navigate("/details/${it}")
            })
        }

        scene(route = "/details/{name}") { backStackEntry ->
            backStackEntry.path<String>("name")?.let { name ->
                ActivityDetailsRoute(name)
            }
        }
    }
}

expect fun getPlatformName(): String