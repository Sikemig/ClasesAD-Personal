package com.example.LigasAPI.service;

import com.example.LigasAPI.model.Liga;

public interface LigaService {
    // escribo todos los metodos que quiero llamar desde el controller. Solo se escribe la firma.
    // Aportan la lógica del negocio

    // ej: Liga updateLigaFecha(LocalDate localdate)

    Liga agregarLiga(Liga liga);
}
