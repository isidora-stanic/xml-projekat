package com.rokzasok.portal.za.imunizaciju.service;

import com.rokzasok.portal.za.imunizaciju.model.dokumenti.gradjanin.iskazivanje_interesovanja.ObrazacInteresovanja;
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


    public void uspesnoPoslatoInteresovanjeEmail(String emailAddress, ObrazacInteresovanja interesovanje) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);


        helper.setFrom("podrska@euprava.rs");
        helper.setTo(emailAddress);
        helper.setSubject("Interesovanje za imunizaciju");

        // todo: Na ovaj način se šalje PDF kao attachment, za digitalni sertifikat
//        helper.addAttachment("MyTestFile.txt", new ByteArrayResource("Ovo je neki kul pdf".getBytes()));

        String davalacKrvi = "Ne";
        if (interesovanje.getOpstiPodaci().getDavalacKrvi().isValue())
            davalacKrvi = "Da";

        helper.setText("Poštovani,<br/><br/>Uspesno ste iskazali interesovanje za imunizaciju:<br/>" +
                "Državljanstvo: " + interesovanje.getPodaciOOsobi().getDrzavljanstvo().getValue().value() +
                "<br/>JMBG: " + interesovanje.getPodaciOOsobi().getJMBG() +
                "<br/>Ime: " + interesovanje.getPodaciOOsobi().getIme() +
                "<br/>Prezime: " + interesovanje.getPodaciOOsobi().getPrezime() +
                "<br/>Adresa elektronske pošte: " + interesovanje.getPodaciOOsobi().getEmail().getValue() +
                "<br/>Broj mobilnog telefona: " + interesovanje.getPodaciOOsobi().getBrojMobilnogTelefona() +
                "<br/>Broj fiksnog telefona: " + interesovanje.getPodaciOOsobi().getBrojFiksnogTelefona().getValue() +
                "<br/>Locakija (opština): " + interesovanje.getOpstiPodaci().getLokacijaOpstina().getValue() +
                "<br/>Iskazujem interesovanje da primim isključivo vakcinu sledećih proizvođača" +
                " za koji Agencija za lekove i medicinska sredstva potvrdi bezbednost, efikasnost i kvalitet i izda dozvolu za upotrebu leka:\n" +
                interesovanje.getOpstiPodaci().getTipVakcine().getValue().value() +
                "<br/>Da li ste dobrovoljni davalac krvi? " + davalacKrvi +
                "<br/>Datum: " + interesovanje.getDatumKreiranja().toString() +
                ".<br/><br/>Vaša eUprava.", true);

        mailSender.send(message);
    }

    public void sendSledeciTerminEmail(String emailAddress, String termin, String ustanova) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);


        helper.setFrom("podrska@euprava.rs");
        helper.setTo(emailAddress);
        helper.setSubject("Naredni termin vakcinacije: " + termin);

        // todo: Na ovaj način se šalje PDF kao attachment, za digitalni sertifikat
//        helper.addAttachment("MyTestFile.txt", new ByteArrayResource("Ovo je neki kul pdf".getBytes()));

        helper.setText("Poštovani,\n\nVaš naredni termin za vakcinaciju je: " + termin + ".\nNa lokaciji: " + ustanova + ".\n\nVaša eUprava.", true);

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
                "Molimo Vas, pokušajte ponovo.\n\nHvala na razumevanju, Vaša eUprava.", true);

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
                "Molimo Vas, pokušajte ponovo.\n\nHvala na razumevanju, Vaša eUprava.", true);

        mailSender.send(message);
    }

}
