package webservice

class UrlMappings {

    static mappings = {
       "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')

        // représentation de la ressource livre par id
        get "/api/livre/$id(.$format)?"(controller: "api", action:"livre")
        get "/api/livre?"(controller: "api", action:"livre")

        // représentation de la collection de livres
        get "/api/livres/"(controller: "api", action:"livre")
        get "/api/livre/"(controller: "api", action:"livre")

        post "/api/livre/"(controller: "api", action:"livre")

        // bibliotheque
        get "/api/bibliotheque/$id(.$format)?"(controller: "api", action:"bibliotheque")
        get "/api/bibliotheque?"(controller: "api", action:"bibliotheque")

        get "/api/bibliotheques/"(controller: "api", action:"bibliotheque")
        get "/api/bibliotheque/"(controller: "api", action:"bibliotheque")
    }
}
