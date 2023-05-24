package ayds.winchester.artistinfo.external.wikipedia


import ayds.winchester.artistinfo.external.WikipediaArtistInfo
import ayds.winchester.artistinfo.external.WikipediaService
import retrofit2.Response

class WikipediaServiceImpl(
    private val wikipediaAPI: WikipediaAPI,
    private val wikipediaToArtistResolver: WikipediaToArtistResolver,
) : WikipediaService {

    override fun getArtist(artistName: String): WikipediaArtistInfo? {
        val callResponse = getArtistFromService(artistName)
        return wikipediaToArtistResolver.getArtistFromExternalData(callResponse.body(),artistName)
    }

    private fun getArtistFromService(artistName: String): Response<String> {
        return wikipediaAPI.getArtistInfo(artistName).execute()
    }
}