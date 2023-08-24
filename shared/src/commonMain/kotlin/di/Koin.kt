package di


import activity.screen.details.ActivityDetailsViewModel
import activity.screen.list.ActivityListViewModel
import org.koin.dsl.module
import respository.ActivityRepository
import ui.activity.screen.ActivityViewModel

fun appModule() = module {
    single { ActivityRepository() }

    viewModelDefinition { ActivityViewModel(get())}
    viewModelDefinition { ActivityListViewModel(get())}
    viewModelDefinition { ActivityDetailsViewModel(get(), get()) }
}
