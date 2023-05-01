import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;
public class CarnoMinimazer
{
    public static void main(String[] args)
    {
        Scanner choose = new Scanner(System.in);
        int variables;

        while (true)
        {
            System.out.println("Enter a number of variables");
            try
            {
                variables = choose.nextInt();
                choose.nextLine();
                break;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Error. Enter integer number");
                choose.nextLine();
            }
        }

        ArrayList<String> LExrtemes = new ArrayList<String>();
        ArrayList<String> NExtremes = new ArrayList<String>();

        int rows = (int) Math.pow(2, variables / 2);
        int columns = (int) Math.pow(2, (variables + 1) / 2);

        CarnoMap(variables, rows, columns);

        String[][] elements = FillMap(rows, columns);

        findLExtremes(elements, LExrtemes, variables, rows, columns);
        findNExtremes(elements, NExtremes, variables, rows, columns);

        GoToRot(LExrtemes, NExtremes);
    }
    static void CarnoMap(int count, int rows, int columns)
    {
        String alignHeader = new String(" ");

        if (count == 1)
        {
            System.out.print(alignHeader);
        }
        else if (count % 2 == 0)
        {
            int align = count / 2;

            for (int i = 0; i < align; i++)
            {
                System.out.print(alignHeader);
            }
        }
        else
        {
            int align = (count - 1) / 2;

            for (int i = 0; i < align; i++)
            {
                System.out.print(alignHeader);
            }
        }

        System.out.print("| ");

        for (int i = 0; i < columns; i++)
        {
                System.out.print(getHeaderColumns(count, columns, i) + " ");
        }

        System.out.println();

        for (int i = 0; i < rows; i++)
        {
            System.out.print(getHeaderRows(count, columns, i) + "| ");

            for (int j = 0; j < columns; j++)
            {
                int value = getCellValue(i, j, columns);

                if (value <= rows * columns / 2)
                {
                    System.out.print(" " + value + " ");
                }
                else
                {
                    int digits = Integer.toString(value).length();
                    System.out.print(" ");

                    for (int k = 0; k < (count + 1) / 2 - digits; k++)
                    {
                        System.out.print(" ");
                    }

                    System.out.print(value);
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }

   static String ConvertToBinary(int number, int digits)
   {
        String binary = Integer.toBinaryString(number);

        while (binary.length() < digits)
        {
            binary = "0" + binary;
        }

        return binary;
   }

   static int getCellValue(int i, int j, int columns)
   {
       return (i * columns + j) + 1;
   }
    static String getHeaderColumns(int count, int columns, int i)
    {
        if (i < columns / 2 || (columns % 2 == 1))
        {
            return ConvertToBinary(i, (count + 1) / 2);
        }
        else
        {
            int index = columns - (i - columns / 2) - 1;
            return ConvertToBinary(index, (count + 1) / 2);
        }
    }

    static String getHeaderRows(int count, int rows, int i)
    {
        if (i < rows / 2 || (rows % 2 == 1))
        {
            return ConvertToBinary(i, count / 2);
        }
        else
        {
            int index = rows - (i - rows / 2) - 1;
            return ConvertToBinary(index, count / 2);
        }
    }

    static String[][] FillMap(int rows, int columns)
    {
        Scanner enter = new Scanner(System.in);
        String[][] elements = new String[rows][columns];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                boolean isValidInput = false;
                String input = "";

                while (!isValidInput)
                {
                    System.out.printf("[%d]", getCellValue(i, j ,columns));
                    input = enter.nextLine();

                    if (input.equals("0") || input.equals("1") || input.equals("*"))
                    {
                        isValidInput = true;
                    }
                    else
                    {
                        System.out.println("Error. Enter 0, 1 or *.");
                    }
                }

                elements[i][j] = input;
            }
        }

        return elements;
    }

    static void findLExtremes(String[][] elements, ArrayList<String> Lextremes, int count, int rows, int columns)
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                if (elements[i][j].equals("1"))
                {
                    Lextremes.add(getHeaderColumns(count, columns, j) + getHeaderRows(count, columns, i));
                }
            }
        }

        for (String list : Lextremes)
        {
            System.out.println(list);
        }
    }

    static void findNExtremes(String[][] elements, ArrayList<String> Nextremes, int count, int rows, int columns)
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                if (elements[i][j].equals("*"))
                {
                    Nextremes.add(getHeaderColumns(count, columns, j) + getHeaderRows(count, columns, i));
                }
            }
        }

        for (String list : Nextremes)
        {
            System.out.println(list);
        }
    }

    static void GoToRot(ArrayList<String> LExtremes, ArrayList<String> NExtremes)
    {
        RotMinimazer rotMinimazer = new RotMinimazer();
        RotMinimazer.sumC(LExtremes, NExtremes);
    }
}