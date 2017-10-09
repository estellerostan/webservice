package org.mbds.tprest.webservice

class Livre {

    String nom
    Date dateParution
    String ISBN
    String auteur
    Bibliotheque bibliotheque

    static embedded = ['bibliotheque']

    static constraints = {
    }
}
