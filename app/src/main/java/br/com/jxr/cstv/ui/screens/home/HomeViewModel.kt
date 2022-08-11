package br.com.jxr.cstv.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import br.com.jxr.cstv.domain.usecases.GetMatchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getMatchesUseCase: GetMatchesUseCase
) : ViewModel() {

    val getMatches = getMatchesUseCase().cachedIn(viewModelScope)
}
