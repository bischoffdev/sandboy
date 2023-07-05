package blog.softwaretester.sandboy;

import blog.softwaretester.sandboy.dagger.DaggerSandboyCoreGraph;
import blog.softwaretester.sandboy.exceptions.SandboyException;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "report", requiresProject = false)

public class SandboyMaven extends AbstractMojo {
    @Parameter(name = "surefireSourcePath")
    private String surefireSourcePath;
    @Parameter(name = "generatedReportPath")
    private String generatedReportPath;

    @Override
    public void execute() throws MojoExecutionException {
        System.out.println("Bomboclaat");
        try {
            SandboyEngine sandboyEngine = DaggerSandboyCoreGraph.create().getSandboyEngine();
            sandboyEngine.build(surefireSourcePath, generatedReportPath);
        } catch (SandboyException e) {
            throw new MojoExecutionException(e.getMessage());
        }
    }
}
