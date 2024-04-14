package bansach.demo.service;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class emailIML implements emailService {

  private JavaMailSender javaMailSender ;

    @Autowired
    public emailIML(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    @Override
    public void senMaseger(String form, String to, String tieude, String noidung) {
        //MimeMailMessage => có đính kèm file và hình ảnh
       // SimpleMailMessage message = new SimpleMailMessage() ;
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message,true);
            mimeMessageHelper.setFrom(form);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(tieude);
            mimeMessageHelper.setText(noidung ,true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(message);
    }

}
