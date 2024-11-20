package com.ivanem.retojpalibros.Service;

import java.util.List;

public interface IConversorDatos {
    <T> T obtenerDatos(String json,Class<T> clase);
}
