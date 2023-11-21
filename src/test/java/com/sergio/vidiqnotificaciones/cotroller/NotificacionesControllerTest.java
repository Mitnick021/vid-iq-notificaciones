package com.sergio.vidiqnotificaciones.cotroller;

import com.sergio.vidiqnotificaciones.controller.NotificacionesController;
import com.sergio.vidiqnotificaciones.models.Notificacion;
import com.sergio.vidiqnotificaciones.services.NotificacionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class NotificacionesControllerTest {

    @Mock
    private NotificacionService notificacionService;

    @InjectMocks
    private NotificacionesController notificacionesController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCrearNotificacion() {
        Notificacion notificacion = new Notificacion();
        when(notificacionService.save(notificacion)).thenReturn(Mono.just(notificacion));

        notificacionesController.crearNotificacion(notificacion);

        verify(notificacionService).save(notificacion);
    }

    @Test
    public void testConsultarNotificacionesNombreVideo() {
        String nombreVideo = "test";
        when(notificacionService.findNotificacionesByNombreCanalContainsIgnoreCase(nombreVideo)).thenReturn(Flux.empty());

        notificacionesController.consultarNotificacionesNombreVideo(nombreVideo);

        verify(notificacionService).findNotificacionesByNombreCanalContainsIgnoreCase(nombreVideo);
    }

    @Test
    public void testConsultarNotificacionesNombreCanal() {
        String nombreCanal = "test";
        when(notificacionService.findNotificacionesByNombreVideoContainsIgnoreCase(nombreCanal)).thenReturn(Mono.empty());

        notificacionesController.consultarNotificacionesNombreCanal(nombreCanal);

        verify(notificacionService).findNotificacionesByNombreVideoContainsIgnoreCase(nombreCanal);
    }
}