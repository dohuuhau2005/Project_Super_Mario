package Com.pack.Mario.Game;

import Com.pack.Mario.ScreenBeforePlay.LoginScreen;
import com.badlogic.gdx.Game;

public class SuperMario extends Game {
    @Override
    public void create() {
        setScreen(new LoginScreen(this));
    }

    @Override
    public void render() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
