package com.mazzon.flappy.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mazzon.flappy.FlappyGame;
import com.mazzon.flappy.utils.Constantes;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.resizable = false;
		config.height = Constantes.W_HEIGHT;
		config.width = Constantes.W_WIDTH;
		config.title = Constantes.TITLE;
		new LwjglApplication(new FlappyGame(), config);
	}
}
