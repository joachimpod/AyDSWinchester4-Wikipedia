package ayds.winchester.artistinfo.external

const val BASE_WIKI_URL = "https://en.wikipedia.org/?curid="
const val DEFAULT_IMAGE = "https://upload.wikimedia.org/wikipedia/commons/8/8c/Wikipedia-logo-v2-es.png"

data class WikipediaArtistInfo (
    val artistName: String,
    val artistInfo: String,
    val wikipediaUrl: String,
)
