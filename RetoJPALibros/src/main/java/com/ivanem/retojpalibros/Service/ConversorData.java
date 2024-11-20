package com.ivanem.retojpalibros.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

public class ConversorData implements IConversorDatos {
    ObjectMapper mapeador = new ObjectMapper();
    @Override
    public <T> T obtenerDatos(String json,Class<T> clase ){
        try {
            return mapeador.readValue(json, clase);
        } catch (JsonProcessingException e) {
            System.out.println("No se pudo convertir el json a objeto Java.");
            return null;
        }
    }
}
