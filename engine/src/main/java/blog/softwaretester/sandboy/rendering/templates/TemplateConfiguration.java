package blog.softwaretester.sandboy.rendering.templates;

import blog.softwaretester.sandboy.exceptions.SandboyException;
import blog.softwaretester.sandboy.settings.Constants;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton

public class TemplateConfiguration {
    private Configuration configuration;

    @Inject
    public TemplateConfiguration() {
    }

    public void init(final String basePath) {
        configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setClassForTemplateLoading(this.getClass(), basePath);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setWhitespaceStripping(true);
        configuration.setLogTemplateExceptions(false);
    }

    public Template getTemplate(final String templateName) throws SandboyException {
        Template template;
        try {
            template = configuration.getTemplate(templateName + Constants.TEMPLATE_FILE_EXTENSION);
        } catch (Exception e) {
            throw new SandboyException("Template '" + templateName + "' was not found or not parsable: " +
                    e.getMessage());
        }
        return template;
    }
}
