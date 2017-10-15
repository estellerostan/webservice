package org.mbds.tprest.webservice

class ApiController {

    def index() {
        render "ok"
    }

    def livre() {

        switch (request.getMethod()) {
            case "POST":
                response.status = 201
                break;

            case "GET":
                response.status = 200;
                break;

            default:
                response.status = 405;
                break;
        }


    }
}
