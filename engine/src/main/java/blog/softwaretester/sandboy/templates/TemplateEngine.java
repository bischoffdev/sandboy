/*
 * Copyright 2023 trivago N.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package blog.softwaretester.sandboy.templates;

import blog.softwaretester.sandboy.exceptions.SandboyException;

import javax.inject.Inject;
import javax.inject.Singleton;

import static blog.softwaretester.sandboy.settings.Constants.BASE_TEMPLATE_PATH;

/**
 * This class manages the Freemarker templates.
 */
@Singleton
public class TemplateEngine {
    private final TemplateConfiguration templateConfiguration;

    /**
     * Constructor for dependency injection.
     *
     * @param templateConfiguration The {@link TemplateConfiguration} instance.
     */
    @Inject
    public TemplateEngine(final TemplateConfiguration templateConfiguration) {
        this.templateConfiguration = templateConfiguration;
        templateConfiguration.init(BASE_TEMPLATE_PATH);
    }

    public freemarker.template.Template getTemplate(final Template template) throws SandboyException {
        return templateConfiguration.getTemplate(template.fileName);
    }

    /**
     * The enum that defines the different Freemarker template names.
     */
    public enum Template {
        HOME_PAGE("index");

        private final String fileName;

        Template(final String fileName) {
            this.fileName = fileName;
        }

        public String getFileName() {
            return fileName;
        }
    }
}
