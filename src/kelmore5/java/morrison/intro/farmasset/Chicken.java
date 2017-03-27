package kelmore5.java.morrison.intro.farmasset;

public class Chicken extends Fowl
{
  public Chicken(String _name)
  {
    super(_name, "Cluck!");
  }
  public String toString()
  {
    return "Chicken named " + getName();
  }
}