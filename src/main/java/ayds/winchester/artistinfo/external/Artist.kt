package ayds.winchester.artistinfo.external

const val BASE_WIKI_URL = "https://en.wikipedia.org/?curid="

data class WikipediaArtistInfo (
    val artistName: String,
    val artistInfo: String,
    val wikipediaUrl: String,
)
