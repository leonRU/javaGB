package homework;

import valuestype.ActType;

public class Barrier {
    private ActType barrierType;

    public Barrier(ActType type){
        barrierType = type;
    }

    public ActType getBarrierType(){
        return  barrierType;
    }
}
