package br.com.jxr.cstv.presentation.ui.screens.matchList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import br.com.jxr.cstv.domain.model.Match
import br.com.jxr.cstv.domain.usecases.GetMatchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

@HiltViewModel
class MatchListViewModel @Inject constructor(
    getMatchesUseCase: GetMatchesUseCase
) : ViewModel() {

    val matches: Flow<PagingData<Match>> = getMatchesUseCase()
        .cachedIn(viewModelScope)
}
