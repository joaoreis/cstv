package br.com.jxr.cstv.data.remote.mappers

import br.com.jxr.cstv.data.remote.dto.SerieDto
import br.com.jxr.cstv.domain.model.Serie

class SerieMapper {
    fun map(serieDto: SerieDto) = Serie(serieDto.fullName)
}
