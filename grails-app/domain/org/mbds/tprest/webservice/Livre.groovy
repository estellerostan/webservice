package org.mbds.tprest.webservice

class Livre {

    String nom
    Date dateParution
    String ISBN
    String auteur

    static belongsTo = Bibliotheque

    static constraints = {
    }
}
