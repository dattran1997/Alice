package base.score;

import base.GameObject;

import java.awt.*;

public class Score extends GameObject {
    public int score;

    public Score(){
        this.score = 0;
    }

    public void addScore (int score){
        this.score += score;
    }

    @Override
    public void render(Graphics g) {
        g.drawString("score: "+ score, 10,10);
    }
}
