package webservice

import org.mbds.tprest.webservice.Bibliotheque
import org.mbds.tprest.webservice.Livre

class BootStrap {

    def init = { servletContext ->

        def laBiblio = new Bibliotheque(nom: "la bibliotheque", adresse: "l'adresse", anneeConstruction: 1998)
        def leLivre = new Livre(nom: "le livre", dateParution: new Date(), ISBN: "978-3-16-148410-0", auteur: "l'auteur")
        laBiblio.addToLivres(leLivre)
        laBiblio.save(flush: true, failOnError: true)
    }
    def destroy = {
    }
}
