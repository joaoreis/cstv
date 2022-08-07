package br.com.jxr.cstv.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import br.com.jxr.cstv.data.MatchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MatchRepository
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
