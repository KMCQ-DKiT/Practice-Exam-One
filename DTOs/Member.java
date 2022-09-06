package DTOs;

public class Member
{

    private String name;
    private int numberVisits;
    private double costPerVisit;

    public Member(String name, int numberVisits, double costPerVisit)
    {
        this.name = name;
        this.numberVisits = numberVisits;
        setCostPerVisit(costPerVisit);
    }

    public Member()
    {
        name = "";
        numberVisits = 0;
        setCostPerVisit(0d);
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Get the value of numberVisits
     *
     * @return the value of numberVisits
     */
    public int getNumberVisits()
    {
        return numberVisits;
    }

    /**
     * Set the value of numberVisits
     *
     * @param numberVisits new value of numberVisits
     */
    public void setNumberVisits(int numberVisits)
    {
        this.numberVisits = numberVisits;
    }

    /**
     * Get the value of costPerVisit
     *
     * @return the value of costPerVisit
     */
    public double getCostPerVisit()
    {
        return costPerVisit;
    }

    /**
     * Set the value of costPerVisit
     *
     * @param costPerVisit new value of costPerVisit
     */
    public final void setCostPerVisit(double costPerVisit)
    {
        if (costPerVisit >= 0)
        {
            this.costPerVisit = costPerVisit;
        }
        else
        {
            this.costPerVisit = 0;

        }
    }

    @Override
    public String toString()
    {
        return "DTOs.Member{" + "name=" + name + ", numberVisits=" + numberVisits + ", costPerVisit=" + costPerVisit + '}';
    }

    
}
