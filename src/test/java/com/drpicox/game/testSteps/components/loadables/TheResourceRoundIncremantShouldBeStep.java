package com.drpicox.game.testSteps.components.loadables;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.entities.PrettyKey;
import org.springframework.stereotype.Component;

@Component
public class TheResourceRoundIncremantShouldBeStep extends AbstractPostLineStep {

    private final LoadableTestView loadableTestView;

    public TheResourceRoundIncremantShouldBeStep(LoadableTestView loadableTestView) {
        this.loadableTestView = loadableTestView;
    }

    @Override
    protected String getRegex() {
        return "The resource \"([^\"]+)\" round increment should be 0.";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var resource = PrettyKey.getKey(match[1]);

        loadableTestView.load(resource);
    }
}
