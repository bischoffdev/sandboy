package blog.softwaretester.sandboy.dagger;

import blog.softwaretester.sandboy.SandboyEngine;
import dagger.Component;

import javax.inject.Singleton;

@Component
@Singleton
public interface SandboyCoreGraph {
    SandboyEngine getSandboyEngine();
}
