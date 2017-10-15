package org.mbds.tprest.webservice


class ApiController {

    def index() {
        render "ok"
    }

    def livre() {
        response.status = 200
    }
}
