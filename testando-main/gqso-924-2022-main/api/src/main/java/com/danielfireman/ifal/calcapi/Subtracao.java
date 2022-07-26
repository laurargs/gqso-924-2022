package com.danielfireman.ifal.calcapi;

import io.jooby.annotations.GET;
import io.jooby.annotations.Path;
import io.jooby.annotations.PathParam;
import io.jooby.exception.BadRequestException;

@Path("/sub/{p1}/{p2}")
public class Subtracao {

    @GET
    public double calculaRaiz(@PathParam("p1") Double p1, @PathParam("p2") Double p2) {

        try {
            double sub = p1-p2;
            return sub;
        } catch (NumberFormatException nfe) {
            throw new BadRequestException("Parâmetro inválido: " +p1+p2);
        }
    }
    
}