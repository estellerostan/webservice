package org.mbds.tprest.webservice

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class LivreController {

    LivreService livreService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond livreService.list(params), model:[livreCount: livreService.count()]
    }

    def show(Long id) {
        respond livreService.get(id)
    }

    def save(Livre livre) {
        if (livre == null) {
            render status: NOT_FOUND
            return
        }

        try {
            livreService.save(livre)
        } catch (ValidationException e) {
            respond livre.errors, view:'create'
            return
        }

        respond livre, [status: CREATED, view:"show"]
    }

    def update(Livre livre) {
        if (livre == null) {
            render status: NOT_FOUND
            return
        }

        try {
            livreService.save(livre)
        } catch (ValidationException e) {
            respond livre.errors, view:'edit'
            return
        }

        respond livre, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        livreService.delete(id)

        render status: NO_CONTENT
    }
}
