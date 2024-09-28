package dbp.hackathon.email;

import dbp.hackathon.email.EmailService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/tickets")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviarCorreo")
    public String enviarCorreo(
            @RequestParam String email,
            @RequestParam String nombre,
            @RequestParam String nombrePelicula,
            @RequestParam String fechaFuncion,
            @RequestParam int cantidadEntradas,
            @RequestParam double precioTotal,
            @RequestParam String qr) throws IOException {

        // Cargar la plantilla HTML y reemplazar las variables
        String htmlBody = emailService.loadEmailTemplate(nombre, nombrePelicula, fechaFuncion, cantidadEntradas, precioTotal, qr);

        // Enviar el correo
        emailService.sendSimpleMessage(email, "Confirmación de Compra", htmlBody);

        return "Correo enviado exitosamente a " + email;
    }
}
