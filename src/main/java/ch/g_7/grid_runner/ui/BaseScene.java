package ch.g_7.grid_runner.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import ch.g_7.graphite.core.window.Window;
import ch.g_7.graphite.ui.UIButton;
import ch.g_7.graphite.ui.scene.Scene;
import ch.g_7.graphite.ui.scene.SceneNavigator;
import ch.g_7.graphite.ui.util.UIMouseEvent;
import ch.g_7.graphite.ui.util.UIMouseListner;
import ch.g_7.util.common.IIdentifier;

public abstract class BaseScene extends Scene {

    private Map<IIdentifier<?>, UIButton> buttons;

    public BaseScene(SceneNavigator navigator, Window window) {
        super(navigator, window);
        this.buttons = new HashMap<>();
    }
    
    @Override
    protected void doInit() {
    	super.doInit();
    	initView();
    }
    
    protected abstract void initView();

    protected void registerButton(IIdentifier<?> identifier, UIButton uiButton){
        buttons.put(identifier, uiButton);
    }

    public void addButtonListner(IIdentifier<?> identifier, Consumer<UIMouseEvent> listner){
        buttons.get(identifier).addMouseListner(new UIMouseListner() {
            @Override
            public void onClick(UIMouseEvent event) {
                listner.accept(event);
            }
            @Override
            public void onRelease(UIMouseEvent event) {}
        });
    }

}
