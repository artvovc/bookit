package com.deusto.services.template;

import freemarker.template.Configuration;
import org.apache.commons.beanutils.BeanMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

@Service
public class FreeMarkerService {

    @Autowired
    @Qualifier("freeMarkerConfiguration")
    private Configuration freeMarkerConfiguration;

    public <T> String html(String html, T reg) throws Exception {
        return FreeMarkerTemplateUtils.processTemplateIntoString(
                freeMarkerConfiguration.getTemplate(html),
                new BeanMap(reg));
    }
}
