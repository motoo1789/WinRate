
public class LeaderShelf implements Aggregate{
	private Leader leader[];
	private int last;
	private int index;


	public LeaderShelf(int maxsize) {
		this.leader = new Leader[maxsize];
		this.last = maxsize;
		this.index = 0;
		for(int i = 0; i < last; i++) leader[i] = new Leader();
	}

	public Leader TypeAt(int index)
	{
		return leader[index];
	}

	public int getlength()
	{
		return last;
	}

	public void chngeindex(int index) {
		this.index = index;
	}
//	public void appendType(Type type)
//	{
//		this.type[last] = type;
//	}

	public void Win()
	{
		leader[index].Winplus();
	}

	public void Loss()
	{
		leader[index].Lossplus();
	}

	public Iterator iterator()
	{
		return new LeaderShelfIterator(this);
	}

}
