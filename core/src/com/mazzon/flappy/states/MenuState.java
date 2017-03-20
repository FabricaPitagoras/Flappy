package com.mazzon.flappy.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mazzon.flappy.utils.Constantes;

/**
 * Created by Dudu on 18/03/2017.
 */
public class MenuState extends State {
    //declaramos as nossa texturas
    Texture background;
    Texture playBtn;

    public MenuState(GameStateManager gsm) {
        //super é uma palavra reservada que vai invocar o metodo na classe herdada
        //nesse caso super(gsm), vai invocar o construtor de State e passar o gsm por parametro
        super(gsm);

        //Criamos nossas texturas com base na nossas imagens importante colocar a extensão)
        //as imagens estão dentro da pasta "assets" do projeto android.
        //eu coloquei mais imagens lá, desenhem na tela o "ground" tambem (lembre de posicionar)
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");
    }

    //Quando nós damos "Override" ou melhor dizem "reencrevemos" o metodo, nós estamos
    //adicionando ou mudando o comportamento do metodo que já foi definido na classe herdada
    @Override
    protected void handleInput() {
        //justTouched devolve "true" quando houver um click do mouse ou um toque na tela
        if(Gdx.input.justTouched()){
            //se a tela for tocada nós vamos falar pro nosso gsm que pode inserir um PlayState
            //ou seja, pode inserir na pilha um estado PlayState e começar a atualizar ele.
            //eu comentei a linha porque eu ainda não criei o PlayState, se vocês quiserem criar
            //vá em frente, adicionem um background, e o passarinho(ainda sem movimento).

            //gsm.Push(new PlayState(gsm));
        }
    }

    @Override
    protected void update(float dt) {
        //o nosso menu é bem simples, ele só fica esperando um toque pra começar o jogo.
        //ele não possui nenhum objeto movel, então nao precisamos atualizar nada.
        //A única coisa importante é chamar o nosso metodo "handleInput", pra que ele atualize
        //a captação de toques.
        handleInput();

    }

    @Override
    protected void render(SpriteBatch sb) {
        //Iniciamos o nosso sb
        sb.begin();
        //desenhamos o nosso chao usando o sb, primeiro passamos a textura, depois a posição x e y,
        //e por ultimo o tamanho, se necessario.
        //abram o arquivo Constantes dentro de Utils pra ver nossas constantes
        sb.draw(background, 0, 0, Constantes.W_WIDTH, Constantes.W_HEIGHT);
        //nesse caso não precisamos redimensionar a imagem, então não passamos os parametros de tamanho.
        sb.draw(playBtn, (Constantes.W_WIDTH / 2) - (playBtn.getWidth() / 2), Constantes.W_HEIGHT / 2);
        //finalizamos o nosso sb
        sb.end();
    }

    @Override
    protected void dispose() {
        //lembre-se de limpar a memoria depois que não precisar mais das texturas
        background.dispose();
        playBtn.dispose();
    }
}
