import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class RotMinimazer
{
    public static void main(String[] args)
    {
        Scanner enter = new Scanner(System.in);

        ArrayList<String> LExtremes = new ArrayList<String>();
        ArrayList<String> NExtremes = new ArrayList<String>();

        System.out.println("Enter L extremes.(enter a blank line to end entry)");

        while (true)
        {
            String line = enter.nextLine();
            if (line.isEmpty())
            {
                break;
            }

            if (isValidInput(line))
            {
                LExtremes.add(line);
            }
            else
            {
                System.out.println("Invalid input, skipping");
            }
        }

        System.out.println("Enter N extremes.(enter a blank line to end entry)");

        while (true)
        {
            String line = enter.nextLine();

            if (line.isEmpty())
            {
                break;
            }

            if (isValidInput(line))
            {
                NExtremes.add(line);
            }
            else
            {
                System.out.println("Invalid input, skipping");
            }
        }

    }
    static boolean isValidInput(String input)
    {
        String regex = "[01*]+";
        return input.matches(regex);
    }

    static void SolveRot(ArrayList<String> NExtremes, ArrayList<String> LExtremes)
    {
        System.out.println("hi");
    }

    static ArrayList<String> sumC(ArrayList<String> LExtremes, ArrayList<String> NExtremes)
    {
        ArrayList<String> sum = new ArrayList<>();
        ArrayList<String> combinedList = new ArrayList<String>(LExtremes);
        combinedList.addAll(NExtremes);

        if (combinedList.size() < 2)
        {
            return combinedList;
        }

        ArrayList<String> result = new ArrayList<>();
        int len = combinedList.get(0).length();

        for (int i = 0; i < len; i++)
        {
            char curr = combinedList.get(0).charAt(i);
            boolean isSame = true;

            for (int j = 1; j < combinedList.size(); j++)
            {
                char other = combinedList.get(j).charAt(i);

                if (curr != other)
                {
                    isSame = false;
                    break;
                }
            }

            result.add(isSame ? Character.toString(curr) : "y");
        }

        for (String s : result)
        {
            System.out.print(s + " ");
        }
        
        return result;
    }

}
