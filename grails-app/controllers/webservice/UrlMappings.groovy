package webservice

class UrlMappings {

    static mappings = {
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')

        // custom url mappings

        // représentation de la ressource livre par id
        get "/api/livre/$id(.$format)?"(controller: "api", action:"livre")
        get "/api/livre?"(controller: "api", action:"livre")

        // représentation de la collection de livres
        get "/api/livres/"(controller: "api", action:"livre")
        get "/api/livre/"(controller: "api", action:"livre")

//        post "/api/livre?"(controller: "api", action:"livre")

        get "/api/bibliotheque/$id(.$format)?"(controller: "api", action:"bibliotheque")
    }
}
