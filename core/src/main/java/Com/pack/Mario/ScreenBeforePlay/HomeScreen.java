package Com.pack.Mario.ScreenBeforePlay;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class HomeScreen implements Screen {
    Game game;
    Stage stage;
    Table table;
    Skin skin;
    TextButton playbtn;

    public HomeScreen(Game game) {
        this.game = game;
        this.stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        skin = new Skin(Gdx.files.internal("uiskin.json"));

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
        CreateTable();
        PlayClicked();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    public void PlayClicked() {
        playbtn.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                if (playbtn.isPressed()) {
                    game.setScreen(new LoginScreen(game));
                    return true;
                }
                return false;
            }
        });
    }

    public void CreateTable() {
        table = new Table();
        table.setFillParent(true);
        table.center();

        stage.addActor(table);
        playbtn = new TextButton("Play", skin);
        table.add(playbtn);

    }

    @Override
    public void show() {
        //input processor just have 1 threat --> multi processor
        InputAdapter EscClickExit = new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                if (keycode == Input.Keys.ESCAPE) {
                    showDialog();
                }
                return false;
            }

        };
        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(EscClickExit);
        multiplexer.addProcessor(stage);
        Gdx.input.setInputProcessor(multiplexer);
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
