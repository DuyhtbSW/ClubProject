package model.User;

import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

    public String getRandom() {
        Random rd = new Random();
        int number = rd.nextInt(999999);
        return String.format("%06d", number);
    }

    public void sendEmail(String email, String OTP, String content) {

        final String fromEmail = "student.club.management105@gmail.com";
        final String password = "jdbuffoudhhnhcbq";
        final String toEmail = email;

        Properties pro = new Properties();
        pro.put("mail.smtp.host", "smtp.gmail.com");
        pro.put("mail.smtp.port", "587");
        pro.put("mail.smtp.auth", "true");
        pro.put("mail.smtp.starttls.enable", "true");
//            pro.put("mail.smtp.socketFactory.port", "587");
//            pro.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Session session = Session.getInstance(pro, auth);

        MimeMessage msg = new MimeMessage(session);
        try {
            msg.addHeader("Content-type", "text/html; charset=UTF-8");
            msg.setFrom(fromEmail);
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            msg.setSubject("OTP Verification Code [" + System.currentTimeMillis() + "]");
//            msg.setReplyTo(InternetAddress.parse(fromEmail, false));
            String emailContent = "<h1>" + content + " is: " + OTP + "</h1>";
//            String emailContent = "<h1>OTP code to reset your password is: " + OTP + "</h1>";
            msg.setContent(emailContent, "text/html");
            Transport.send(msg);
        } catch (Exception e) {
        }
    }

//    private void sendOTP(String recipientEmail, String OTP) {
//        // Thông tin tài khoản email của bạn
//        final String fromEmail = "student.club.management105@gmail.com";
//        final String password = "jdbuffoudhhnhcbq";
//        final String toEmail = recipientEmail;
//
//        // Cấu hình SMTP server và cổng
//        String smtpHost = "smtp.gmail.com";
//        int smtpPort = 587;
//
//        // Cấu hình các thuộc tính của email
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", smtpHost);
//        props.put("mail.smtp.port", smtpPort);
//
//        // Tạo session để xác thực tài khoản email và gửi email
//        Session session = Session.getInstance(props, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(fromEmail, password);
//            }
//        });
//
//        try {
//            // Tạo đối tượng MimeMessage
//            Message message = new MimeMessage(session);
//
//            // Thiết lập thông tin người gửi
//            message.setFrom(new InternetAddress(fromEmail));
//
//            // Thiết lập thông tin người nhận
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
//
//            // Thiết lập tiêu đề email
//            message.setSubject("OTP Verification");
//
//            // Thiết lập nội dung email
//            String emailContent = "Your OTP is: " + OTP;
//            message.setText(emailContent);
//
//            // Gửi email
//            Transport.send(message);
//
//            System.out.println("Email sent successfully!");
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }
}
