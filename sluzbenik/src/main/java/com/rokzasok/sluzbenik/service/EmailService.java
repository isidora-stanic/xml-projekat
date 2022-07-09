package com.rokzasok.sluzbenik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
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


    public void sendSledeciTerminEmail(String emailAddress, byte[] digitalniSertifikatPdf) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);


        helper.setFrom("podrska@euprava.rs");
        helper.setTo(emailAddress);
        helper.setSubject("Digitalni sertifikat");

        // todo: Na ovaj način se šalje PDF kao attachment, za digitalni sertifikat
        helper.addAttachment("Digitalni_sertifikat.txt", new ByteArrayResource(digitalniSertifikatPdf));

        helper.setText("Poštovani,\n\nU prilogu Vam šaljemo digitalni sertifikat, po Vašem zahtevu.\n\nVaša eUprava.", true);

        mailSender.send(message);
    }

    public void sendOdbijenZahtevZaSertifikat(String emailAddress, String razlog) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);


        helper.setFrom("podrska@euprava.rs");
        helper.setTo(emailAddress);
        helper.setSubject("Odbijen zahtev za digitalni sertifikat");

        helper.setText("Poštovani,\n\nVaš zahtev za digitalni sertifikat je odbijen." +
                "\n\nRazlog: " + razlog +
                "\n\nHvala na razumevanju, Vaša eUprava.", true);

        mailSender.send(message);
    }

}
