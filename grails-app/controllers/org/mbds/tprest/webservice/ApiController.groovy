package org.mbds.tprest.webservice

import grails.converters.JSON
import groovy.json.JsonOutput
import groovy.json.StreamingJsonBuilder

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
                        StringWriter writer = new StringWriter()
                        StreamingJsonBuilder builder = new StreamingJsonBuilder(writer)
                        builder.livre {
                            nom leLivre.nom
                            dateparution leLivre.dateParution
                            isbn leLivre.ISBN
                            auteur leLivre.auteur
                        }
                        String json = JsonOutput.prettyPrint(writer.toString())

                        response.status = 200
                        response.outputStream << json
                    }
                } else { // représentation de ma collection
                    response.status = 404
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
