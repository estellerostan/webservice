package org.mbds.tprest.webservice

import grails.converters.JSON

class ApiController {

    def index() {
        render "ok"
    }

    def livre() {

        switch (request.getMethod()) {
            case "GET":

                // représentation de ma ressource par id
                if (params.id != null) {

                    Livre leLivre = ((Livre.findById( params.id) == null) ? null : Livre.findById(params.id))

                    if (leLivre == null)
                        response.status = 404
                    else {
                        response.status = 200
                        render leLivre as JSON
                    }
                } else { // représentation de ma collection
                    render Livre.findAll() as JSON
                }
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
