package com.drpicox.game.testSteps.multiplayer;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.navigator.NavigatorTestView;
import org.springframework.stereotype.Component;

@Component
public class CancelAddNextPlayerStep extends AbstractPostLineStep {

    private NavigatorTestView navigatorTestView;

    public CancelAddNextPlayerStep(NavigatorTestView navigatorTestView) {
        this.navigatorTestView = navigatorTestView;
    }

    @Override
    protected String getRegex() {
        return "Cancel add next player";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        navigatorTestView.popScreenName();
    }
}