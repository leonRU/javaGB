import animals.Cat;
import animals.Dog;
import animals.Human;
import homework.Barrier;
import homework.Course;
import homework.Team;
import valuestype.ActType;
import valuestype.Gender;

/**
 * @author ilnaz-92@yandex.ru
 * Created on 2019-03-11
 */
public class ProgramLauncher
{
  public static void main(String[] args)
  {

    Cat maleCat = new Cat(2, "Vasya", Gender.MALE);
    Cat femaleCat = new Cat(3, "Katya", Gender.FEMALE);

    Dog maleDog = new Dog(5,"dog_one", Gender.MALE);
    Dog femaleDog = new Dog(5,"dog_two", Gender.FEMALE);

    Human maleHuman = new Human(25,"human_three", Gender.MALE);
    Human femaleHuman = new Human(25,"human_four", Gender.FEMALE);


//    //RUN
//    System.out.println(maleCat.getName() + " : " + maleCat.run());
//    System.out.println(femaleCat.getName() + " : " + femaleCat.run());
//
//    //JUMP
//    System.out.println(maleCat.getName() + " : " + maleCat.jump());
//    System.out.println(femaleCat.getName() + " : " + femaleCat.jump());
//
//    //DOG
//    System.out.println(femaleDog.getName() + " : " + femaleDog.swim());
//
//    //HUMAN
//    System.out.println(femaleHuman.getName() + " : " + femaleHuman.swim());

    Team t1 = new Team("team1", femaleCat, femaleDog, maleCat);
    t1.showInfo();

    Barrier b1 = new Barrier(ActType.JUMP);
    Barrier b2 = new Barrier(ActType.SWIM);

    Course c = new Course(b1, b2);

    c.doIt(t1);

    t1.showResult();



  }
}
