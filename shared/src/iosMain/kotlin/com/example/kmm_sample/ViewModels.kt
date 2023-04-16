import com.example.feature.viewmodel.QiitaListViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

class ViewModels : KoinComponent {
    fun getQiitaListViewModel() = get<QiitaListViewModel>()
}