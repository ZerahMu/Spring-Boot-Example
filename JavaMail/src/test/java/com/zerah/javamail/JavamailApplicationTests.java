package com.zerah.javamail;

import com.zerah.javamail.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JavamailApplicationTests {

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;
    @Test
    public void testSimpleMail() {
        mailService.sendSimpleMail("muning@inspur.com","test simple mail A","Hello, Mail!!!");
    }

    @Test
    public void testHtmlMail() throws Exception {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("m15500878900@163.com","test Html mail",content);
    }

    @Test
    public void sendAttachmentsMail() {
        String filePath="E:\\项目文件\\sample.org";
        mailService.sendAttachmentsMail("m15500878900@163.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
    }

    @Test
    public void sendInlineResourceMail() {
        String rscId = "zerah006";      //这个是图片资源id，图片是以html格式写入邮件的
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "E:\\壁纸\\unsplash-Ines Álvarez Fdez.jpg";

        mailService.sendInlineResourceMail("m15500878900@163.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }
    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();                //Context是thymeleaf包的
        context.setVariable("id", "006");       //用户主键id
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("m15500878900@163.com","主题：这是模板邮件",emailContent);
    }

}
