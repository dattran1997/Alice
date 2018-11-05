package base.enemy;

import base.GameObject;
import base.action.*;
import base.counter.FrameCounter;
import base.event.KeyEventPress;

public class EnemyManager extends GameObject {
    Action action;
    Action action1;
    Action action2;
    ActionSequence actionSequenceal3;
    FrameCounter spawnCounter;
    FrameCounter spawnCounter1;
    FrameCounter spawnCounter2;

    public EnemyManager() {
        this.defineAction();
        this.spawnCounter = new FrameCounter(30);
        this.spawnCounter1 = new FrameCounter(40);
        this.spawnCounter2 = new FrameCounter(50);
    }

    void defineAction() {
        ActionWait actionWait = new ActionWait(200);
        ActionWait actionWait1 = new ActionWait(500);
        Action spawnAction1 = new Action() {
            @Override
            public void run(GameObject master) {
                for (int i = 0; i < 2; i++) {
                    EnemyType1 enemyType1 = GameObject.recycle(EnemyType1.class);
                    enemyType1.position.setThis((float) 230 * (i + 1), 900f);
                }

                EnemyType1 enemyType1 = GameObject.recycle(EnemyType1.class);
                enemyType1.position.setThis(350f, 800f);
                EnemyType1 enemyType2 = GameObject.recycle(EnemyType1.class);
                enemyType2.position.setThis(150f, 1000f);
                EnemyType1 enemyType3 = GameObject.recycle(EnemyType1.class);
                enemyType3.position.setThis(550f, 1000f);
                this.isDone = true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };

        Action spawnAction2 = new Action() {
            @Override
            public void run(GameObject master) {
                for (int i = 0; i < 3; i++) {
                    EnemyType1 enemy1 = GameObject.recycle(EnemyType1.class);
                    enemy1.position.setThis((float) 10 + (i + 1) * 60, 900f);
                }
                for (int i = 0; i < 3; i++) {
                    EnemyType1 enemyType1 = GameObject.recycle(EnemyType1.class);
                    enemyType1.position.setThis((float) 220 + (i + 1) * 60, 800f);
                }
                for (int i = 0; i < 3; i++) {
                    EnemyType1 enemyType1 = GameObject.recycle(EnemyType1.class);
                    enemyType1.position.setThis((float) 430 + (i + 1) * 60, 900f);
                }
                this.isDone = true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };

        Action spawnAction3 = new Action() {
            @Override
            public void run(GameObject master) {
                EnemyType1 enemyType1 = GameObject.recycle(EnemyType1.class);
                enemyType1.position.setThis(350f, 800f);
                for (int i = 0; i < 3; i++) {
                    EnemyType1 enemy1 = GameObject.recycle(EnemyType1.class);
                    enemy1.position.setThis((float) (100 + (i * 80)), 900f);
                }
                for (int i = 0; i < 3; i++) {
                    EnemyType1 enemy2 = GameObject.recycle(EnemyType1.class);
                    enemy2.position.setThis((float) 450f + (i * 80), 900f);
                }
                this.isDone = true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };
        Action spawnAction4 = new Action() {
            @Override
            public void run(GameObject master) {
                for (int i = 0; i < 2; i++) {
                    EnemyType1 enemy1 = GameObject.recycle(EnemyType1.class);
                    enemy1.position.setThis(150f + (i * 350), 800f);
                    EnemyType1 enemy2 = GameObject.recycle(EnemyType1.class);
                    enemy2.position.setThis(50f + (i * 350), 900f);
                    EnemyType1 enemy3 = GameObject.recycle(EnemyType1.class);
                    enemy3.position.setThis(250f + (i * 350), 900f);
                    EnemyType1 enemy4 = GameObject.recycle(EnemyType1.class);
                    enemy4.position.setThis(150f + (i * 350), 1000f);
                }
                this.isDone = true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };
        Action spawnAction5 = new Action() {
            @Override
            public void run(GameObject master) {
                for (int i = 0; i < 2; i++) {
                    EnemyType1 enemyType1 = GameObject.recycle(EnemyType1.class);
                    enemyType1.position.setThis((float) 300 + (i * 60), 800f);
                }
                for (int i = 0; i < 2; i++) {
                    EnemyType1 enemyType1 = GameObject.recycle(EnemyType1.class);
                    enemyType1.position.setThis((float) 170 + (i * 320), 900f);
                }
                for (int i = 0; i < 2; i++) {
                    EnemyType1 enemyType1 = GameObject.recycle(EnemyType1.class);
                    enemyType1.position.setThis((float) 210 + (i * 250), 1000f);
                }
                for (int i = 0; i < 2; i++) {
                    EnemyType1 enemyType1 = GameObject.recycle(EnemyType1.class);
                    enemyType1.position.setThis((float) 260 + (i * 150), 1100f);
                }
                EnemyType1 enemyType1 = GameObject.recycle(EnemyType1.class);
                enemyType1.position.setThis((float) 340, 1200f);
                this.isDone = true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };
        Action spawnAction6 = new Action() {
            @Override
            public void run(GameObject master) {
                for (int i = 0; i < 2; i++) {
                    EnemyType1 enemyType1 = GameObject.recycle(EnemyType1.class);
                    enemyType1.position.setThis((float) 280 + (i * 150), 800f);
                }
                for (int i = 0; i < 2; i++) {
                    EnemyType1 enemyType1 = GameObject.recycle(EnemyType1.class);
                    enemyType1.position.setThis((float) 200 + (i * 310), 900f);
                }
                for (int i = 0; i < 2; i++) {
                    EnemyType1 enemyType1 = GameObject.recycle(EnemyType1.class);
                    enemyType1.position.setThis((float) 200 + (i * 310), 1050f);
                }
                for (int i = 0; i < 2; i++) {
                    EnemyType1 enemyType1 = GameObject.recycle(EnemyType1.class);
                    enemyType1.position.setThis((float) 280 + (i * 150), 1150f);
                }
                this.isDone = true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };
        ActionSequence actionSequence = new ActionSequence(spawnAction1, actionWait);
        ActionSequence actionSequence1 = new ActionSequence(spawnAction2, actionWait1);
        ActionSequence actionSequence2 = new ActionSequence(spawnAction3, actionWait);
        ActionSequence actionSequence3 = new ActionSequence(spawnAction4, actionWait1);
        ActionSequence actionSequence4 = new ActionSequence(spawnAction5, actionWait);
        ActionSequence actionSequence5 = new ActionSequence(spawnAction6, actionWait1);
        ActionSequence actionSequence12 = new ActionSequence(actionSequence, actionSequence1);
        actionSequenceal3 = new ActionSequence(actionSequence2, actionSequence3);
        ActionSequence actionSequenceal4 = new ActionSequence(actionSequence3, actionSequence4);
        ActionRepeat actionRepeat = new ActionRepeat(actionSequence12);
        ActionRepeat actionRepeat1 = new ActionRepeat(actionSequenceal3);
        ActionRepeat actionRepeat2 = new ActionRepeat(actionSequenceal4);

        this.action = actionRepeat;
        this.action1 = actionRepeat1;
        this.action2 = actionRepeat2;
    }

    @Override
    public void run() {
        //super.run();
//        if(spawnCounter.run()){
//            this.action.run(this);
//            spawnCounter.reset();
//        }
//        if (spawnCounter1.run()){
//            this.action1.run(this);
//            spawnCounter1.reset();
//        }
//        if(spawnCounter2.run()){
//            this.action2.run(this);
//            spawnCounter2.reset();
//        }

        this.action.run(this);

    }

}
