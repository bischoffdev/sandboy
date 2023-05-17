package blog.softwaretester.sandboy.rendering.templates;

import blog.softwaretester.sandboy.settings.Constants;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TemplateEngine {
    private final TemplateConfiguration templateConfiguration;

    @Inject
    public TemplateEngine(final TemplateConfiguration templateConfiguration) {
        this.templateConfiguration = templateConfiguration;
        templateConfiguration.init(Constants.BASE_TEMPLATE_PATH);
    }

    public freemarker.template.Template getTemplate(final Template template) throws Exception {
        return templateConfiguration.getTemplate(template.fileName);
    }

    public enum Template {
        START_PAGE("index");

        private final String fileName;

        Template(final String fileName) {
            this.fileName = fileName;
        }

        public String getFileName() {
            return fileName;
        }
    }
}
