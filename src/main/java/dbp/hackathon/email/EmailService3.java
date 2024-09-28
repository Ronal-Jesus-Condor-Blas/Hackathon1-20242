package dbp.hackathon.email;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Service
public class EmailService3 {

    @Autowired
    private JavaMailSender mailSender;

    // Método para enviar el correo
    public void sendSimpleMessage(String to, String subject, String htmlBody) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(htmlBody);
        mailSender.send(message);
    }

    // Método para leer el archivo HTML y reemplazar variables
    public String loadEmailTemplate(String nombre, String nombrePelicula, String fechaFuncion, int cantidadEntradas, double precioTotal, String qr) throws IOException {
        ClassPathResource resource = new ClassPathResource("/home/luisbarahona/Documents/CreatedByBarahona/Repositories_Code/DBP_Repository/Historial_Hackatones/Hackaton2/Hackathon1-20242/src/main/resources/templates/template.html");

        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        }

        // Reemplazar las variables dentro del HTML
        return contentBuilder.toString()
                .replace("{{nombre}}", nombre)
                .replace("{{nombrePelicula}}", nombrePelicula)
                .replace("{{fechaFuncion}}", fechaFuncion)
                .replace("{{cantidadEntradas}}", String.valueOf(cantidadEntradas))
                .replace("{{precioTotal}}", String.format("%.2f", precioTotal))
                .replace("{{qr}}", qr);
    }
}
