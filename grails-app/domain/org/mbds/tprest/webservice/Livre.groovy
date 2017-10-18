package org.mbds.tprest.webservice

class Livre {

    String nom
    Date dateParution
    String isbn
    String auteur

    static belongsTo = [bibliotheque:Bibliotheque]

    static constraints = {
    }
}
