package com.mazzon.flappy.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Dudu on 18/03/2017.
 */
public abstract class State {
    //Classe abstrata deve ser extendida com a keyword "extends" pelos objetos do tipo state (MENU,PLAY)

    //Câmera pra definir área de visão do jogador
    protected OrthographicCamera cam;

    //GSM é o nosso operador de estados, que vai definir
    // qual estado vai ser atualizado/renderizado.
    protected GameStateManager gsm;

    //Metodo construtor, chamado quando algum objeto do tipo State for criado
    //recebe um GameStateManager, que será utilizado para controle de estados
    //É necessário receber o gsm para poder dar "PUSH" "POP" no nosso gsm e trocar os States por aqui
    protected State(GameStateManager gsm){
        //nossa variavel local gsm recebe um gsm(instanciado/criado)
        this.gsm = gsm;
        //Criamos nosso objeto camera
        cam = new OrthographicCamera();
        //atribuimos setToOrtho para centralizar nossa camera e definimos um tamanho pra camera (240,400)
        cam.setToOrtho(false, 240, 400);
    }

    protected void handleInput(){
    //Metodo para receber input do usuário(teclado/mouse do Desktop)
    //e do touchscreen para o Android
    }
    protected void update(float dt){
    //Metodo que atualiza posicionamento, animação, etc.
        //recebe delta time pra calcular updates por segundo.
    }
    protected void render(SpriteBatch sb){
    //Metodo que desenha na tela.
        //Recebe um SpriteBatch que realiza os desenhos
    }
    protected void dispose(){
    //metodo para limpar arquivos da memoria.
    }
}
