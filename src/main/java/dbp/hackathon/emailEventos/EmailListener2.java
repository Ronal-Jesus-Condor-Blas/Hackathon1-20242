package dbp.hackathon.emailEventos;

/*
import dbp.hackathon.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public class EmailListener2 {

    @Autowired
    private EmailService emailService;

    @EventListener
    @Async
    public void handleHelloEmailEvent(HelloEmailEvent event) throws MessagingException {
        String htmlTemplate = """
                <!DOCTYPE html>
                <html>
                <head>
                  <title>¡Gracias por tu compra!</title>
                </head>
                <body>
                  <h1>¡Gracias por tu compra!</h1>
                  <p>¡Hola %s! Te informamos que tu compra ha sido exitosa. A continuación, te presentamos los detalles de tu compra:</p>
                  <ul>
                    <li>Nombre de la película: %s</li>
                    <li>Fecha de la función: %s</li>
                    <li>Cantidad de entradas: %d</li>
                    <li>Precio total: %.2f</li>
                    <li>Código QR: <img src="%s"></li>
                  </ul>
                  <p>¡No olvides llevar tu código QR impreso o en tu dispositivo móvil para poder ingresar a la función! ¡Te esperamos!</p>
                </body>
                </html>
                """;

        String htmlBody = String.format(
                htmlTemplate,
                event.getNombre(), // assuming you have these fields
                event.getNombrePelicula(),
                event.getFechaFuncion(),
                event.getCantidadEntradas(),
                event.getPrecioTotal(),
                event.getQr()
        );

        emailService.sendHtmlMessage(event.getEmail(), "Detalles de tu compra", htmlBody);
    }
}

 */