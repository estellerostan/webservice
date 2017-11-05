package org.mbds.tprest.webservice

import grails.converters.JSON
import grails.converters.XML

class ApiController {

    def index() {
        render "ok"
    }

    def livre() {

        switch (request.method) {
            case "GET":

                // représentation de ma ressource par id
                if (params.id != null) {

                    Livre leLivre = Livre.findById(params.id)

                    if (leLivre) {
                        switch (request.getHeader("Accept")) {
                            case "application/json":
                                render leLivre as JSON
                                break
                            case "application/xml":
                                render leLivre as XML
                                break
                            default:
                                render leLivre as JSON
                                break
                        }
                    } else {
                    response.status = 404
                    }
                } else { // représentation de ma collection
                    def livres = Livre.findAll()
                    if (livres){
                        switch (request.getHeader("Accept")) {
                            case "application/json":
                                render livres as JSON
                                break
                            case "application/xml":
                                render livres as XML
                                break
                            default:
                                render livres as JSON
                        }
                    }
                    else {
                        response.status = 404
                    }
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

    def bibliotheque() {
        switch (request.method) {
            case "GET":

                // représentation de ma ressource par id
                if (params.id != null) {

                    def bibliotheque = Bibliotheque.get(params.id)

                    if (bibliotheque) {
                        switch (request.getHeader("Accept")) {
                            case "application/json":
                                render bibliotheque as JSON
                                break
                            case "application/xml":
                                render bibliotheque as XML
                                break
                            default:
                                render bibliotheque as JSON
                                break
                        }
                    } else {
                        response.status = 404
                    }
                } else { // représentation de ma collection
                    def bibliotheques = Bibliotheque.findAll()
                    if (bibliotheques) {
                        switch (request.getHeader("Accept")) {
                            case "application/json":
                                render bibliotheques as JSON
                                break
                            case "application/xml":
                                render bibliotheques as XML
                                break
                        }
                    } else {
                        response.status = 404
                    }
                }
                break

            case "POST":
                def values = [nom: params.nom, adresse: params.adresse , anneeConstruction: params.anneeConstruction as Integer]
                def bibliotheque = new Bibliotheque(values)

                if (bibliotheque.save(flush: true))
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

    def bibliothequelivre() {
        switch (request.method) {
            case "GET":

                // représentation de ma ressource par id
                if (params.id != null) {
                    def livresbibliotheque = Bibliotheque.get(params.id).livres.asList()

                    if (livresbibliotheque) {
                        switch (request.getHeader("Accept")) {
                            case "application/json":
                                render livresbibliotheque as JSON
                                break
                            case "application/xml":
                                render livresbibliotheque as XML
                                break
                            default:
                                render livresbibliotheque as JSON
                                break
                        }
                    }
                }
        }
    }
}
