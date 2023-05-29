package ayds.winchester.artistinfo.external.wikipedia

import ayds.winchester.artistinfo.external.WikipediaArtistInfo
import ayds.winchester.artistinfo.external.BASE_WIKI_URL
import ayds.winchester.artistinfo.external.DEFAULT_IMAGE
import com.google.gson.Gson
import com.google.gson.JsonObject


interface WikipediaToArtistResolver {
    fun getArtistFromExternalData(serviceData: String?, artistName: String): WikipediaArtistInfo?
}

private const val QUERY = "query"
private const val SEARCH = "search"
private const val SNIPPET = "snippet"
private const val PAGEID = "pageid"


class JsonToArtistResolver : WikipediaToArtistResolver {

    override fun getArtistFromExternalData(serviceData: String?, artistName: String): WikipediaArtistInfo? =
        try {
            serviceData?.getFirstItem()?.let { item ->
                WikipediaArtistInfo(
                    artistName,
                    item.getArtistInfo(),
                    "wikipedia",
                    DEFAULT_IMAGE,
                    BASE_WIKI_URL + item.getWikipediaUrl()
                )
            }
        } catch (e: Exception) {
            null
        }

        private fun String?.getFirstItem(): JsonObject {
            val jobj = Gson().fromJson(this, JsonObject::class.java)
            val query = jobj[QUERY].asJsonObject
            val items = query[SEARCH].asJsonArray
            return items[0].asJsonObject
        }

        private fun JsonObject.getArtistInfo() = this[SNIPPET].asString.replace("\\n", "\n")

        private fun JsonObject.getWikipediaUrl() = this[PAGEID]


}