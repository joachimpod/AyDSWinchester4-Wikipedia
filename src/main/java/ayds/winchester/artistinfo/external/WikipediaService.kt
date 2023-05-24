package ayds.winchester.artistinfo.external


interface WikipediaService {
    fun getArtist(artistName: String): WikipediaArtistInfo?
}