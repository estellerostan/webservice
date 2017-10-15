package org.mbds.tprest.webservice

import grails.converters.JSON

class ApiController {

    def index() {
        render "ok"
    }

    def livre() {

        switch (request.getMethod()) {
            case "GET":
                response.status = 200
                break

            case "POST":
                def values = [nom: params.nom, dateParution: JSON.parse(params.dateParution), ISBN: params.ISBN, auteur: params.auteur]
                Livre livre = new Livre(values)

                if (livre.save(flush: true))
                    response.status = 201
                else
                    response.status = 400
                break

            case "PUT":
                response.status = 201
                break

            case "DELETE":
                response.status = 200
                break

            default:
                response.status = 405
                break
        }
    }
}
