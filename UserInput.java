import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class UserInput {

    /**
     * This function will replace the user input position to our code
     * @param position the user input position from the {@link AvailablePositions}
     * @return a two value array [x pos, y pos]
     */
    @Contract(value = "_ -> new", pure = true)
    public static int @NotNull [] replaceUserPosToXY(int position){
        switch (position){
            case AvailablePositions.TOP_LEFT ->         {return new int[]{1, 1};}
            case AvailablePositions.TOP_CENTER ->       {return new int[]{1, 3};}
            case AvailablePositions.TOP_RIGHT ->        {return new int[]{1, 5};}
            case AvailablePositions.CENTER_LEFT ->      {return new int[]{3, 1};}
            case AvailablePositions.CENTER ->           {return new int[]{3, 3};}
            case AvailablePositions.CENTER_RIGHT ->     {return new int[]{3, 5};}
            case AvailablePositions.BOTTOM_LEFT ->      {return new int[]{5, 1};}
            case AvailablePositions.BOTTOM_CENTER ->    {return new int[]{5, 3};}
            case AvailablePositions.BOTTOM_RIGHT ->     {return new int[]{5, 5};}
            default ->                                  {return new int[]{-1, -1};}
        }
    }

}
