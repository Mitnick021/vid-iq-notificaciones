package com.sergio.vidiqnotificaciones.cotroller;

import com.sergio.vidiqnotificaciones.controller.RecomendacionesController;
import com.sergio.vidiqnotificaciones.models.Recomendacion;
import com.sergio.vidiqnotificaciones.services.RecomendacionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecomendacionesControllerTest {

    @Mock
    private RecomendacionService recomendacionService;

    @InjectMocks
    private RecomendacionesController recomendacionesController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        Recomendacion recomendacion = new Recomendacion();
        when(recomendacionService.save(recomendacion)).thenReturn(Mono.just(recomendacion));

        recomendacionesController.save(recomendacion);

        verify(recomendacionService).save(recomendacion);
    }

    @Test
    public void testFindRecomendacionesByTemaCanalContainsIgnoreCase() {
        String tema = "test";
        when(recomendacionService.findRecomendacionesByTemaCanalContainsIgnoreCase(tema)).thenReturn(Flux.empty());

        recomendacionesController.findRecomendacionesByTemaCanalContainsIgnoreCase(tema);

        verify(recomendacionService).findRecomendacionesByTemaCanalContainsIgnoreCase(tema);
    }
}
