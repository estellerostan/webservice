package org.mbds.tprest.webservice

class Bibliotheque {

    String nom
    String adresse
    int anneeConstruction

    static hasMany = [livres:Livre]

    static constraints = {
    }
}
