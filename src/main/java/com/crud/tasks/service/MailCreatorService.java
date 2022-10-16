package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.CompanyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;


@Service
public class MailCreatorService {
    private static String HTML = "mail/created-trello-card-mail";

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private CompanyConfig companyConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message){
        List<String> functionality = getFunctionalityList();

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "https://mihuul.github.io/");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig);
        context.setVariable("preview_message", message.substring(0,8));
        context.setVariable("company_details", companyConfig.getCompanyDetails());
        context.setVariable("show_button", true);
        context.setVariable("is_friend", true);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process(HTML, context);
    }

    public String buildScheduledCardQuantityMail(String message) {
        List<String> functionality = getFunctionalityList();

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "https://mihuul.github.io/");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig);
        context.setVariable("preview_message", message.substring(0,8));
        context.setVariable("company_details", companyConfig.getCompanyDetails());
        context.setVariable("show_button", true);
        context.setVariable("is_friend", true);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process(HTML, context);
    }

    private List<String> getFunctionalityList() {
        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");
        return functionality;
    }

}
