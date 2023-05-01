import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner choose = new Scanner(System.in);

        menu();

        int count;

        while (true)
        {
            System.out.println("Choose a minimization method");
            try
            {
                count = choose.nextInt();

                if (count >= 1 && count <= 3)
                {
                    break;
                }
                else
                {
                    System.out.println("Error. Print number from 1 to 3.");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Error. Print number from 1 to 3.");
                choose.nextLine();
            }
        }

        switch (count)
        {
            case 1:
                RotMinimazer rotMinimazer = new RotMinimazer();
                RotMinimazer.main(args);
                break;
            case 2:
                CarnoMinimazer carnoMinimazer = new CarnoMinimazer();
                CarnoMinimazer.main(args);
                break;
            case 3:
                VeitchMinimazer veitchMinimazer = new VeitchMinimazer();
                VeitchMinimazer.main(args);
                break;
        }

    }

    public static void menu()
    {
        System.out.println("Introduce the minimization method");
        System.out.println("---------------------------------");
        System.out.println("1.Rot minimized");
        System.out.println("2.Carno minimized");
        System.out.println("3.Veitch minimized");
    }
}