package br.com.jxr.cstv.data

import br.com.jxr.cstv.data.model.Match
import io.mockk.coEvery
import io.mockk.mockk

val api = ApiBuilder.buildApi<PandaScoreApi>(baseUrl)
val mockApi = mockk<PandaScoreApi>().apply {
    coEvery {
        getMatches(
            page = any(),
            pageSize = any(),
            sort = any(),
            beginAt = any()
        )
    } returns matches
}
val matches = listOf(
    Match(id = 642049, name = "Grand Final: Daotsu Esports vs ODDIK", beginAt = "2022-08-02T22:09:47Z"),
    Match(id = 642736, name = "MK vs 5RATFORCESTAFF", beginAt = "2022-08-02T22:28:30Z"),
    Match(id = 638417, name = "TSM Academy vs Pittsburgh Knights Academy", beginAt = "2022-08-02T22:42:38Z"),
    Match(id = 644448, name = "Liberty vs REiGN", beginAt = "2022-08-02T23:26:00Z"),
    Match(id = 634897, name = "KBM.A vs RED.A", beginAt = "2022-08-02T23:51:44Z")
)
