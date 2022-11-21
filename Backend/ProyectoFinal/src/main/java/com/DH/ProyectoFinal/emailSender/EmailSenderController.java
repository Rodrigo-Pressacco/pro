package com.DH.ProyectoFinal.emailSender;

import com.DH.ProyectoFinal.Dto.ReservaDto;
import com.DH.ProyectoFinal.exceptions.ResourceBadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/email")
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    @Autowired
    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/verificacion/{email}/{subject}/{body}")
    public ResponseEntity<?> guardar(@PathVariable String email,
                                    @PathVariable String subject,
                                    @PathVariable String body) throws ResourceBadRequestException {

        emailSenderService.sendSimpleMessage(email , subject.toString(), body.toString());
        //logger.debug("Operación exitosa de creado de reserva");
        return ResponseEntity.ok("todo ok");
    }
}
