package di


import org.koin.dsl.module
import respository.ActivityRepository
import ui.activity.screen.ActivityViewModel

fun appModule() = module {
    single { ActivityRepository() }

    viewModelDefinition { ActivityViewModel(get())}
}
