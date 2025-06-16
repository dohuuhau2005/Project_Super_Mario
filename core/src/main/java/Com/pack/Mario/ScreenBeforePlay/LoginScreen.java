package Com.pack.Mario.ScreenBeforePlay;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class LoginScreen implements Screen {
    Game game;
    Stage stage;//giao dien + actor + input
    TextButton loginButton;
    Skin skin;
    TextField UsernameField;
    TextField PasswordField;

    public LoginScreen(Game game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        CreateTable();
        ClickLogin();
    }

    //tao table
    public void CreateTable() {
        Table table = new Table();
        table.setFillParent(true);
        table.center();
        stage.addActor(table);

        UsernameField = new TextField("", skin);
        PasswordField = new TextField("", skin);
        PasswordField.setPasswordMode(true);
        PasswordField.setPasswordCharacter('*');
        loginButton = new TextButton("login", skin);
        Label title = new Label("Login", skin);
        //cútom
        table.add(title).colspan(2).padBottom(30).padTop(20);
        table.row();
        table.add(UsernameField).colspan(3).padTop(20).padBottom(20);
        table.row();
        table.add(PasswordField).colspan(3).padTop(20).padBottom(20);
        table.row();
        table.add(loginButton).colspan(2).padBottom(30).padTop(20);

    }

    public void ClickLogin() {
        loginButton.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                if (loginButton.isPressed()) {
                    String username = UsernameField.getText();
                    String password = PasswordField.getText();
                    if (username.equals("admin") && password.equals("admin")) {
                        System.out.println("Login Successful");
                        game.setScreen(new HomeScreen(game));

                    } else {
                        System.out.println("Login Failed");
                    }
                }
                return false;
            }
        });
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
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.15f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();

    }
}
