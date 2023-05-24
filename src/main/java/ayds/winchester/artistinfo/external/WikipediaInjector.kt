package ayds.winchester.artistinfo.external

import ayds.winchester.artistinfo.external.wikipedia.JsonToArtistResolver
import ayds.winchester.artistinfo.external.wikipedia.WikipediaAPI
import ayds.winchester.artistinfo.external.wikipedia.WikipediaServiceImpl
import ayds.winchester.artistinfo.external.wikipedia.WikipediaToArtistResolver
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val BASE_URL = "https://en.wikipedia.org/w/"

object WikipediaInjector {

        private val wikipediaAPIRetrofit = Retrofit.Builder()
                                                   .baseUrl(BASE_URL)
                                                   .addConverterFactory(ScalarsConverterFactory.create())
                                                   .build()
        private val wikipediaAPI = wikipediaAPIRetrofit.create(WikipediaAPI::class.java)

        private val wikipediaToArtistResolver: WikipediaToArtistResolver = JsonToArtistResolver()

        private val wikipediaService: WikipediaService = WikipediaServiceImpl(
            wikipediaAPI,
            wikipediaToArtistResolver
        )

        fun getWikipediaService(): WikipediaService {
            return wikipediaService
        }
}