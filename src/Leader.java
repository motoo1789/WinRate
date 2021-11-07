
public class Leader {
	private int Win;
	private int Loss;

	public Leader()
	{
		Win = 0;
		Loss = 0;
	}

	public int WinRead()
	{
		return Win;
	}

	public int LossRead()
	{
		return Loss;
	}

	public void Winplus()
	{
		Win++;
	}

	public void Lossplus()
	{
		Loss++;
	}

}
