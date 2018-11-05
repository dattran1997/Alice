package base.obstacle;

import base.GameObject;
import base.action.Action;
import base.action.ActionRepeat;
import base.action.ActionSequence;
import base.action.ActionWait;

public class ObstacleManager extends GameObject {
    Action action;
    public ObstacleManager(){
        this.defineAction();
    }
    void defineAction(){
        ActionWait actionWait = new ActionWait(120);
        Action actionSpawn = new Action() {
            @Override
            public void run(GameObject master) {
                ObstacleTree1L obstacleTree1L = GameObject.recycle(ObstacleTree1L.class);
                ObstacleTree1R obstacleTree1R = GameObject.recycle(ObstacleTree1R.class);
                ObstacleTree1L obstacleTree1L1 = GameObject.recycle(ObstacleTree1L.class);
                ObstacleTree1R obstacleTree1R1 = GameObject.recycle(ObstacleTree1R.class);
                ObstacleTree1C obstacleTree1C = GameObject.recycle(ObstacleTree1C.class);

                obstacleTree1L.position.y = 2000;
                obstacleTree1R.position.y = 2000;
                obstacleTree1L1.position.y = 1000;
                obstacleTree1R1.position.y = 1500;
                obstacleTree1C.position.y = 3000;
                this.isDone = true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };
        Action actionSpawn2 = new Action() {
            @Override
            public void run(GameObject master) {
                for (int i=0; i<2 ; i++){
                    ObstacleRock1 obstacleRock1 = GameObject.recycle(ObstacleRock1.class);
                    ObstacleRock2 obstacleRock2 = GameObject.recycle(ObstacleRock2.class);
                    ObstacleChair obstacleChair = GameObject.recycle(ObstacleChair.class);
                    obstacleChair.position.setThis((float)100+(i*200), (float)800 - (i*100));
                    obstacleRock1.position.setThis((float) 80 + (i*180),(float) 750 - (i*200));
                    obstacleRock2.position.setThis((float) 100 + (i*200),(float) 780 +(i*250));
                }
                this.isDone = true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };
        ActionSequence actionSequence = new ActionSequence(actionSpawn2, actionWait, actionSpawn ,actionWait);
        ActionRepeat actionRepeat = new ActionRepeat(actionSequence);
        this.action = actionRepeat;
    }

    @Override
    public void run (){
        this.action.run(this);
    }
}
