package webservice

import org.mbds.tprest.webservice.Bibliotheque
import org.mbds.tprest.webservice.Livre

class BootStrap {

    def init = { servletContext ->

        def laBiblio = new Bibliotheque(nom: "la bibliotheque", adresse: "l'adresse", anneeConstruction: 1998)
        def leLivre = new Livre(nom: "le livre", dateParution: new Date(), isbn: "978-3-16-148410-0", auteur: "l'auteur")
        laBiblio.addToLivres(leLivre)
        laBiblio.save(flush: true, failOnError: true)

        def l = new Livre(nom: "Les Miserables", dateParution: new Date(), isbn: "977-3-11-248410-0", auteur: "Victor Hugo")
        laBiblio.addToLivres(l)
        laBiblio.save(flush: true, failOnError: true)

        def b = new Bibliotheque(nom: "Learning Centre Sophia", adresse: "l'adresse", anneeConstruction: 2010)
        def l2 = new Livre(nom: "Deep Learning", dateParution: new Date(), isbn: "932-3-16-148410-2", auteur: "Ian Goodfellow and Yoshua Bengio and Aaron Courville")
        b.addToLivres(l2)
        b.save(flush: true, failOnError: true)
    }
    def destroy = {
    }
}
