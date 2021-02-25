public class DayWeekYearCalc {

    public static int [] FormatStringToArray(String pYear_String)
    {
        int[] Input_Year = new int[pYear_String.length()];

        for (int Index = 0; Index < pYear_String.length(); Index++) {
            Input_Year[Index] = pYear_String.charAt(Index)- '0'; //Abzählung beim Char =0
        }

        return Input_Year;
    }

    public static int Evaluation_LastNumberOfValue(int pDay, int pMonth, int pYear, int LastNumberOfValue) {

        LastNumberOfValue = (LastNumberOfValue+(LastNumberOfValue/4))+ pDay;

        if (pMonth == 1 || pMonth == 10)
        {
            return LastNumberOfValue + 1;
        }

        else if (pMonth == 2 || pMonth == 11 || pMonth == 3)
        {
            return LastNumberOfValue + 4;
        }

        else if (pMonth == 4 || pMonth == 7)
        {
            return LastNumberOfValue;
        }

        else if (pMonth == 5)
        {
            return  LastNumberOfValue + 2;
        }

        else if (pMonth == 6)
        {
            return LastNumberOfValue + 5;
        }

        else if (pMonth == 8)
        {
            return  LastNumberOfValue + 3;
        }

        else if (pMonth == 9 || pMonth == 12)
        {
            return  LastNumberOfValue + 6;
        }

        else if ((pYear % 400 == 0) && (pMonth == 2) || (pYear % 400 == 0) && (pMonth == 3))

        {
            return  LastNumberOfValue - 1;
        }


        else if (pYear % 4 == 0 && pYear % 100 != 0 && pMonth == 2 || pYear % 4 == 0 && pYear % 100 != 0 && pMonth == 3)
        {
            return  LastNumberOfValue - 1;
        }

        else {
            return 0;
        }
    }

    public static int Evaluation_LastNumberOfValue(int Input_Year [], int LastNumberOfValue)
    {
        if(Input_Year[0] == 1 && Input_Year[1]==9){
           return LastNumberOfValue ;
        }
        else if(Input_Year[0] == 2 && Input_Year[1]==0){
            return  LastNumberOfValue +6;
        }
        else if(Input_Year[0] == 1 && Input_Year[1]==8){
           return  LastNumberOfValue +2;
        }
        else if(Input_Year[0] == 2 && Input_Year[1]==1){
            return LastNumberOfValue +4;
        }
        else{
            return 0;
        }
    }


    public static int Weekday_Calculation(int LastNumberOfValue)
    {
        return LastNumberOfValue % 7;
    }
}