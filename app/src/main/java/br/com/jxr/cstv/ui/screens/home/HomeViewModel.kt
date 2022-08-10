package br.com.jxr.cstv.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import br.com.jxr.cstv.data.remote.repository.MatchRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: MatchRepositoryImpl
) : ViewModel() {

    val getMatches = repository.getMatches().cachedIn(viewModelScope)
}
