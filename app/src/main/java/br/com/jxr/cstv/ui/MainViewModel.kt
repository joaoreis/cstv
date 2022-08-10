package br.com.jxr.cstv.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import br.com.jxr.cstv.data.remote.repository.MatchRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    repository: MatchRepositoryImpl
) : ViewModel() {

    val getMatches = repository.getMatches().cachedIn(viewModelScope)

//    private val _matches = MutableStateFlow<PagingData<Match>>(PagingData.empty())
//    val matches get() = _matches
//
//    suspend fun getMatches() {
//        viewModelScope.launch {
//            repository.getMatches().cachedIn(viewModelScope).collect {
//                _matches.value = it
//            }
//        }
//    }
}
