package scoring;
/**
 * Created by Abim, David and Ethan
 * AP Computer Science
 * August 2016
 */

import java.awt.*;
public class Score extends Boards
{
    private int score;

    public void add(int x)
    {
        score += x;
        if (score < 10) setLabel("000" + score);
        else if (score < 100) setLabel("00" + score);
        else if (score < 1000) setLabel("0" + score);
        else setLabel("" + score);
    }

    public Score (String str, int x, int y)
    {
        super(str, x, y);
        score = 0;
        setColor(Color.white);
        setFont("Frozen Crystal Bold-Bold-55");
    }

    public int getScore()
    {
        return score;
    }
}

