/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmt.service.impl;

import com.nmt.request.MailRequest;
import com.nmt.service.MailService;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author acer
 */
@Service
public class MailServiceImpl implements MailService{
//    @Autowired
//    private JavaMailSender mailSender;
//    private static final Logger logger = LoggerFactory.getLogger(GroupController.class);


    @Override
    public void sendMailToStudent(MailRequest mailRequest) {
//        logger.debug("RUN JOB: sendMailToEachPersonGroup");
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(mailRequest.getRecipients());
//        message.setFrom(mailRequest.getFrom());
//        message.setSubject(mailRequest.getSubject());
//        message.setText(mailRequest.getBody());
//
//        mailSender.send(message);
//        logger.debug("END JOB: sendMailToEachPersonGroup");
    }
    
}
