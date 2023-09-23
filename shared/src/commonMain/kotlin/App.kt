
import activity.screen.ActivityRoute
import activity.screen.details.ActivityDetailsRoute
import activity.screen.details.ActivityDetailsViewModel
import activity.screen.list.ActivityListRoute
import activity.screen.list.ActivityListViewModel
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import di.appModule
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf
import ui.activity.screen.ActivityViewModel

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
    val stack = mutableMapOf<String, ViewModel>()

    NavHost(
        navigator = navigator,
        initialRoute = "/home"
    ) {

        scene(route = "/home") {
            val viewModel = stack["/home"] as ActivityViewModel? ?: koinInject()
            stack["/home"] = viewModel
            ActivityRoute({
                navigator.navigate("/list")
            }, viewModel)
        }

        scene(route = "/list") {
            val viewModel = stack["/list"] as ActivityListViewModel? ?: koinInject()
            stack["/list"] = viewModel
            ActivityListRoute({
                navigator.navigate("/details/${it}")
            }, viewModel)
        }

        scene(route = "/details/{name}") { backStackEntry ->
            backStackEntry.path<String>("name")?.let { name ->
                val viewModel = stack["/details/{name}"] as ActivityDetailsViewModel? ?: koinInject(parameters = { parametersOf(name) })
                stack["/details/{name}"] = viewModel
                ActivityDetailsRoute(viewModel)
            }
        }
    }
}

expect fun getPlatformName(): String