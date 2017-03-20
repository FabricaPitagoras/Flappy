package com.mazzon.flappy.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by Dudu on 18/03/2017.
 */
public class GameStateManager {
    //declaramos nossa variavel da pilha que manterá os nosso estados
    private Stack<State> states;

    //o nosso construtor do gsm, chamados quando instanciamos ele dentro da calsse FlappyBird
    //gsm = new GamestateManager() na verdade invoca esse metodo.
    public GameStateManager(){

        //instanciamos nossa pilha, ela é uma variavel, mas tambem é um objeto e precisa ser instanciado
        states = new Stack<State>();
    }

    //push adiciona um estado na nossa pilha
    //lembre-se que em uma pilha, nós só temos acesso ao ultimo valor inserido
    public void push(State state){
        states.push(state);
    }

    //pop retira o valor da pilha
    //mais uma vez, na pilha sempre retiramos de cima.
    public void pop(){
        states.pop();
    }

    //aqui nós chamamos o metodo update do ultimo estado inserido
    public void update(float dt){
        //peek seleciona o ultimo valor inserido
        //ex: se o ultimo valor inserido foi MenuState
        //ex: states.peek().update(dt) == MenuState.update(dt)
        states.peek().update(dt);
    }

    //a mesma coisa do metodo anterior, só que ao invez de atualizar ele renderiza
    //passando o nosso spritebach que foi criado em FlappyGame
    public void render(SpriteBatch sb){
        //ex: MenuState.render(sb)
        states.peek().render(sb);
    }

    //limpamos a memoria do nosso estado quando ele for eliminado da pilha.
    public void dispose(){
        //ex: MenuState.dispose();
        states.peek().dispose();
    }
}
