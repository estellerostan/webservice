package org.mbds.tprest.webservice

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
                response.status = 201
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
