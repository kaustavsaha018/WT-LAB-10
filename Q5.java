import java.util.Scanner;

class HrsException extends Exception {
    private static final long serialVersionUID = 1L;

    HrsException(String s) {
        super(s);
    }
}

class MinException extends Exception {
    private static final long serialVersionUID = 1L;

    MinException(String s) {
        super(s);
    }
}

class SecException extends Exception {
    private static final long serialVersionUID = 1L;

    SecException(String s) {
        super(s);
    }
}

class Time {
    int hrs, min, sec;

    Time(int hrs, int min, int sec) {
        this.hrs = hrs;
        this.min = min;
        this.sec = sec;
    }

    void display() throws HrsException,MinException,SecException {
        if (hrs < 0 || hrs > 24)
            throw new HrsException("Either Hrs value is less than 0 or greater than 24");
        else
            System.out.print(hrs + " hr ");
        if (min < 0 || min > 60)
            throw new MinException("Either Min value is less than 0 or greater than 60");
        else
            System.out.print(min + " min ");
        if (sec < 0 || sec > 60)
            throw new SecException("Either Sec value is less than 0 or greater than 60");
        else
            System.out.print(sec + " sec");
    }
}

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the hrs value: ");
        int hours = sc.nextInt();
        System.out.print("Enter the min value: ");
        int minutes = sc.nextInt();
        System.out.print("Enter the sec value: ");
        int seconds = sc.nextInt();
        sc.close();

        Time mytime = new Time(hours,minutes,seconds);
        try{
            System.out.print("\nThe Time is: ");
            mytime.display();
        } 
        catch(HrsException e){
            System.out.println(e);
        }
        catch(MinException e){
            System.out.println(e);
        }
        catch(SecException e){
            System.out.println(e);
        }
    }
}
