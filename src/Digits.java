import acm.graphics.GImage;

/**
 * Created by davidmaccumber on 7/29/16.
 */
public class Digits {

    private GImage a;
    private GImage b;
    private GImage c;
    private GImage d;
    private String strNumber;
    private Board myBoard;

    private String units;
    private String tenths;
    private String hundredths;
    private String thousandths;

    public Digits(String strNumber, Board board)
    {
        this.strNumber = strNumber;
        myBoard = board;
    }

    public void showDigits()
    {
        setDigits();

        a = new GImage(units + ".png", 305, 4);
        b = new GImage(tenths + ".png", 273, 4);
        c = new GImage(hundredths + ".png", 244, 4);
        d = new GImage(thousandths + ".png", 215, 4);

        a.setSize(29, 40);      // 1.38 conversion const
        b.setSize(29, 40);
        c.setSize(29, 40);
        d.setSize(29, 40);

        myBoard.add(a);
        myBoard.add(b);
        myBoard.add(c);
        myBoard.add(d);
    }

    private void setDigits()
    {
        if (strNumber.length() == 4)
        {
            units = strNumber.substring(strNumber.length() - 1, strNumber.length());
            tenths = strNumber.substring(strNumber.length() - 2, strNumber.length() - 1);
            hundredths = strNumber.substring(strNumber.length() - 3, strNumber.length() - 2);
            thousandths = strNumber.substring(strNumber.length() - 4, strNumber.length() - 3);
        }

        else if (strNumber.length() == 3)
        {
            units = strNumber.substring(strNumber.length() - 1, strNumber.length());
            tenths = strNumber.substring(strNumber.length() - 2, strNumber.length() - 1);
            hundredths = strNumber.substring(strNumber.length() - 3, strNumber.length() - 2);
            thousandths = "Blank";
        }

        else if (strNumber.length() == 2)
        {
            units = strNumber.substring(strNumber.length() - 1, strNumber.length());
            tenths = strNumber.substring(strNumber.length() - 2, strNumber.length() - 1);
            hundredths = "Blank";
            thousandths = "Blank";
        }

        else if (strNumber.length() == 1)
        {
            units = strNumber.substring(strNumber.length() - 1, strNumber.length());
            tenths = "Blank";
            thousandths = "Blank";
            hundredths = "Blank";
        }

        else
        {
            units = "Blank";
            tenths = "Blank";
            hundredths = "Blank";
            thousandths = "Blank";
        }
    }
}
