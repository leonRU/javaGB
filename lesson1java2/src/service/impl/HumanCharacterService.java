package service.impl;

import constants.Constants;
import valuestype.ActType;
import animals.CharacterValue;
import service.CharacterService;
import valuestype.Gender;

/**
 * @author ilnaz-92@yandex.ru
 * Created on 2019-03-11
 */
public class HumanCharacterService implements CharacterService
{
  @Override
  public CharacterValue getCharacterValue(ActType actType)
  {
    CharacterValue characterValue = new CharacterValue();

    if (actType == ActType.JUMP)
    {
      int value = (Constants.Human.Female.POWER + Constants.Human.Male.POWER) / 2;
      characterValue.setValue(value);
      characterValue.setName(ActType.JUMP.toString());
    }
    else if (actType == ActType.RUN)
    {
      int value = (Constants.Human.Female.SPEED + Constants.Human.Male.SPEED) / 3;
      characterValue.setValue(value);
      characterValue.setName(ActType.RUN.toString());
    }
    else if (actType == ActType.SWIM)
    {
      int value = (Constants.Human.Female.SPEED + Constants.Human.Male.SPEED) / 6;
      characterValue.setValue(value);
      characterValue.setName(ActType.SWIM.toString());
    }

    return characterValue;
  }

  @Override
  public CharacterValue getCharacterValue(ActType actType, Gender gender)
  {
    CharacterValue characterValue = new CharacterValue();

    if (actType == ActType.JUMP)
    {
      if (gender == Gender.MALE)
      {
        int value = (Constants.Human.Male.POWER) / 2;
        characterValue.setValue(value);
        characterValue.setName(ActType.JUMP.toString());
      }
      else
      {
        int value = (Constants.Human.Female.POWER) / 5;
        characterValue.setValue(value);
        characterValue.setName(ActType.JUMP.toString());
      }
    }
    else if (actType == ActType.RUN)
    {
      if (gender == Gender.MALE)
      {
        int value = (Constants.Human.Male.SPEED) / 3;
        characterValue.setValue(value);
        characterValue.setName(ActType.RUN.toString());
      }
      else
      {
        int value = (Constants.Human.Female.SPEED) / 3;
        characterValue.setValue(value);
        characterValue.setName(ActType.RUN.toString());
      }
    }
    else if (actType == ActType.SWIM)
    {
      if (gender == Gender.MALE)
      {
        int value = (Constants.Human.Male.SPEED) / 6;
        characterValue.setValue(value);
        characterValue.setName(ActType.SWIM.toString());
      }
      else
      {
        int value = (Constants.Human.Female.SPEED) / 6;
        characterValue.setValue(value);
        characterValue.setName(ActType.SWIM.toString());
      }
    }

    return characterValue;
  }
}
