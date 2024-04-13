package bansach.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
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
        SimpleMailMessage message = new SimpleMailMessage() ;
         message.setFrom(form);
         message.setTo(to);
         message.setSubject(tieude);
         message.setText(noidung);
         javaMailSender.send(message);
    }

}
