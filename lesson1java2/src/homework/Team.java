package homework;

import animals.Animal;

public class Team {

    private String name;
    private Animal[] members = new Animal[4];

    public Animal[] getMembers(){
        return  members;
    }

    public Team(){
    }

    public Team(String name){
        this.name = name;
    }

    public Team(String name, Animal ... animals){
        this.name = name;
        int i = 0;
        for(Animal a : animals){
            members[i++] = a;
        }
    }

    public String getName(){
        return name;
    }

    public void showInfo(){
        System.out.println("Team " + getName());
        for (Animal a: members){
            if(a != null)
                System.out.println("Name: " + a.getName() +
                                ", Age: " + a.getAge() +
                                ", Gender: " + a.getGender());
        }
    }

    public void showResult(){

    }
}
