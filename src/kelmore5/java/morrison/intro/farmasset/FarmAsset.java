package kelmore5.java.morrison.intro.farmasset;

public abstract class FarmAsset
{
  private String name;
  public FarmAsset(String _name)
  {
    name = _name;
  }
  public String getName()
  {
    return name;
  }
}