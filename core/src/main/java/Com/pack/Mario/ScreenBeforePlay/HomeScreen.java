package Com.pack.Mario.ScreenBeforePlay;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class HomeScreen implements Screen {
    Game game;
    Stage stage;

    public HomeScreen(Game game) {
        this.game = game;
        this.stage = new Stage();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                if (keycode == Input.Keys.ESCAPE) {
                    showDialog();

                }
                return true;
            }
        });
    }

    private void showDialog() {
        Dialog dialog = new Dialog("Exit ?", new Skin(Gdx.files.internal("uiskin.json"))) {
            @Override
            public void result(Object object) {
                boolean yes = (boolean) object;
                if (yes) {
                    Gdx.app.exit();
                } else {
                    this.hide();
                }
            }
        };

        dialog.text("Exit ?");
        dialog.button("Yes", true);
        dialog.button("No", false);
        dialog.show(stage);
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        this.stage.dispose();
    }

}
