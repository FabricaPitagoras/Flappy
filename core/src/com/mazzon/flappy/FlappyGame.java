package com.mazzon.flappy;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mazzon.flappy.states.GameStateManager;
import com.mazzon.flappy.states.MenuState;

public class FlappyGame extends ApplicationAdapter {
	//declaramos o nosso gsm e o nosso sb
	//eles são privados pra nenhuma outra classe acessar sem permissão
	//a única maneira de ter acesso é quando nós passamos por parametro
	private GameStateManager gsm;
	private SpriteBatch sb;
	private static final String TAG = FlappyGame.class.getName();

	@Override
	public void create () {
		Gdx.app.log(TAG,"Create chamado");
		//criamos(instanciamos) o nosso gsm
		gsm = new GameStateManager();
		//usamos o metodo push do gsm pra já iniciar a pilha com o nosso estado Menu
		//ou seja, sempre que Create for chamado nós vamos inicar a aplicação
		//criar nosso gsm, e inserir um MenuState, obviamente pro nosso jogo iniciar no menu
		//new MenuState(gsm) cria um Objeto do tipo MenuState e passar por parametro pro metodo push
		gsm.push(new MenuState(gsm));

		//criamos nosso spritebach que será utilizado pela aplicação para desenhar na tela.
		sb = new SpriteBatch();
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.log(TAG,"resize chamado");
		super.resize(width, height);
	}

	@Override
	public void pause() {
		Gdx.app.log(TAG,"pause chamado");
		super.pause();
	}

	@Override
	public void resume() {
		Gdx.app.log(TAG,"resume chamado");
		super.resume();
	}

	@Override
	public void render () {
		//Gdx.app.log(TAG,"Render chamado");
		//limpamos a tela
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//como quem é responsavel por atualizar o nosso jogo e desenhar
		//nós chamamos os metodos responsaveis por isso dentro do nosso gsm

		//update recebe o nosso delta time, e nós pegamos ele usando nosso modulo graphics
		//o metodo getDeltaTime vai retornar um float com o valor da ultima atualização
		gsm.update(Gdx.graphics.getDeltaTime());
		//passamos nosso Spritebatch por parametro pro gsm render.
		gsm.render(sb);
	}
	
	@Override
	public void dispose () {
		Gdx.app.log(TAG,"dispose chamado");
		//limpamos o nosso sb da memoria.
		sb.dispose();
		//chamamos o dispose do gsm
		gsm.dispose();
	}
}
