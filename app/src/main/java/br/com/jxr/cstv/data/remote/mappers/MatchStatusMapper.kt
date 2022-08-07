package br.com.jxr.cstv.data.remote.mappers

import br.com.jxr.cstv.data.remote.dto.MatchStatusDto
import br.com.jxr.cstv.domain.model.MatchStatus
import javax.inject.Inject

class MatchStatusMapper @Inject constructor() {
    fun map(matchStatusDto: MatchStatusDto) =
        when (matchStatusDto) {
            MatchStatusDto.CANCELLED -> MatchStatus.CANCELLED
            MatchStatusDto.FINISHED -> MatchStatus.FINISHED
            MatchStatusDto.RUNNING -> MatchStatus.RUNNING
            else -> MatchStatus.NOT_STARTED
        }
}
