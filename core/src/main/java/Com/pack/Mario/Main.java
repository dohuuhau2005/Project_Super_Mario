package Com.pack.Mario;

import Com.pack.Mario.ScreenBeforePlay.LoginScreen;
import com.badlogic.gdx.Game;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Main extends Game {


    @Override
    public void create() {
        setScreen(new LoginScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
