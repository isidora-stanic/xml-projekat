package com.rokzasok.portal.za.imunizaciju.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private final JavaMailSender mailSender;


    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    public void sendSledeciTerminEmail(String emailAddress, String termin, String ustanova) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);


        helper.setFrom("podrska@euprava.rs");
        helper.setTo(emailAddress);
        helper.setSubject("Naredni termin vakcinacije: " + termin);

        // todo: Na ovaj način se šalje PDF kao attachment, za digitalni sertifikat
//        helper.addAttachment("MyTestFile.txt", new ByteArrayResource("Ovo je neki kul pdf".getBytes()));

        helper.setText("Poštovani,\n\nVaš naredni termin za vakcinaciju je: " + termin + ".\nNa lokaciji: " + ustanova + ".\n\nVaša eUprava.");

        mailSender.send(message);
    }

    public void sendNemaSlobodnihTerminaEmail(String emailAddress, String termin, String ustanova) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);


        helper.setFrom("podrska@euprava.rs");
        helper.setTo(emailAddress);
        helper.setSubject("Neuspešno zakazivanje termina za termin: " + termin);

        helper.setText("Poštovani,\n\nZa željeni datum: " + termin + ".\nNa lokaciji: " + ustanova +
                ".\n\nNismo uspeli da pronađemo dostupan termin u narednih nedelju dana. " +
                "Molimo Vas, pokušajte ponovo.\n\nHvala na razumevanju, Vaša eUprava.");

        mailSender.send(message);
    }

    public void sendNemaDostupnihDozaEmail(String emailAddress, String tipVakcine) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);


        helper.setFrom("podrska@euprava.rs");
        helper.setTo(emailAddress);
        helper.setSubject("Neuspešno zakazivanje vakcinisanja vakcinom: " + tipVakcine);

        helper.setText("Poštovani,\n\nZa željeni tip vakcine: " + tipVakcine +
                ".\n\nNe postoji dovoljan broj dostupnih doza. " +
                "Molimo Vas, pokušajte ponovo.\n\nHvala na razumevanju, Vaša eUprava.");

        mailSender.send(message);
    }

}
