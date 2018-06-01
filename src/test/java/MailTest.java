import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class MailTest
{
    public static void main(String [] args)
    {
        // 收件人电子邮箱
        String to = "ncepulcy@126.com";

        // 发件人电子邮箱
        String from = "cculiuchongyang@163.com";

        // 指定发送邮件的主机为 localhost
        String host = "localhost";

        // 获取系统属性
        Properties props = new Properties();

        // 设置邮件服务器
        props.setProperty("mail.host", "smtp.163.com");//设置邮件服务器地址
        props.setProperty("mail.smtp.auth", "true");   //设置邮件服务器是否需要登录认证
        Authenticator auth=new Authenticator(){        //创建认证器
            public PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("cculiuchongyang","chongyang1016");  //用户名和密码
            }
        };
        Session session=Session.getInstance(props,auth);  //获取Session对象
        // 获取默认session对象
//        Session session = Session.getDefaultInstance(properties);

        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("This is the Subject Line!");

            // 设置消息体
            message.setText("This is actual message");

            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully....");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}