# AyDSWinchester4-Wikipedia

# Winchester4-Submodule
Acude a la utilización de API de Wikipedia, para recuperar descripción de un artista.<br>
 Al pasarle un artista, en caso de encontrar al mismo, devuelve una data class WikipediaArtistInfo, que cuenta con la información del nombre del artista, su descripción y el link al correspondiente artículo de Wikipedia. Si no lo encontró, retorna nulo.<br>
 
# Uso

 Para utilizar el mismo, se puede agregar el submodulo mediante el repositorio ubicado en:<br>
https://github.com/joachimpod/AyDSWinchester4-Wikipedia<br>
Podemos declarar a WikipediaService, y llamar con getArtist pasándole el nombre del artista, utilizando el injector, de la siguiente forma:<br>
   
val wikipediaService = WikipediaInjector.getWikipediaService()<br>
val artistName = "Nombre del artista" //Puedes llamar a lo que necesites aqui<br>
val WikipediaArtistInfo = wikipediaService.getArtist(artistName)<br>

 Una vez obtenida "WikipediaArtistInfo", podemos acceder al nombre del artista, a la descripcion, al logo y al link de la siguiente manera: <br>
 
 ## URL <br>
 val articleUrl = WikipediaArtistInfo.wikipediaUrl <br>
 ## Descripcion <br>
 val description = WikipediaArtistInfo.artistInfo
 ## Nombre <br>
 val artistName = WikipediaArtistInfo.artistName <br>
 ## Logo <br>
 val wikipedialogo = WikipediaArtistInfo.logoUrl

