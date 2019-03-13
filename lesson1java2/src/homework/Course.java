package homework;

import animals.Animal;
import valuestype.ActType;

import java.util.ArrayList;
import java.util.Arrays;

public class Course {
    private ArrayList<Barrier> barriers = new ArrayList<>();

    public Course(Barrier ... barrier){
        barriers.addAll(Arrays.asList(barrier));
    }

    public void doIt(Team team){
        if(team.getMembers().length > 0){
            Animal[] members = team.getMembers();
            int value;
            boolean result;
            for(Animal m: members){
                result = false;
                for(Barrier b: barriers){
                    value = 0;
                    if(b.getBarrierType() == ActType.JUMP)
                        value = m.jump();
                    else if(b.getBarrierType() == ActType.RUN)
                        value = m.run();
                    else if(b.getBarrierType() == ActType.SWIM)
                        value = m.swim();
                    else {
                        System.out.println("unknown barrier");
                    }
                    if(value == 0){
                        result = false;
                        break;
                    }else
                        result = true;
                }
            }
        }
    }
}
