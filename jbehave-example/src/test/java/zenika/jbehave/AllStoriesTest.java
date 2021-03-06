package zenika.jbehave;

import zenika.jbehave.util.Springs;
import zenika.jbehave.util.UTF8StoryLoader;
import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;
import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.junit.runner.RunWith;

import java.net.URL;
import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML_TEMPLATE;

@RunWith(JUnitReportingRunner.class)
public class AllStoriesTest extends JUnitStories {

    private final CrossReference xref = new CrossReference();

    public AllStoriesTest() {
        configuredEmbedder()//
                .embedderControls()//
                .doGenerateViewAfterStories(true)//
                .doIgnoreFailureInStories(false)//
                .doIgnoreFailureInView(true)//
                .doVerboseFailures(true)//
                .useThreads(2)//
                .useStoryTimeoutInSecs(6000);
    }

    @Override
    public Configuration configuration() {
        Class<? extends Embeddable> embeddableClass = this.getClass();
        URL codeLocation = codeLocationFromClass(embeddableClass);
        StoryReporterBuilder storyReporter =
                new StoryReporterBuilder()
                        .withCodeLocation(codeLocation)
                        .withDefaultFormats()
                        .withFormats(CONSOLE,
                                     HTML_TEMPLATE)
                        .withFailureTrace(true)
                        .withFailureTraceCompression(true)
                        .withCrossReference(xref);
        return new MostUsefulConfiguration()
                .useStoryLoader(new UTF8StoryLoader(embeddableClass))
                .useStoryReporterBuilder(storyReporter)
                .usePendingStepStrategy(new FailingUponPendingStep())
                .useStepMonitor(xref.getStepMonitor())
                ;
    }

    @Override
    protected List<String> storyPaths() {
        URL searchInURL = codeLocationFromClass(this.getClass());
        return new StoryFinder().findPaths(searchInURL, "**/*.story", "**/fail/*");
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new SpringStepsFactory(configuration(),
                                      Springs.createAnnotatedContextFromBasePackages("zenika.jbehave"));
    }
}
