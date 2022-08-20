package br.com.jxr.cstv.presentation.ui.screens.matchList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import br.com.jxr.cstv.domain.usecases.GetMatchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MatchListViewModel @Inject constructor(
    getMatchesUseCase: GetMatchesUseCase
) : ViewModel() {

    val matches = getMatchesUseCase().cachedIn(viewModelScope)
}
